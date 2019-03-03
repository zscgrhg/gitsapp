package com.example.gits;

import com.example.gits.jgit.SshTransportConfigCallback;
import org.eclipse.jgit.api.Git;
import org.junit.Test;

import java.io.File;

public class JGitTest {
    @Test
    public void testClone() throws Exception{
        File workingDir = new File("D:\\aaa\\git-easier\\workspace\\test");


        Git git = Git
                .cloneRepository()

                .setDirectory(workingDir)

                .setTransportConfigCallback(SshTransportConfigCallback.INSTANCE)

                .setURI("git@github.com:zscgrhg/progit123.git")

                .call();


        git
                .log()
                .call();
    }
}
