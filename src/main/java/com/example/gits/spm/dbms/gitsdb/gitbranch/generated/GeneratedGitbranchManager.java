package com.example.gits.spm.dbms.gitsdb.gitbranch.generated;

import com.example.gits.spm.dbms.gitsdb.gitbranch.Gitbranch;
import com.speedment.common.annotation.GeneratedCode;
import com.speedment.runtime.config.identifier.TableIdentifier;
import com.speedment.runtime.core.manager.Manager;
import com.speedment.runtime.field.Field;

import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.unmodifiableList;

/**
 * The generated base interface for the manager of every {@link
 * com.example.gits.spm.dbms.gitsdb.gitbranch.Gitbranch} entity.
 * <p>
 * This file has been automatically generated by Speedment. Any changes made to
 * it will be overwritten.
 * 
 * @author Speedment
 */
@GeneratedCode("Speedment")
public interface GeneratedGitbranchManager extends Manager<Gitbranch> {
    
    TableIdentifier<Gitbranch> IDENTIFIER = TableIdentifier.of("gits", "gits", "gitbranch");
    List<Field<Gitbranch>> FIELDS = unmodifiableList(asList(
        Gitbranch.ID,
        Gitbranch.PROJECT_ID,
        Gitbranch.NAME,
        Gitbranch.CHASH,
        Gitbranch.TAG,
        Gitbranch.MESSAGE,
        Gitbranch.CREATION_TIME,
        Gitbranch.UPDATE_TIME,
        Gitbranch.DELETED,
        Gitbranch.BASE,
        Gitbranch.BASELINE
    ));
    
    @Override
    default Class<Gitbranch> getEntityClass() {
        return Gitbranch.class;
    }
}