package com.asol.controller;

import com.asol.security.UserInfo;
import com.asol.security.entity.User;
import com.asol.security.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class UserController {

    @Autowired
    private UserService userService;
    
	@Autowired
	UserInfo userInfo;

    //@Secured({"ROLE_ADMIN", "ROLE_USER"})
    //@PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value="/users", method = RequestMethod.GET)
    public List<User> listUser(){
        return userService.getAllUsers();
    }

    //@Secured("ROLE_USER")
    //@PreAuthorize("hasRole('USER')")
    ////@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public User getOne(@PathVariable(value = "id") int id){
        return userService.getUser(id);
    }
    
    @RequestMapping(value = "/me", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public User currentUwer() {
    	User user = userService.getUser(Integer.parseInt(userInfo.getId()));
       return user;
    }


//    @RequestMapping(value="/signup", method = RequestMethod.POST)
 //   public User saveUser(@RequestBody UserDto user){
   //     return userService.save(user);
   // }



}
