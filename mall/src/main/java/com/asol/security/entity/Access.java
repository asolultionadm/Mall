package com.asol.security.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import jdk.nashorn.internal.ir.annotations.Immutable;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Immutable
@Table(name = "access")
public class Access implements Serializable{
  
	
	@Id
	@Column(name = "user_id")
    private int userId;
	
	@Id
	@Column(name = "module_id")
    private int moduleId;
	
	@Column(name = "NAME", nullable = false, length = 200)
    private String name;
	
	@Column(name = "has_child", nullable = false)
    private boolean hasChild;
	
	@Column(name = "sequence", nullable = false)
    private int sequence;
	
	@Column(name = "url", nullable = false)
    private String url;
	
	@Column(name = "parent", nullable = true)
    private int parent;
	
	@Column(name = "target", nullable = true)
	private String target;
	
	@Transient
    private transient List childs;
    
    public Access() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int id) {
        this.userId = id;
    }

	public int getModuleId() {
		return moduleId;
	}

	public void setModuleId(int moduleId) {
		this.moduleId = moduleId;
	}

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getParent() {
        return parent;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }

    public boolean isHasChild() {
        return hasChild;
    }

    public void setHasChild(boolean hasChild) {
        this.hasChild = hasChild;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

 /*   public java.util.Collection getChilds() {
        return childs;
    }

    public void setChilds(java.util.Collection childs) {
        this.childs = childs;
    }*/
    
    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

	public List getChilds() {
		return childs;
	}

	public void setChilds(List childs) {
		this.childs = childs;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Access))
			return false;
		Access that = (Access) o;
		return Objects.equals(userId, that.userId)
				&& Objects.equals(moduleId, that.moduleId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(userId, moduleId);
	}
    
}
