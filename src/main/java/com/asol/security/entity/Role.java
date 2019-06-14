package com.asol.security.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "role")
@JsonIgnoreProperties(value= {"roles", "users", "roleModules"})
public class Role {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = IDENTITY) 
  private int id;
	
	@Column(name = "NAME", nullable = false, length = 200)
  private String name;
	
	@Column(name = "description", nullable = false, length = 200)
  private String description;
	
	@ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "user_role", 
        joinColumns = { @JoinColumn(name = "user_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "role_id") }
    )
    private Set<Role> roles = new HashSet<Role>();
	
	@ManyToMany( mappedBy = "roles")
	private Set<User> users = new HashSet<User>();
	
	@OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
    private Set<RoleModule> roleModules = new HashSet<RoleModule>();

  public Role() {
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
public Set<Role> getRoles() {
	return roles;
}
public void setRoles(Set<Role> roles) {
	this.roles = roles;
}
public Set<User> getUsers() {
	return users;
}
public void setUsers(Set<User> users) {
	this.users = users;
}
public Set<RoleModule> getRoleModules() {
	return roleModules;
}
public void setRoleModules(Set<RoleModule> roleModules) {
	this.roleModules = roleModules;
}
  
}
