package com.EmployeeManager.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EmployeeManager.enums.RoleType;
import com.EmployeeManager.model.Role;
import com.EmployeeManager.repository.RoleRepository;
import com.EmployeeManager.service.RoleService;

/**
 * @author SAVAN
 *
 */
@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	RoleRepository roleRepository;

	@Override
	public Long countRows() {
		return roleRepository.count();
	}

	@Override
	public boolean insert() {
		
		// set admin role
		Role admin = new Role();
		admin.setRole(RoleType.ADMIN.name());

		// set user role
		Role user = new Role();
		user.setRole(RoleType.USER.name());
		
		Role adminid = roleRepository.save(admin);
		Role userid = roleRepository.save(user);
		
		if (adminid != null && userid != null) {
			return true;
		}
		return false;
	}

	@Override
	public Role findByRole(String roleName) {
		return roleRepository.findByRole(roleName);
	}


}
