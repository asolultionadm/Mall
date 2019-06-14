package com.asol.security.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "module")
public class Module {
  
	@Id
	@Column(name = "id")
    private int id;
	
	@Column(name = "NAME", nullable = false, length = 200)
    private String name;
	
	@Column(name = "description", nullable = false, length = 200)
    private String description;
	
	@Column(name = "has_child", nullable = false)
    private boolean hasChild;
	
	@Column(name = "public_access", nullable = false)
    private boolean publicAccess;
	
	@Column(name = "enable", nullable = false)
    private boolean enable;
	
	@Column(name = "sequence", nullable = false)
    private int sequence;
	
	@Column(name = "url", nullable = false)
    private String url;
	
	@Column(name = "parent", nullable = true)
    private int parent;
	
	@Column(name = "target", nullable = true)
	private String target;
	
	@OneToMany(mappedBy = "module", cascade = CascadeType.ALL)
	Set<RoleModule> roleModules = new HashSet<RoleModule>();
	
	@Transient
    private transient List childs;
    
    public Module() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public boolean isPublicAccess() {
        return publicAccess;
    }

    public void setPublicRole(boolean publicAccess) {
        this.publicAccess = publicAccess;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
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
    
}
