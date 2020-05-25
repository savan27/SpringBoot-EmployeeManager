/**
 * 
 */
package com.EmployeeManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.EmployeeManager.model.Address;

/**
 * @author SAVAN
 *
 */
@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

}
