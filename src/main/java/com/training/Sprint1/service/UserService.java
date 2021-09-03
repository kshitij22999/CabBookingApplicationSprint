package com.training.Sprint1.service;

import java.util.List;

import com.training.Sprint1.entities.User;
import com.training.Sprint1.exception.RoleNotFoundException;

public interface UserService {

    User save(User user) throws RoleNotFoundException;
    List<User> findAll();
    void delete(long id);
    User findOne(String username);

    User findById(Long id);
	
}