package com.EmployeeManager.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.EmployeeManager.model.User;

/**
 * @author SAVAN
 *
 */
@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Long> {
	
	@Query("from User u where email =?1")
	User findByEmail(String email);

}
