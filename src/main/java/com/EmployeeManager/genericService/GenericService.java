package com.EmployeeManager.genericService;

import java.util.Optional;

/**
 * @author SAVAN
 *
 */
public interface GenericService<T> {

	// Insert Employee
	public boolean save(T entity);

	// Get entity Object by id
	public Optional<T> getById(Long id);
	
}
