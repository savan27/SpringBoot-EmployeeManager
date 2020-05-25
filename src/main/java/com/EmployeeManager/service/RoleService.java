package com.EmployeeManager.service;

import com.EmployeeManager.model.Role;

/**
 * @author SAVAN
 *
 */
public interface RoleService {
	
	// check number of rows
	Long countRows();

	// insert role again
	boolean insert();

	//find Role by name
	public Role findByRole(String roleName);
}
