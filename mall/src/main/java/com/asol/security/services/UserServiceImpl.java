package com.asol.security.services;

	import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
	import org.springframework.transaction.annotation.Transactional;

import com.asol.security.dao.AccessDAO;
import com.asol.security.dao.UserDAO;
import com.asol.security.entity.User;
	 
	@Service("userService")
	public class UserServiceImpl implements UserService, UserDetailsService {
	 
		@Autowired
		UserDAO userDao;
		@Autowired
		AccessDAO accessDao;
	 
		@Transactional
		public List getAllUsers() {
			return userDao.getAllUsers();
		}
	 
		@Transactional
		public User getUser(int id) {
			return userDao.getUser(id);
		}
		
		/*@Transactional
		public User verifyUser(String username, String password) {
			User user = userDao.findByUsername(username);
			
			//TODO: add password encryption checking here
			if(null!=user && user.getPassword().equals(password)) {
				List list = accessDao.getAllAccesssInHirachy(user.getId(), 1);
				user.setAccesses(list);
				return user;
			}
			else return null;
		}*/
	 
		@Transactional
		public void addUser(User user) {
			user.setPassword(bcryptEncoder.encode(user.getPassword()));
			userDao.addUser(user);
		}
	 
		@Transactional
		public void updateUser(User user) {
			userDao.updateUser(user);
	 
		}
	 
		@Transactional
		public void deleteUser(int id) {
			userDao.deleteUser(id);
		}
		
		@Autowired
		private BCryptPasswordEncoder bcryptEncoder;
		@Transactional
		public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
			User user = userDao.findByUsername(username);
			if(user == null){
				throw new UsernameNotFoundException("Invalid username or password.");
			}
			return new org.springframework.security.core.userdetails.User(user.getUsername(), String.valueOf(user.getId()), getAuthority(user));
		}
		@Transactional
		private Set getAuthority(User user) {
	        Set authorities = new HashSet<>();
			/*user.getRoles().forEach(role -> {
	            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
			});*/
			return authorities;
		}
	}
