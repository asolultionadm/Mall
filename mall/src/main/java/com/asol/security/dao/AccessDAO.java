package com.asol.security.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.asol.security.entity.Access;
 
@Repository
public class AccessDAO {
 
	@Autowired
	private SessionFactory sessionFactory;
 
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
 
	public List getAllAccesss() {
		Session session = this.sessionFactory.getCurrentSession();
		List accessList = session.createQuery("from Access").list();
		return accessList;
	}
	
	public List getAllAccesssInHirachy(int userId, int parentId) {
		Session session = this.sessionFactory.getCurrentSession();
		List accessList = this.getAllAccesssByParent(session, parentId, userId);
		return accessList;
	}
	
	private List getAllAccesssByParent(Session session, int parentId, int userId) {
		List<Access> accessList = session.createQuery("from Access where parent='"+parentId+"' and userId='"+userId+"'").list();
		if(null != accessList) for(Access item : accessList) {
			List childs = this.getAllAccesssByParent(session, item.getModuleId(), userId);
			if(null != childs) item.setChilds(childs);
		}
		
		return accessList;
	}
 
	public Access getAccess(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Access access = (Access) session.get(Access.class, id);
		return access;
	}
 
}