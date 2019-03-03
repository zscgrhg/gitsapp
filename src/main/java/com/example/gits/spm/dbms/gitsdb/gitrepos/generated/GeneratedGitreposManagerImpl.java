package com.example.gits.spm.dbms.gitsdb.gitrepos.generated;

import com.example.gits.spm.dbms.gitsdb.gitrepos.Gitrepos;
import com.example.gits.spm.dbms.gitsdb.gitrepos.GitreposManager;
import com.speedment.common.annotation.GeneratedCode;
import com.speedment.runtime.config.identifier.TableIdentifier;
import com.speedment.runtime.core.manager.AbstractManager;
import com.speedment.runtime.field.Field;

import java.util.stream.Stream;

/**
 * The generated base implementation for the manager of every {@link
 * com.example.gits.spm.dbms.gitsdb.gitrepos.Gitrepos} entity.
 * <p>
 * This file has been automatically generated by Speedment. Any changes made to
 * it will be overwritten.
 * 
 * @author Speedment
 */
@GeneratedCode("Speedment")
public abstract class GeneratedGitreposManagerImpl 
extends AbstractManager<Gitrepos> 
implements GeneratedGitreposManager {
    
    private final TableIdentifier<Gitrepos> tableIdentifier;
    
    protected GeneratedGitreposManagerImpl() {
        this.tableIdentifier = TableIdentifier.of("gits", "gits", "gitrepos");
    }
    
    @Override
    public TableIdentifier<Gitrepos> getTableIdentifier() {
        return tableIdentifier;
    }
    
    @Override
    public Stream<Field<Gitrepos>> fields() {
        return GitreposManager.FIELDS.stream();
    }
    
    @Override
    public Stream<Field<Gitrepos>> primaryKeyFields() {
        return Stream.of(
            Gitrepos.ID
        );
    }
}