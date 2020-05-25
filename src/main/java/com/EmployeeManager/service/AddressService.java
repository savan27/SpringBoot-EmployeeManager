package com.EmployeeManager.service;

import com.EmployeeManager.genericService.GenericService;
import com.EmployeeManager.model.Address;

/**
 * @author SAVAN
 *
 */
public interface AddressService extends GenericService<Address> {
	
	//remove address  
	void removeAddress(Address address);

}
