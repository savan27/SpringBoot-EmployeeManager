/**
 * 
 */
package com.EmployeeManager.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EmployeeManager.model.Address;
import com.EmployeeManager.repository.AddressRepository;
import com.EmployeeManager.service.AddressService;

/**
 * @author inex2
 *
 */
@Service
public class AddressServiceImpl implements AddressService {
	
	@Autowired
	AddressRepository addressRepository;

	@Override
	public boolean save(Address entity) {
		return false;
	}

	@Override
	public Optional<Address> getById(Long id) {
		return null;
	}

	@Override
	public void removeAddress(Address address) {
		addressRepository.delete(address);
	}

}
