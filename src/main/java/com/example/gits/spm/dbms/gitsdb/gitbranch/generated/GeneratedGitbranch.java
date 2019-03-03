package com.example.gits.spm.dbms.gitsdb.gitbranch.generated;

import com.example.gits.spm.dbms.gitsdb.gitbranch.Gitbranch;
import com.example.gits.spm.dbms.gitsdb.gitrepos.Gitrepos;
import com.speedment.common.annotation.GeneratedCode;
import com.speedment.runtime.config.identifier.ColumnIdentifier;
import com.speedment.runtime.config.identifier.TableIdentifier;
import com.speedment.runtime.core.manager.Manager;
import com.speedment.runtime.field.BooleanField;
import com.speedment.runtime.field.ComparableField;
import com.speedment.runtime.field.LongField;
import com.speedment.runtime.field.LongForeignKeyField;
import com.speedment.runtime.field.StringField;
import com.speedment.runtime.typemapper.TypeMapper;
import com.speedment.runtime.typemapper.bytes.ByteZeroOneToBooleanMapper;
import com.speedment.runtime.typemapper.time.TimestampToLocalDateTimeMapper;

import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * The generated base for the {@link
 * com.example.gits.spm.dbms.gitsdb.gitbranch.Gitbranch}-interface representing
 * entities of the {@code gitbranch}-table in the database.
 * <p>
 * This file has been automatically generated by Speedment. Any changes made to
 * it will be overwritten.
 * 
 * @author Speedment
 */
@GeneratedCode("Speedment")
public interface GeneratedGitbranch {
    
    /**
     * This Field corresponds to the {@link Gitbranch} field that can be
     * obtained using the {@link Gitbranch#getId()} method.
     */
    LongField<Gitbranch, Long> ID = LongField.create(
        Identifier.ID,
        Gitbranch::getId,
        Gitbranch::setId,
        TypeMapper.primitive(),
        false
    );
    /**
     * This Field corresponds to the {@link Gitbranch} field that can be
     * obtained using the {@link Gitbranch#getProjectId()} method.
     */
    LongForeignKeyField<Gitbranch, Long, Gitrepos> PROJECT_ID = LongForeignKeyField.create(
        Identifier.PROJECT_ID,
        Gitbranch::getProjectId,
        Gitbranch::setProjectId,
        Gitrepos.ID,
        TypeMapper.primitive(),
        false
    );
    /**
     * This Field corresponds to the {@link Gitbranch} field that can be
     * obtained using the {@link Gitbranch#getName()} method.
     */
    StringField<Gitbranch, String> NAME = StringField.create(
        Identifier.NAME,
        Gitbranch::getName,
        Gitbranch::setName,
        TypeMapper.identity(),
        false
    );
    /**
     * This Field corresponds to the {@link Gitbranch} field that can be
     * obtained using the {@link Gitbranch#getChash()} method.
     */
    StringField<Gitbranch, String> CHASH = StringField.create(
        Identifier.CHASH,
        Gitbranch::getChash,
        Gitbranch::setChash,
        TypeMapper.identity(),
        false
    );
    /**
     * This Field corresponds to the {@link Gitbranch} field that can be
     * obtained using the {@link Gitbranch#getTag()} method.
     */
    StringField<Gitbranch, String> TAG = StringField.create(
        Identifier.TAG,
        Gitbranch::getTag,
        Gitbranch::setTag,
        TypeMapper.identity(),
        false
    );
    /**
     * This Field corresponds to the {@link Gitbranch} field that can be
     * obtained using the {@link Gitbranch#getMessage()} method.
     */
    StringField<Gitbranch, String> MESSAGE = StringField.create(
        Identifier.MESSAGE,
        Gitbranch::getMessage,
        Gitbranch::setMessage,
        TypeMapper.identity(),
        false
    );
    /**
     * This Field corresponds to the {@link Gitbranch} field that can be
     * obtained using the {@link Gitbranch#getCreationTime()} method.
     */
    ComparableField<Gitbranch, Timestamp, LocalDateTime> CREATION_TIME = ComparableField.create(
        Identifier.CREATION_TIME,
        Gitbranch::getCreationTime,
        Gitbranch::setCreationTime,
        new TimestampToLocalDateTimeMapper(),
        false
    );
    /**
     * This Field corresponds to the {@link Gitbranch} field that can be
     * obtained using the {@link Gitbranch#getUpdateTime()} method.
     */
    ComparableField<Gitbranch, Timestamp, LocalDateTime> UPDATE_TIME = ComparableField.create(
        Identifier.UPDATE_TIME,
        Gitbranch::getUpdateTime,
        Gitbranch::setUpdateTime,
        new TimestampToLocalDateTimeMapper(),
        false
    );
    /**
     * This Field corresponds to the {@link Gitbranch} field that can be
     * obtained using the {@link Gitbranch#getDeleted()} method.
     */
    BooleanField<Gitbranch, Byte> DELETED = BooleanField.create(
        Identifier.DELETED,
        Gitbranch::getDeleted,
        Gitbranch::setDeleted,
        new ByteZeroOneToBooleanMapper(),
        false
    );
    /**
     * This Field corresponds to the {@link Gitbranch} field that can be
     * obtained using the {@link Gitbranch#getBase()} method.
     */
    StringField<Gitbranch, String> BASE = StringField.create(
        Identifier.BASE,
        Gitbranch::getBase,
        Gitbranch::setBase,
        TypeMapper.identity(),
        false
    );
    /**
     * This Field corresponds to the {@link Gitbranch} field that can be
     * obtained using the {@link Gitbranch#getBaseline()} method.
     */
    ComparableField<Gitbranch, Timestamp, Timestamp> BASELINE = ComparableField.create(
        Identifier.BASELINE,
        Gitbranch::getBaseline,
        Gitbranch::setBaseline,
        TypeMapper.identity(),
        false
    );
    
