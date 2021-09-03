package com.training.Sprint1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.Sprint1.entities.Role;
import com.training.Sprint1.exception.RoleNotFoundException;

public interface RoleRepository extends JpaRepository<Role, Long>{

	Role findByName(String name) throws RoleNotFoundException;
	
	

}
