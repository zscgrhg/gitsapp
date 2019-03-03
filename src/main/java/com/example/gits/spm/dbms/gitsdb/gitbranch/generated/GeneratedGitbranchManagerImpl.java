package com.example.gits.spm.dbms.gitsdb.gitbranch.generated;

import com.example.gits.spm.dbms.gitsdb.gitbranch.Gitbranch;
import com.example.gits.spm.dbms.gitsdb.gitbranch.GitbranchManager;
import com.speedment.common.annotation.GeneratedCode;
import com.speedment.runtime.config.identifier.TableIdentifier;
import com.speedment.runtime.core.manager.AbstractManager;
import com.speedment.runtime.field.Field;

import java.util.stream.Stream;

/**
 * The generated base implementation for the manager of every {@link
 * com.example.gits.spm.dbms.gitsdb.gitbranch.Gitbranch} entity.
 * <p>
 * This file has been automatically generated by Speedment. Any changes made to
 * it will be overwritten.
 * 
 * @author Speedment
 */
@GeneratedCode("Speedment")
public abstract class GeneratedGitbranchManagerImpl 
extends AbstractManager<Gitbranch> 
implements GeneratedGitbranchManager {
    
    private final TableIdentifier<Gitbranch> tableIdentifier;
    
    protected GeneratedGitbranchManagerImpl() {
        this.tableIdentifier = TableIdentifier.of("gits", "gits", "gitbranch");
    }
    
    @Override
    public TableIdentifier<Gitbranch> getTableIdentifier() {
        return tableIdentifier;
    }
    
    @Override
    public Stream<Field<Gitbranch>> fields() {
        return GitbranchManager.FIELDS.stream();
    }
    
    @Override
    public Stream<Field<Gitbranch>> primaryKeyFields() {
        return Stream.of(
            Gitbranch.ID,
            Gitbranch.PROJECT_ID
        );
    }
}