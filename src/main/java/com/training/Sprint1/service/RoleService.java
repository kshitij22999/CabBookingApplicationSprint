package com.training.Sprint1.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.Sprint1.entities.Role;
import com.training.Sprint1.exception.RoleNotFoundException;
import com.training.Sprint1.repository.RoleRepository;

@Service
@Transactional
public class RoleService implements IRoleService{
	
	@Autowired
	RoleRepository repo;

	@Override
	public Role findRoleById(Long id) throws RoleNotFoundException {
		return repo.findById(id).orElseThrow(RoleNotFoundException::new);
	}

	@Override
	public Role findRoleByName(String name) throws RoleNotFoundException {
		Role role= repo.findByName(name);
		if(role == null) {
			throw new RoleNotFoundException();
		}
		else
			return role;
		
	}

	public List<Role> getRoles() {
		return repo.findAll();
	}

}
