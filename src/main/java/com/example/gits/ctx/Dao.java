package com.example.gits.ctx;


import com.example.gits.spm.GitsApplication;
import com.example.gits.spm.dbms.gitsdb.gitbranch.GitbranchManager;
import com.example.gits.spm.dbms.gitsdb.gitrepos.GitreposManager;
import com.speedment.runtime.core.component.transaction.TransactionComponent;
import com.speedment.runtime.core.component.transaction.TransactionHandler;
import org.springframework.stereotype.Component;

@Component
public class Dao {
    public final GitsApplication APP;
    public final GitreposManager REPOSITORY;
    public final GitbranchManager BRANCH;
    public final TransactionComponent TC;
    public final TransactionHandler TX;

    public Dao(GitsApplication APP) {
        this.APP = APP;
        this.REPOSITORY = APP.getOrThrow(GitreposManager.class);
        this.BRANCH = APP.getOrThrow(GitbranchManager.class);
        TC = APP.getOrThrow(TransactionComponent.class);
        TX = TC.createTransactionHandler();
    }
}
