package com.asol.security.services;

	import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;
	import org.springframework.transaction.annotation.Transactional;

import com.asol.security.dao.RoleDAO;
import com.asol.security.entity.Role;
	 
	@Service("roleService")
	public class RoleService {
	 
		@Autowired
		RoleDAO roleDao;
	 
		@Transactional
		public List getAllRoles() {
			return roleDao.getAllRoles();
		}
	 
		@Transactional
		public Role getRole(int id) {
			return roleDao.getRole(id);
		}
	 
		@Transactional
		public void addRole(Role role) {
			roleDao.addRole(role);
		}
	 
		@Transactional
		public void updateRole(Role role) {
			roleDao.updateRole(role);
	 
		}
	 
		@Transactional
		public void deleteRole(int id) {
			roleDao.deleteRole(id);
		}
	}
