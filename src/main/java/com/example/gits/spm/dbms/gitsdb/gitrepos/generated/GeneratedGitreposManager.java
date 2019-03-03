package com.example.gits.spm.dbms.gitsdb.gitrepos.generated;

import com.example.gits.spm.dbms.gitsdb.gitrepos.Gitrepos;
import com.speedment.common.annotation.GeneratedCode;
import com.speedment.runtime.config.identifier.TableIdentifier;
import com.speedment.runtime.core.manager.Manager;
import com.speedment.runtime.field.Field;

import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.unmodifiableList;

/**
 * The generated base interface for the manager of every {@link
 * com.example.gits.spm.dbms.gitsdb.gitrepos.Gitrepos} entity.
 * <p>
 * This file has been automatically generated by Speedment. Any changes made to
 * it will be overwritten.
 * 
 * @author Speedment
 */
@GeneratedCode("Speedment")
public interface GeneratedGitreposManager extends Manager<Gitrepos> {
    
    TableIdentifier<Gitrepos> IDENTIFIER = TableIdentifier.of("gits", "gits", "gitrepos");
    List<Field<Gitrepos>> FIELDS = unmodifiableList(asList(
        Gitrepos.ID,
        Gitrepos.NAME,
        Gitrepos.GROUP,
        Gitrepos.REPOSITORY,
        Gitrepos.CREATION_TIME,
        Gitrepos.UPDATE_TIME,
        Gitrepos.DELETED
    ));
    
    @Override
    default Class<Gitrepos> getEntityClass() {
        return Gitrepos.class;
    }
}