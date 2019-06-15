package com.asol.controller;

import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.asol.security.entity.Module;
import com.asol.security.services.ModuleService;
 
@Controller
public class ModulePageController {
 
	@Autowired
	ModuleService moduleService;
 
	@RequestMapping(value = "/getAllModules", method = RequestMethod.GET, headers = "Accept=application/json")
	public String getModules(Model model) {
 
		List listOfModules = moduleService.getAllModules();
		model.addAttribute("module", new Module());
		model.addAttribute("listOfModules", listOfModules);
		return "moduleDetails";
	}
 
	@RequestMapping(value = "/getModule/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Module getModuleById(@PathVariable int id) {
		return moduleService.getModule(id);
	}
 
	@RequestMapping(value = "/addModule", method = RequestMethod.POST, headers = "Accept=application/json")
	public String addModule(@ModelAttribute("module") Module module) {	
		if(module.getId()==0) {
			//model.setAttribute("error", "Id cannot be 0");
		} else {
			moduleService.addOrUpdateModule(module);
		}
 
		return "redirect:/getAllModules";
	}
 
	@RequestMapping(value = "/updateModule/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String updateModule(@PathVariable("id") int id,Model model) {
		model.addAttribute("module", this.moduleService.getModule(id));
		model.addAttribute("listOfModules", this.moduleService.getAllModules());
		return "moduleDetails";
	}
 
	@RequestMapping(value = "/deleteModule/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String deleteModule(@PathVariable("id") int id) {
		moduleService.deleteModule(id);
		return "redirect:/getAllModules";
 
	}	
}