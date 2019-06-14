package com.asol.security.services;

	import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;
	import org.springframework.transaction.annotation.Transactional;

import com.asol.security.dao.ModuleDAO;
import com.asol.security.entity.Module;
	 
	@Service("moduleService")
	public class ModuleService {
	 
		@Autowired
		ModuleDAO moduleDao;
	 
		@Transactional
		public List getAllModules() {
			return moduleDao.getAllModules();
		}
		
		@Transactional
		public List getAllModulesInHiracky() {
			return moduleDao.getAllModulesInHirachy();
		}
	 
		@Transactional
		public Module getModule(int id) {
			return moduleDao.getModule(id);
		}
	 
		@Transactional
		public void addModule(Module module) {
			moduleDao.addModule(module);
		}
		
		@Transactional
		public void updateModule(Module module) {
			moduleDao.updateModule(module);
	 
		}
	 
		@Transactional
		public void addOrUpdateModule(Module module) {
			moduleDao.addOrUpdateModule(module);
	 
		}
	 
		@Transactional
		public void deleteModule(int id) {
			moduleDao.deleteModule(id);
		}
	}
