package com.example.gits.service;

import com.example.gits.ctx.Dao;
import com.example.gits.jgit.GitOperation;
import com.example.gits.spm.dbms.gitsdb.gitbranch.Gitbranch;
import com.example.gits.spm.dbms.gitsdb.gitbranch.GitbranchImpl;
import com.example.gits.spm.dbms.gitsdb.gitrepos.Gitrepos;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.diff.DiffEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        dao.TX.createAndAccept(tx -> {
            repoList.parallelStream()
                    .map(r -> {
                        try (Git git = gitOperation.gitClone(r)) {
                            String chash = gitOperation.revParse(git, startRef);
                            gitOperation.gitBranchPush(git, chash, "refs/heads/" + b);
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

    @Override
    public Map<String, List<DiffEntry>> groupDiff(String branchName, String group) {
        List<Gitrepos> repoList = dao.REPOSITORY.stream()
                .filter(Gitrepos.GROUP.equalIgnoreCase(group))
                .collect(Collectors.toList());
        Stream<Map.Entry<String, List<DiffEntry>>> entryStream = repoList.parallelStream().map(rep -> {
            Optional<Gitbranch> gitbranch = dao.BRANCH.stream()
                    .filter(Gitbranch.PROJECT_ID.equal(rep.getId()).and(Gitbranch.NAME.endsWithIgnoreCase(branchName)))
                    .findFirst();
            List<DiffEntry> diffEntries = gitbranch.map(g -> {
                try (Git git = gitOperation.gitClone(rep)) {
                    String name = g.getName();
                    String newHash = gitOperation.revParse(git, "refs/remotes/origin/" + name);
                    String oldHash = g.getBaseChash();
                    return gitOperation.diffChash(git, oldHash, newHash);
                }
            }).orElse(Collections.emptyList());
            return Collections.singletonMap(rep.getName(), diffEntries);
        }).flatMap(m -> m.entrySet().stream());
        Map<String, List<DiffEntry>> data = entryStream.collect(Collectors.groupingBy(e -> e.getKey(),
                Collectors.reducing(Collections.emptyList(), x -> x.getValue(), (x1, x2) -> {
                    List<DiffEntry> ret = new ArrayList<>();
                    ret.addAll(x1);
                    ret.addAll(x2);
                    return ret;
                })));
        return data;
    }
}
