package com.asol.security.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "role_module")
public class RoleModule implements Serializable {

	@Id
	@ManyToOne
	@JoinColumn
	private Role role;

	@Id
	@ManyToOne
	@JoinColumn
	private Module module;

	@Column(name = "rights")
	private int rights;

	public RoleModule(Module module, int rights) {
		this.module = module;
		this.rights = rights;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public int getRights() {
		return rights;
	}

	public void setRead(int rights) {
		this.rights = rights;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof RoleModule))
			return false;
		RoleModule that = (RoleModule) o;
		return Objects.equals(role.getName(), that.role.getName())
				&& Objects.equals(module.getName(), that.module.getName());
	}

	@Override
	public int hashCode() {
		return Objects.hash(role.getName(), module.getName());
	}
}
