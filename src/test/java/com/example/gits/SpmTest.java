package com.example.gits;

import com.example.gits.ctx.GitsDbms;
import com.example.gits.spm.GitsApplication;
import com.example.gits.spm.dbms.gitsdb.gitrepos.GitreposManager;
import org.junit.Test;

public class SpmTest {
    @Test
    public void helloSpm() {
        GitsApplication app = new GitsDbms().gitsApplication();
        GitreposManager rm = app.getOrThrow(GitreposManager.class);
        long count = rm.stream().count();
        System.out.println(count);
    }
}
