package com.EmployeeManager.dto;

import java.util.List;

import com.EmployeeManager.model.Address;

/**
 * @author SAVAN
 *
 */
public class AddressDto {
	
	private List<Address> address;

	/**
	 * Default constructor
	 */
	public AddressDto() {
	}

	/**
	 * @param address
	 */
	public AddressDto(List<Address> address) {
		this.address = address;
	}

	/**
	 * @return the address
	 */
	public List<Address> getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(List<Address> address) {
		this.address = address;
	}

}
