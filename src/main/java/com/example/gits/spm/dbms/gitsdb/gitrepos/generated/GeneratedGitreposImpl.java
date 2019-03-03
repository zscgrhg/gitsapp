package com.example.gits.spm.dbms.gitsdb.gitrepos.generated;

import com.example.gits.spm.dbms.gitsdb.gitrepos.Gitrepos;
import com.speedment.common.annotation.GeneratedCode;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * The generated base implementation of the {@link
 * com.example.gits.spm.dbms.gitsdb.gitrepos.Gitrepos}-interface.
 * <p>
 * This file has been automatically generated by Speedment. Any changes made to
 * it will be overwritten.
 * 
 * @author Speedment
 */
@GeneratedCode("Speedment")
public abstract class GeneratedGitreposImpl implements Gitrepos {
    
    private long id;
    private String name;
    private String group;
    private String repository;
    private LocalDateTime creationTime;
    private LocalDateTime updateTime;
    private boolean deleted;
    
    protected GeneratedGitreposImpl() {}
    
    @Override
    public long getId() {
        return id;
    }
    
    @Override
    public String getName() {
        return name;
    }
    
    @Override
    public String getGroup() {
        return group;
    }
    
    @Override
    public String getRepository() {
        return repository;
    }
    
    @Override
    public LocalDateTime getCreationTime() {
        return creationTime;
    }
    
    @Override
    public LocalDateTime getUpdateTime() {
        return updateTime;
    }
    
    @Override
    public boolean getDeleted() {
        return deleted;
    }
    
    @Override
    public Gitrepos setId(long id) {
        this.id = id;
        return this;
    }
    
    @Override
    public Gitrepos setName(String name) {
        this.name = name;
        return this;
    }
    
    @Override
    public Gitrepos setGroup(String group) {
        this.group = group;
        return this;
    }
    
    @Override
    public Gitrepos setRepository(String repository) {
        this.repository = repository;
        return this;
    }
    
    @Override
    public Gitrepos setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
        return this;
    }
    
    @Override
    public Gitrepos setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
        return this;
    }
    
    @Override
    public Gitrepos setDeleted(boolean deleted) {
        this.deleted = deleted;
        return this;
    }
    
    @Override
    public String toString() {
        final StringJoiner sj = new StringJoiner(", ", "{ ", " }");
        sj.add("id = "           + Objects.toString(getId()));
        sj.add("name = "         + Objects.toString(getName()));
        sj.add("group = "        + Objects.toString(getGroup()));
        sj.add("repository = "   + Objects.toString(getRepository()));
        sj.add("creationTime = " + Objects.toString(getCreationTime()));
        sj.add("updateTime = "   + Objects.toString(getUpdateTime()));
        sj.add("deleted = "      + Objects.toString(getDeleted()));
        return "GitreposImpl " + sj.toString();
    }
    
    @Override
    public boolean equals(Object that) {
        if (this == that) { return true; }
        if (!(that instanceof Gitrepos)) { return false; }
        final Gitrepos thatGitrepos = (Gitrepos)that;
        if (this.getId() != thatGitrepos.getId()) { return false; }
        if (!Objects.equals(this.getName(), thatGitrepos.getName())) { return false; }
        if (!Objects.equals(this.getGroup(), thatGitrepos.getGroup())) { return false; }
        if (!Objects.equals(this.getRepository(), thatGitrepos.getRepository())) { return false; }
        if (!Objects.equals(this.getCreationTime(), thatGitrepos.getCreationTime())) { return false; }
        if (!Objects.equals(this.getUpdateTime(), thatGitrepos.getUpdateTime())) { return false; }
        if (this.getDeleted() != thatGitrepos.getDeleted()) { return false; }
        return true;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Long.hashCode(getId());
        hash = 31 * hash + Objects.hashCode(getName());
        hash = 31 * hash + Objects.hashCode(getGroup());
        hash = 31 * hash + Objects.hashCode(getRepository());
        hash = 31 * hash + Objects.hashCode(getCreationTime());
        hash = 31 * hash + Objects.hashCode(getUpdateTime());
        hash = 31 * hash + Boolean.hashCode(getDeleted());
        return hash;
    }
}