    /**
     * Returns the id of this Gitbranch. The id field corresponds to the
     * database column gits.gits.gitbranch.id.
     * 
     * @return the id of this Gitbranch
     */
    long getId();
    
    /**
     * Returns the projectId of this Gitbranch. The projectId field corresponds
     * to the database column gits.gits.gitbranch.project_id.
     * 
     * @return the projectId of this Gitbranch
     */
    long getProjectId();
    
    /**
     * Returns the name of this Gitbranch. The name field corresponds to the
     * database column gits.gits.gitbranch.name.
     * 
     * @return the name of this Gitbranch
     */
    String getName();
    
    /**
     * Returns the chash of this Gitbranch. The chash field corresponds to the
     * database column gits.gits.gitbranch.chash.
     * 
     * @return the chash of this Gitbranch
     */
    String getChash();
    
    /**
     * Returns the tag of this Gitbranch. The tag field corresponds to the
     * database column gits.gits.gitbranch.tag.
     * 
     * @return the tag of this Gitbranch
     */
    String getTag();
    
    /**
     * Returns the message of this Gitbranch. The message field corresponds to
     * the database column gits.gits.gitbranch.message.
     * 
     * @return the message of this Gitbranch
     */
    String getMessage();
    
    /**
     * Returns the creationTime of this Gitbranch. The creationTime field
     * corresponds to the database column gits.gits.gitbranch.creation_time.
     * 
     * @return the creationTime of this Gitbranch
     */
    LocalDateTime getCreationTime();
    
    /**
     * Returns the updateTime of this Gitbranch. The updateTime field
     * corresponds to the database column gits.gits.gitbranch.update_time.
     * 
     * @return the updateTime of this Gitbranch
     */
    LocalDateTime getUpdateTime();
    
    /**
     * Returns the deleted of this Gitbranch. The deleted field corresponds to
     * the database column gits.gits.gitbranch.deleted.
     * 
     * @return the deleted of this Gitbranch
     */
    boolean getDeleted();
    
    /**
     * Returns the base of this Gitbranch. The base field corresponds to the
     * database column gits.gits.gitbranch.base.
     * 
     * @return the base of this Gitbranch
     */
    String getBase();
    
    /**
     * Returns the baseline of this Gitbranch. The baseline field corresponds to
     * the database column gits.gits.gitbranch.baseline.
     * 
     * @return the baseline of this Gitbranch
     */
    Timestamp getBaseline();
    
