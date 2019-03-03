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
        Gitrepos abc = new GitreposImpl().setName("mybatis-plugin123")
                .setRepository("git@github.com:zscgrhg/mybatis-plugin.git");
        Git git = gitOperation.gitClone(abc);
        //gitOperation.gitBranchPush(git, "origin/master", "refs/heads/v1.1.4");

        List<DiffEntry> diff = gitOperation.diff(git, "v1.1.3", "v1.1.4");
        for (DiffEntry entry : diff) {
            System.out.println("Entry: " + entry);
        }
    }

    @Test
    public void testCreatBranch(){
        GitOperationImpl gitOperation = new GitOperationImpl();
        Gitrepos abc = new GitreposImpl().setName("pjgit")
                .setRepository("git@github.com:zscgrhg/pjgit.git");
        Git git = gitOperation.gitClone(abc);
        gitOperation.createBranch(git,"82c94b351ed36d6b0551e262334b794c3a81da83","ops1.2");

        List<DiffEntry> diff = gitOperation.diff(git, "ops1.1", "ops1.2");
        System.out.println(diff.size());
    }
    @Test
    public void testRevParse(){
        GitOperationImpl gitOperation = new GitOperationImpl();
        Gitrepos abc = new GitreposImpl().setName("pjgit")
                .setRepository("git@github.com:zscgrhg/pjgit.git");
        Git git = gitOperation.gitClone(abc);
        String s = gitOperation.revParse(git, "refs/remotes/origin/master");
        System.out.println(s);
    }
}
