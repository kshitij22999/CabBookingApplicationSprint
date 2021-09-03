package com.training.Sprint1.service;

import com.training.Sprint1.entities.Role;
import com.training.Sprint1.exception.RoleNotFoundException;

public interface IRoleService {
	public Role findRoleById(Long id) throws RoleNotFoundException;
	public Role findRoleByName(String name) throws RoleNotFoundException;
	
	
}
