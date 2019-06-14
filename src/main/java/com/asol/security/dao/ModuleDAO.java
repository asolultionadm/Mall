package com.asol.security.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.asol.security.entity.Module;
 
@Repository
public class ModuleDAO {
 
	@Autowired
	private SessionFactory sessionFactory;
 
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
 
	public List getAllModules() {
		Session session = this.sessionFactory.getCurrentSession();
		List moduleList = session.createQuery("from Module").list();
		return moduleList;
	}
	
	
	public List getAllModulesInHirachy() {
		Session session = this.sessionFactory.getCurrentSession();
		List moduleList = this.getAllModulesByParent(session, 0);
		return moduleList;
	}
	
	public List getAllModulesByParent(Session session, int parentId) {
		List<Module> moduleList = session.createQuery("from Module where parent='"+parentId+"'").list();
		if(null != moduleList) for(Module item : moduleList) {
			List childs = this.getAllModulesByParent(session, item.getId());
			if(null != childs) item.setChilds(childs);
		}
		
		return moduleList;
	}
 
	public Module getModule(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Module module = (Module) session.get(Module.class, id);
		return module;
	}
 
	public Module addModule(Module module) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(module);
		return module;
	}
 
	public void updateModule(Module module) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(module);
	}
	
	public void addOrUpdateModule(Module module) {
		Session session = this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(module);
		/*Module exist = (Module) session.get(Module.class, module.getId());
		if(null!=exist && exist.getId() > 0) {
			session.update(module);
		} else {
			session.merge(arg0)
			session.persist(module);
		}*/
	}

 
	public void deleteModule(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Module p = (Module) session.load(Module.class, new Integer(id));
		if (null != p) {
			session.delete(p);
		}
	} 
}