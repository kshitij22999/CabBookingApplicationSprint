package com.training.Sprint1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.training.Sprint1.entities.User;
import com.training.Sprint1.exception.RoleNotFoundException;
import com.training.Sprint1.service.UserService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    //@Secured({"ROLE_ADMIN", "ROLE_USER"})
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value="/user", method = RequestMethod.GET)
    public List listUser(){
        return userService.findAll();
    }

    //@Secured("ROLE_USER")
    //@PreAuthorize("hasRole('USER')")
    //@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public User getOne(@PathVariable(value = "id") Long id){
    	System.out.println("getting details of individual user with id");
        return userService.findById(id);
    }

    @RequestMapping(value="/signup", method = RequestMethod.POST)
    public User create(@RequestBody User user) throws RoleNotFoundException{
    	System.out.println("msg*********************");
        return userService.save(user);
    }

  
   // @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value="/user/{id}", method = RequestMethod.DELETE)
    public User deleteUser(@PathVariable(value = "id") Long id){
        userService.delete(id);
        return new User(id);
    }
    
    @RequestMapping(value="/user/username/{username}", method = RequestMethod.GET)
    public UserDetails loadByUsername(@PathVariable(value="username") String username) {
    	return userService.loadUserByUsername(username);
    }

}