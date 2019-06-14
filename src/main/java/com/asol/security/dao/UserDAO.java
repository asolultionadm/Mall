package com.asol.security.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.asol.security.entity.User;
 
@Repository
public class UserDAO {
 
	@Autowired
	private SessionFactory sessionFactory;
 
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
 
	public List getAllUsers() {
		Session session = this.sessionFactory.getCurrentSession();
		List userList = session.createQuery("from User").list();
		return userList;
	}
 
	public User getUser(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		User user = (User) session.get(User.class, id);
		return user;
	}
	
	public User findByUsername(String username) {
		Session session = this.sessionFactory.getCurrentSession();
		
		Criteria criteria = session.createCriteria(User.class);
		User user = (User) criteria.add(Restrictions.eq("username", username))
		                             .uniqueResult();
		if(null!=user)
		Hibernate.initialize(user.getRoles());
		//List<User> userList = session.createQuery("from User where username='"+username+"' password='"+password+"'").list();
		//if(userList.size()==0) return null;
		return user;
	}
 
	public User addUser(User user) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(user);
		return user;
	}
 
	public void updateUser(User user) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(user);
	}
 
	public void deleteUser(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		User p = (User) session.load(User.class, new Integer(id));
		if (null != p) {
			session.delete(p);
		}
	} 
}