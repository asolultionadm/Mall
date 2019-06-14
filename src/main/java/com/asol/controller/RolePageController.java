package com.asol.controller;

import java.util.ArrayList;
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.asol.security.entity.Role;
import com.asol.security.services.RoleService;
import com.asol.security.services.ModuleService;
 
@Controller
public class RolePageController {
 
	@Autowired
	RoleService roleService;
	@Autowired
	ModuleService moduleService;
 
	@RequestMapping(value = "/getAllRoles", method = RequestMethod.GET, headers = "Accept=application/json")
	public String getRoles(Model model) {
 
		List listOfRoles = roleService.getAllRoles();
		model.addAttribute("role", new Role());
		model.addAttribute("listOfRoles", listOfRoles);
		
		List listOfModules = moduleService.getAllModules();
		model.addAttribute("roles", new ArrayList());
		model.addAttribute("listOfModules", listOfModules);
		
		return "roleDetails";
	}
	
	@RequestMapping(value = "/getAllRoleModules/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String getRoleModules(@PathVariable int id, Model model) {
 
		roleService.getRole(id);
		
		List listOfRoles = roleService.getAllRoles();
		model.addAttribute("role", new Role());
		model.addAttribute("listOfRoles", listOfRoles);
		
		List listOfModules = moduleService.getAllModules();
		model.addAttribute("roles", new ArrayList());
		model.addAttribute("listOfModules", listOfModules);
		
		return "roleDetails";
	}

 
	@RequestMapping(value = "/getRole/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Role getRoleById(@PathVariable int id) {
		return roleService.getRole(id);
	}
 
	@RequestMapping(value = "/addRole", method = RequestMethod.POST, headers = "Accept=application/json")
	public String addRole(@ModelAttribute("role") Role role) {	
		if(role.getId()==0)
		{
			roleService.addRole(role);
		}
		else
		{	
			roleService.updateRole(role);
		}
 
		return "redirect:/getAllRoles";
	}
 
	@RequestMapping(value = "/updateRole/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String updateRole(@PathVariable("id") int id,Model model) {
		model.addAttribute("role", this.roleService.getRole(id));
		model.addAttribute("listOfRoles", this.roleService.getAllRoles());
		return "roleDetails";
	}
 
	@RequestMapping(value = "/deleteRole/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String deleteRole(@PathVariable("id") int id) {
		roleService.deleteRole(id);
		return "redirect:/getAllRoles";
 
	}	
}