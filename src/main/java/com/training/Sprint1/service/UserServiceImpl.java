package com.training.Sprint1.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.training.Sprint1.entities.Role;
import com.training.Sprint1.entities.User;
import com.training.Sprint1.exception.RoleNotFoundException;
import com.training.Sprint1.repository.UserDao;

@Service(value = "userService")
public class UserServiceImpl implements UserDetailsService, UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	RoleService roleService;
	
	@Autowired
	private BCryptPasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
			User user = userDao.findByUsername(username);
		
		
		System.out.println("user data in loadUserByUsername "+user.getUsername() +user.getPassword()+user.getRoles()+"**************************");
		if(user == null){
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		Set<SimpleGrantedAuthority> auths = getAuthority(user);
		System.out.println(auths+"************************************authorities");
		return new org.springframework.security.core.userdetails.User(user.getUsername(), bcryptEncoder.encode(user.getPassword()), getAuthority(user));
	}

	private Set<SimpleGrantedAuthority> getAuthority(User user) {
		System.out.println(user.getRoles()+"********************simple granted authority");
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        
        Set<String> setroles = new HashSet<>();
		
		user.getRoles().forEach(role->setroles.add(role.getName()));
		authorities = setroles.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toSet());
		
        
		return authorities;
	}

	public List<User> findAll() {
		List<User> list = new ArrayList<>();
		userDao.findAll().iterator().forEachRemaining(list::add);
		return list;
	}

	@Override
	public void delete(long id) {
		userDao.deleteById(id);
	}

	@Override
	public User findOne(String username) {
		return userDao.findByUsername(username);
	}

	@Override
	public User findById(Long id) {
		return userDao.findById(id).get();
	}

	@Override
    public User save(User user) throws RoleNotFoundException {
	    User newUser = new User();
	    newUser.setUsername(user.getUsername());
	    newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
	    Set<Role> roles= user.getRoles();
	    Set<Role> newSetOfRoles =  new HashSet<Role>();
	    
	    for(Role r:roles) {
	    	
	    	newSetOfRoles.add(roleService.findRoleById(r.getId()));
	    }
	    newUser.setRoles(newSetOfRoles);
	    
	    System.out.println(newSetOfRoles+"************************");
		  User savedUser = userDao.save(user);
		  System.out.println(savedUser+"**************************");
		  return savedUser;
	}


	
	
	
	

	
}