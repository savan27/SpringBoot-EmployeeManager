/**
 * 
 */
package com.EmployeeManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.EmployeeManager.model.Role;

/**
 * @author SAVAN
 *
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

	@Query("from Role where role=?1")
	Role findByRole(String roleName);
	
}
