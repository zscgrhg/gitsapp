package com.example.gits.spm.dbms.gitsdb.gitrepos.generated;

import com.example.gits.spm.dbms.gitsdb.gitrepos.Gitrepos;
import com.speedment.common.annotation.GeneratedCode;
import com.speedment.runtime.config.identifier.ColumnIdentifier;
import com.speedment.runtime.config.identifier.TableIdentifier;
import com.speedment.runtime.field.BooleanField;
import com.speedment.runtime.field.ComparableField;
import com.speedment.runtime.field.LongField;
import com.speedment.runtime.field.StringField;
import com.speedment.runtime.typemapper.TypeMapper;
import com.speedment.runtime.typemapper.bytes.ByteZeroOneToBooleanMapper;
import com.speedment.runtime.typemapper.time.TimestampToLocalDateTimeMapper;

import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * The generated base for the {@link
 * com.example.gits.spm.dbms.gitsdb.gitrepos.Gitrepos}-interface representing
 * entities of the {@code gitrepos}-table in the database.
 * <p>
 * This file has been automatically generated by Speedment. Any changes made to
 * it will be overwritten.
 * 
 * @author Speedment
 */
@GeneratedCode("Speedment")
public interface GeneratedGitrepos {
    
    /**
     * This Field corresponds to the {@link Gitrepos} field that can be obtained
     * using the {@link Gitrepos#getId()} method.
     */
    LongField<Gitrepos, Long> ID = LongField.create(
        Identifier.ID,
        Gitrepos::getId,
        Gitrepos::setId,
        TypeMapper.primitive(),
        true
    );
    /**
     * This Field corresponds to the {@link Gitrepos} field that can be obtained
     * using the {@link Gitrepos#getName()} method.
     */
    StringField<Gitrepos, String> NAME = StringField.create(
        Identifier.NAME,
        Gitrepos::getName,
        Gitrepos::setName,
        TypeMapper.identity(),
        false
    );
    /**
     * This Field corresponds to the {@link Gitrepos} field that can be obtained
     * using the {@link Gitrepos#getGroup()} method.
     */
    StringField<Gitrepos, String> GROUP = StringField.create(
        Identifier.GROUP,
        Gitrepos::getGroup,
        Gitrepos::setGroup,
        TypeMapper.identity(),
        false
    );
    /**
     * This Field corresponds to the {@link Gitrepos} field that can be obtained
     * using the {@link Gitrepos#getRepository()} method.
     */
    StringField<Gitrepos, String> REPOSITORY = StringField.create(
        Identifier.REPOSITORY,
        Gitrepos::getRepository,
        Gitrepos::setRepository,
        TypeMapper.identity(),
        false
    );
    /**
     * This Field corresponds to the {@link Gitrepos} field that can be obtained
     * using the {@link Gitrepos#getCreationTime()} method.
     */
    ComparableField<Gitrepos, Timestamp, LocalDateTime> CREATION_TIME = ComparableField.create(
        Identifier.CREATION_TIME,
        Gitrepos::getCreationTime,
        Gitrepos::setCreationTime,
        new TimestampToLocalDateTimeMapper(),
        false
    );
    /**
     * This Field corresponds to the {@link Gitrepos} field that can be obtained
     * using the {@link Gitrepos#getUpdateTime()} method.
     */
    ComparableField<Gitrepos, Timestamp, LocalDateTime> UPDATE_TIME = ComparableField.create(
        Identifier.UPDATE_TIME,
        Gitrepos::getUpdateTime,
        Gitrepos::setUpdateTime,
        new TimestampToLocalDateTimeMapper(),
        false
    );
    /**
     * This Field corresponds to the {@link Gitrepos} field that can be obtained
     * using the {@link Gitrepos#getDeleted()} method.
     */
    BooleanField<Gitrepos, Byte> DELETED = BooleanField.create(
        Identifier.DELETED,
        Gitrepos::getDeleted,
        Gitrepos::setDeleted,
        new ByteZeroOneToBooleanMapper(),
        false
    );
    
    /**
     * Returns the id of this Gitrepos. The id field corresponds to the database
     * column gits.gits.gitrepos.id.
     * 
     * @return the id of this Gitrepos
     */
    long getId();
    
    /**
     * Returns the name of this Gitrepos. The name field corresponds to the
     * database column gits.gits.gitrepos.name.
     * 
     * @return the name of this Gitrepos
     */
    String getName();
    
