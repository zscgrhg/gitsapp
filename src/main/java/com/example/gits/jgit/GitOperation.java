package com.example.gits.jgit;

import com.example.gits.spm.dbms.gitsdb.gitrepos.Gitrepos;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.diff.DiffEntry;

import java.util.List;

public interface GitOperation {
    Git gitClone(Gitrepos repository);

    void gitCheckout(Git git, String start, String branchName);

    void gitBranchPush(Git git, String source, String dest);

    void createBranch(Git git, String start, String branchName);

    String revParse(Git git,String ref);

    List<DiffEntry> diff(Git git, String oldRef, String newRef);

    List<DiffEntry> diffChash(Git git, String oldHash, String newHash);
}
