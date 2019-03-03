package com.example.gits.service;

import com.example.gits.ctx.Dao;
import com.example.gits.jgit.GitOperation;
import com.example.gits.spm.dbms.gitsdb.gitbranch.Gitbranch;
import com.example.gits.spm.dbms.gitsdb.gitbranch.GitbranchImpl;
import com.example.gits.spm.dbms.gitsdb.gitrepos.Gitrepos;
import org.eclipse.jgit.api.Git;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;

@Service
public class BranchServiceImpl implements BranchService {

    @Autowired
    Dao dao;
    @Autowired
    GitOperation gitOperation;
    @Override
    public void createRemoteBranch(String g, String startRef, String b) {
        final LocalDateTime now = LocalDateTime.now();
        List<Gitrepos> repoList = dao.REPOSITORY.stream()
                .filter(Gitrepos.GROUP.equalIgnoreCase(g))
                .collect(Collectors.toList());
        dao.TX.createAndAccept(tx->{
            repoList.parallelStream()
                    .map(r->{
                        try(Git git = gitOperation.gitClone(r)){
                            String chash = gitOperation.revParse(git, startRef);
                            gitOperation.gitBranchPush(git,chash,"refs/heads/"+b);
                            Gitbranch gitbranch = new GitbranchImpl()
                                    .setBaseChash(chash)
                                    .setBaseRef(startRef)
                                    .setBaseline(now)
                                    .setCreationTime(now)
                                    .setUpdateTime(now)
                                    .setName(b)
                                    .setProjectId(r.getId());
                            return gitbranch;
                        }
                    }).collect(Collectors.toList())
                    .stream()
                    .forEach(dao.BRANCH.persister());
            tx.commit();
        });

    }
}
