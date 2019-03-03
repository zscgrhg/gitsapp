package com.example.gits;


import com.example.gits.jgit.GitOperationImpl;
import com.example.gits.spm.dbms.gitsdb.gitrepos.Gitrepos;
import com.example.gits.spm.dbms.gitsdb.gitrepos.GitreposImpl;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.diff.DiffEntry;
import org.junit.Test;

import java.util.List;

public class GitOperationImplTest {
    @Test
    public void testClone() {
        GitOperationImpl gitOperation = new GitOperationImpl();
        Gitrepos abc = new GitreposImpl().setName("mybatis-plugin")
                .setRepository("git@github.com:zscgrhg/mybatis-plugin.git");
        Git git = gitOperation.gitClone(abc);
        gitOperation.gitBranchPush(git, "origin/master", "refs/heads/v1.1.4");

        List<DiffEntry> diff = gitOperation.diff(git, "v1.1.3", "v1.1.4");
        for (DiffEntry entry : diff) {
            System.out.println("Entry: " + entry);

        }
    }
}
