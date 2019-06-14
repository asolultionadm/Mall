package com.asol.security.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {
  
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = IDENTITY)  
    private int id;
	
	@Column(name = "username", unique = true, nullable = false, length = 20)
    private String username;
	
	@Column(name = "password", nullable = false)
    private String password;
	
	@Column(name = "register_date", nullable = false)
	private String registerDate;
	
	@Column(name = "expired_date", nullable = true)
	private String expiredDate;
	
	@Column(name = "reference_id", nullable = false)
	private String referenceId;
	
	@Column(name = "active_flag", nullable = false)
	private boolean active;
	
	@Column(name = "role", nullable = true)
	private String role;
	
	@Column(name = "password_expiry", nullable = true)
	private String passwordExpiry;
	
	@Column(name = "lock_count", nullable = false)
	private int lockCount;
	
	@ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "user_role", 
        joinColumns = { @JoinColumn(name = "user_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "role_id") }
    )
    private Set<Role> roles = new HashSet<Role>();

	@Transient
    private transient List accesses;

//	@Transient
  //  private transient java.util.Collection childs;
    
    public List getAccesses() {
		return accesses;
	}

	public void setAccesses(List accesses) {
		this.accesses = accesses;
	}

	public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String username) {
        this.username = username;
    }

    public String getDescription() {
        return password;
    }

    public void setDescription(String description) {
        this.password = description;
    }

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}

	public String getExpiredDate() {
		return expiredDate;
	}

	public void setExpiredDate(String expiredDate) {
		this.expiredDate = expiredDate;
	}

	public String getReferenceId() {
		return referenceId;
	}

	public void setReferenceId(String referenceId) {
		this.referenceId = referenceId;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPasswordExpiry() {
		return passwordExpiry;
	}

	public void setPasswordExpiry(String passwordExpiry) {
		this.passwordExpiry = passwordExpiry;
	}

	public int getLockCount() {
		return lockCount;
	}

	public void setLockCount(int lockCount) {
		this.lockCount = lockCount;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

   
}
