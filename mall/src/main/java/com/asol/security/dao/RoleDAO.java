package com.asol.security.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.asol.security.entity.Role;
 
@Repository
public class RoleDAO {
 
	@Autowired
	private SessionFactory sessionFactory;
 
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
 
	public List getAllRoles() {
		Session session = this.sessionFactory.getCurrentSession();
		List roleList = session.createQuery("from Role").list();
		return roleList;
	}
 
	public Role getRole(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Role role = (Role) session.get(Role.class, id);
		return role;
	}
 
	public Role addRole(Role role) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(role);
		return role;
	}
 
	public void updateRole(Role role) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(role);
	}
 
	public void deleteRole(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Role p = (Role) session.load(Role.class, new Integer(id));
		if (null != p) {
			session.delete(p);
		}
	} 
}