    /**
     * Sets the id of this Gitbranch. The id field corresponds to the database
     * column gits.gits.gitbranch.id.
     * 
     * @param id to set of this Gitbranch
     * @return   this Gitbranch instance
     */
    Gitbranch setId(long id);
    
    /**
     * Sets the projectId of this Gitbranch. The projectId field corresponds to
     * the database column gits.gits.gitbranch.project_id.
     * 
     * @param projectId to set of this Gitbranch
     * @return          this Gitbranch instance
     */
    Gitbranch setProjectId(long projectId);
    
    /**
     * Sets the name of this Gitbranch. The name field corresponds to the
     * database column gits.gits.gitbranch.name.
     * 
     * @param name to set of this Gitbranch
     * @return     this Gitbranch instance
     */
    Gitbranch setName(String name);
    
    /**
     * Sets the chash of this Gitbranch. The chash field corresponds to the
     * database column gits.gits.gitbranch.chash.
     * 
     * @param chash to set of this Gitbranch
     * @return      this Gitbranch instance
     */
    Gitbranch setChash(String chash);
    
    /**
     * Sets the tag of this Gitbranch. The tag field corresponds to the database
     * column gits.gits.gitbranch.tag.
     * 
     * @param tag to set of this Gitbranch
     * @return    this Gitbranch instance
     */
    Gitbranch setTag(String tag);
    
    /**
     * Sets the message of this Gitbranch. The message field corresponds to the
     * database column gits.gits.gitbranch.message.
     * 
     * @param message to set of this Gitbranch
     * @return        this Gitbranch instance
     */
    Gitbranch setMessage(String message);
    
    /**
     * Sets the creationTime of this Gitbranch. The creationTime field
     * corresponds to the database column gits.gits.gitbranch.creation_time.
     * 
     * @param creationTime to set of this Gitbranch
     * @return             this Gitbranch instance
     */
    Gitbranch setCreationTime(LocalDateTime creationTime);
    
    /**
     * Sets the updateTime of this Gitbranch. The updateTime field corresponds
     * to the database column gits.gits.gitbranch.update_time.
     * 
     * @param updateTime to set of this Gitbranch
     * @return           this Gitbranch instance
     */
    Gitbranch setUpdateTime(LocalDateTime updateTime);
    
    /**
     * Sets the deleted of this Gitbranch. The deleted field corresponds to the
     * database column gits.gits.gitbranch.deleted.
     * 
     * @param deleted to set of this Gitbranch
     * @return        this Gitbranch instance
     */
    Gitbranch setDeleted(boolean deleted);
    
    /**
     * Sets the base of this Gitbranch. The base field corresponds to the
     * database column gits.gits.gitbranch.base.
     * 
     * @param base to set of this Gitbranch
     * @return     this Gitbranch instance
     */
    Gitbranch setBase(String base);
    
    /**
     * Sets the baseline of this Gitbranch. The baseline field corresponds to
     * the database column gits.gits.gitbranch.baseline.
     * 
     * @param baseline to set of this Gitbranch
     * @return         this Gitbranch instance
     */
    Gitbranch setBaseline(Timestamp baseline);
    
    /**
     * Queries the specified manager for the referenced Gitrepos. If no such
     * Gitrepos exists, an {@code NullPointerException} will be thrown.
     * 
     * @param foreignManager the manager to query for the entity
     * @return               the foreign entity referenced
     */
    Gitrepos findProjectId(Manager<Gitrepos> foreignManager);
    
    enum Identifier implements ColumnIdentifier<Gitbranch> {
        
        ID            ("id"),
        PROJECT_ID    ("project_id"),
        NAME          ("name"),
        CHASH         ("chash"),
        TAG           ("tag"),
        MESSAGE       ("message"),
        CREATION_TIME ("creation_time"),
        UPDATE_TIME   ("update_time"),
        DELETED       ("deleted"),
        BASE          ("base"),
        BASELINE      ("baseline");
        
        private final String columnId;
        private final TableIdentifier<Gitbranch> tableIdentifier;
        
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
            return "gitbranch";
        }
        
        @Override
        public String getColumnId() {
            return this.columnId;
        }
        
        @Override
        public TableIdentifier<Gitbranch> asTableIdentifier() {
            return this.tableIdentifier;
        }
    }
}