    /**
     * Returns the group of this Gitrepos. The group field corresponds to the
     * database column gits.gits.gitrepos.group.
     * 
     * @return the group of this Gitrepos
     */
    String getGroup();
    
    /**
     * Returns the repository of this Gitrepos. The repository field corresponds
     * to the database column gits.gits.gitrepos.repository.
     * 
     * @return the repository of this Gitrepos
     */
    String getRepository();
    
    /**
     * Returns the creationTime of this Gitrepos. The creationTime field
     * corresponds to the database column gits.gits.gitrepos.creation_time.
     * 
     * @return the creationTime of this Gitrepos
     */
    LocalDateTime getCreationTime();
    
    /**
     * Returns the updateTime of this Gitrepos. The updateTime field corresponds
     * to the database column gits.gits.gitrepos.update_time.
     * 
     * @return the updateTime of this Gitrepos
     */
    LocalDateTime getUpdateTime();
    
    /**
     * Returns the deleted of this Gitrepos. The deleted field corresponds to
     * the database column gits.gits.gitrepos.deleted.
     * 
     * @return the deleted of this Gitrepos
     */
    boolean getDeleted();
    
    /**
     * Sets the id of this Gitrepos. The id field corresponds to the database
     * column gits.gits.gitrepos.id.
     * 
     * @param id to set of this Gitrepos
     * @return   this Gitrepos instance
     */
    Gitrepos setId(long id);
    
    /**
     * Sets the name of this Gitrepos. The name field corresponds to the
     * database column gits.gits.gitrepos.name.
     * 
     * @param name to set of this Gitrepos
     * @return     this Gitrepos instance
     */
    Gitrepos setName(String name);
    
    /**
     * Sets the group of this Gitrepos. The group field corresponds to the
     * database column gits.gits.gitrepos.group.
     * 
     * @param group to set of this Gitrepos
     * @return      this Gitrepos instance
     */
    Gitrepos setGroup(String group);
    
    /**
     * Sets the repository of this Gitrepos. The repository field corresponds to
     * the database column gits.gits.gitrepos.repository.
     * 
     * @param repository to set of this Gitrepos
     * @return           this Gitrepos instance
     */
    Gitrepos setRepository(String repository);
    
    /**
     * Sets the creationTime of this Gitrepos. The creationTime field
     * corresponds to the database column gits.gits.gitrepos.creation_time.
     * 
     * @param creationTime to set of this Gitrepos
     * @return             this Gitrepos instance
     */
    Gitrepos setCreationTime(LocalDateTime creationTime);
    
    /**
     * Sets the updateTime of this Gitrepos. The updateTime field corresponds to
     * the database column gits.gits.gitrepos.update_time.
     * 
     * @param updateTime to set of this Gitrepos
     * @return           this Gitrepos instance
     */
    Gitrepos setUpdateTime(LocalDateTime updateTime);
    
    /**
     * Sets the deleted of this Gitrepos. The deleted field corresponds to the
     * database column gits.gits.gitrepos.deleted.
     * 
     * @param deleted to set of this Gitrepos
     * @return        this Gitrepos instance
     */
    Gitrepos setDeleted(boolean deleted);
    
    enum Identifier implements ColumnIdentifier<Gitrepos> {
        
        ID            ("id"),
        NAME          ("name"),
        GROUP         ("group"),
        REPOSITORY    ("repository"),
        CREATION_TIME ("creation_time"),
        UPDATE_TIME   ("update_time"),
        DELETED       ("deleted");
        
        private final String columnId;
        private final TableIdentifier<Gitrepos> tableIdentifier;
        
        Identifier(String columnId) {
            this.columnId        = columnId;
            this.tableIdentifier = TableIdentifier.of(    getDbmsId(), 
                getSchemaId(), 
                getTableId());
        }
        
        @Override
        public String getDbmsId() {
            return "gits";
        }
        
        @Override
        public String getSchemaId() {
            return "gits";
        }
        
        @Override
        public String getTableId() {
            return "gitrepos";
        }
        
        @Override
        public String getColumnId() {
            return this.columnId;
        }
        
        @Override
        public TableIdentifier<Gitrepos> asTableIdentifier() {
            return this.tableIdentifier;
        }
    }
}