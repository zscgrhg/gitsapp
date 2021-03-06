package com.example.gits.spm.dbms.gitsdb.gitbranch.generated;

import com.example.gits.spm.dbms.gitsdb.gitbranch.Gitbranch;
import com.example.gits.spm.dbms.gitsdb.gitbranch.GitbranchImpl;
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
 * com.example.gits.spm.dbms.gitsdb.gitbranch.Gitbranch} entity.
 * <p>
 * This file has been automatically generated by Speedment. Any changes made to
 * it will be overwritten.
 * 
 * @author Speedment
 */
@GeneratedCode("Speedment")
public abstract class GeneratedGitbranchSqlAdapter implements SqlAdapter<Gitbranch> {
    
    private final TableIdentifier<Gitbranch> tableIdentifier;
    private SqlTypeMapperHelper<Timestamp, LocalDateTime> baselineHelper;
    private SqlTypeMapperHelper<Timestamp, LocalDateTime> creationTimeHelper;
    private SqlTypeMapperHelper<Timestamp, LocalDateTime> updateTimeHelper;
    private SqlTypeMapperHelper<Byte, Boolean> deletedHelper;
    
    protected GeneratedGitbranchSqlAdapter() {
        this.tableIdentifier = TableIdentifier.of("gits", "gits", "gitbranch");
    }
    
    protected Gitbranch apply(ResultSet resultSet, int offset) throws SQLException {
        return createEntity()
            .setId(           resultSet.getLong(1 + offset))
            .setProjectId(    resultSet.getLong(2 + offset))
            .setName(         resultSet.getString(3 + offset))
            .setBaseChash(    resultSet.getString(4 + offset))
            .setBaseRef(      resultSet.getString(5 + offset))
            .setBaseline(     baselineHelper.apply(resultSet.getTimestamp(6 + offset)))
            .setCreationTime( creationTimeHelper.apply(resultSet.getTimestamp(7 + offset)))
            .setUpdateTime(   updateTimeHelper.apply(resultSet.getTimestamp(8 + offset)))
            .setDeleted(      deletedHelper.apply(resultSet.getByte(9 + offset)))
            ;
    }
    
    protected GitbranchImpl createEntity() {
        return new GitbranchImpl();
    }
    
    @Override
    public TableIdentifier<Gitbranch> identifier() {
        return tableIdentifier;
    }
    
    @Override
    public SqlFunction<ResultSet, Gitbranch> entityMapper() {
        return entityMapper(0);
    }
    
    @Override
    public SqlFunction<ResultSet, Gitbranch> entityMapper(int offset) {
        return rs -> apply(rs, offset);
    }
    
    @ExecuteBefore(RESOLVED)
    void createHelpers(ProjectComponent projectComponent) {
        final Project project = projectComponent.getProject();
        baselineHelper = SqlTypeMapperHelper.create(project, Gitbranch.BASELINE, Gitbranch.class);
        creationTimeHelper = SqlTypeMapperHelper.create(project, Gitbranch.CREATION_TIME, Gitbranch.class);
        updateTimeHelper = SqlTypeMapperHelper.create(project, Gitbranch.UPDATE_TIME, Gitbranch.class);
        deletedHelper = SqlTypeMapperHelper.create(project, Gitbranch.DELETED, Gitbranch.class);
    }
}