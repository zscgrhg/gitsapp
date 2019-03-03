package com.example.gits.service;

import com.example.gits.ctx.Dao;
import com.example.gits.jgit.GitOperation;
import com.example.gits.spm.dbms.gitsdb.gitrepos.Gitrepos;
import org.eclipse.jgit.api.Git;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;

@Service
public class BranchServiceImpl implements BranchService {

    @Autowired
    Dao dao;
    @Autowired
    GitOperation gitOperation;
    @Override
    public void createBranch(String g,String b) {
        List<Gitrepos> repoList = dao.REPOSITORY.stream()
                .filter(Gitrepos.GROUP.equalIgnoreCase(g))
                .collect(Collectors.toList());
        repoList.parallelStream()
                .map(r->{
                    try(Git git = gitOperation.gitClone(r)){
                        String chash = gitOperation.revParse(git, "refs/remotes/origin/master");
                        gitOperation.gitBranchPush(git,chash,"refs/heads/"+b);
                        return chash;
                    }
                }).collect(Collectors.toList());
    }
}
