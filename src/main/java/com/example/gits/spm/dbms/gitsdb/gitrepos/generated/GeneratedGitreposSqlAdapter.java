package com.example.gits.spm.dbms.gitsdb.gitrepos.generated;

import com.example.gits.spm.dbms.gitsdb.gitrepos.Gitrepos;
import com.example.gits.spm.dbms.gitsdb.gitrepos.GitreposImpl;
import com.speedment.common.annotation.GeneratedCode;
import com.speedment.common.injector.annotation.ExecuteBefore;
import com.speedment.runtime.config.Project;
import com.speedment.runtime.config.identifier.TableIdentifier;
import com.speedment.runtime.core.component.ProjectComponent;
import com.speedment.runtime.core.component.SqlAdapter;
import com.speedment.runtime.core.component.sql.SqlTypeMapperHelper;
import com.speedment.runtime.core.db.SqlFunction;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import static com.speedment.common.injector.State.RESOLVED;

/**
 * The generated Sql Adapter for a {@link
 * com.example.gits.spm.dbms.gitsdb.gitrepos.Gitrepos} entity.
 * <p>
 * This file has been automatically generated by Speedment. Any changes made to
 * it will be overwritten.
 * 
 * @author Speedment
 */
@GeneratedCode("Speedment")
public abstract class GeneratedGitreposSqlAdapter implements SqlAdapter<Gitrepos> {
    
    private final TableIdentifier<Gitrepos> tableIdentifier;
    private SqlTypeMapperHelper<Timestamp, LocalDateTime> creationTimeHelper;
    private SqlTypeMapperHelper<Timestamp, LocalDateTime> updateTimeHelper;
    private SqlTypeMapperHelper<Byte, Boolean> deletedHelper;
    
    protected GeneratedGitreposSqlAdapter() {
        this.tableIdentifier = TableIdentifier.of("gits", "gits", "gitrepos");
    }
    
    protected Gitrepos apply(ResultSet resultSet, int offset) throws SQLException {
        return createEntity()
            .setId(           resultSet.getLong(1 + offset))
            .setName(         resultSet.getString(2 + offset))
            .setGroup(        resultSet.getString(3 + offset))
            .setRepository(   resultSet.getString(4 + offset))
            .setCreationTime( creationTimeHelper.apply(resultSet.getTimestamp(5 + offset)))
            .setUpdateTime(   updateTimeHelper.apply(resultSet.getTimestamp(6 + offset)))
            .setDeleted(      deletedHelper.apply(resultSet.getByte(7 + offset)))
            ;
    }
    
    protected GitreposImpl createEntity() {
        return new GitreposImpl();
    }
    
    @Override
    public TableIdentifier<Gitrepos> identifier() {
        return tableIdentifier;
    }
    
    @Override
    public SqlFunction<ResultSet, Gitrepos> entityMapper() {
        return entityMapper(0);
    }
    
    @Override
    public SqlFunction<ResultSet, Gitrepos> entityMapper(int offset) {
        return rs -> apply(rs, offset);
    }
    
    @ExecuteBefore(RESOLVED)
    void createHelpers(ProjectComponent projectComponent) {
        final Project project = projectComponent.getProject();
        creationTimeHelper = SqlTypeMapperHelper.create(project, Gitrepos.CREATION_TIME, Gitrepos.class);
        updateTimeHelper = SqlTypeMapperHelper.create(project, Gitrepos.UPDATE_TIME, Gitrepos.class);
        deletedHelper = SqlTypeMapperHelper.create(project, Gitrepos.DELETED, Gitrepos.class);
    }
}