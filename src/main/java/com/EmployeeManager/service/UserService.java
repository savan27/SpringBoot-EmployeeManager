package com.EmployeeManager.service;

import java.util.List;

import com.EmployeeManager.dto.AddressDto;
import com.EmployeeManager.dto.UserDto;
import com.EmployeeManager.genericService.GenericService;
import com.EmployeeManager.model.Address;
import com.EmployeeManager.model.User;

/**
 * @author SAVAN
 *
 */
public interface UserService extends GenericService<User> {

	// get user from login credential
	public User getUser(String userName, String password);
	
	//check user Existence 
	public boolean checkUser(int userId, String email);

	//update user
	public boolean updateUser(User u, UserDto userdto, AddressDto addressdto);
	
	//get all address list as addressId
	public List<Address> getAllAddresses(Long userId);
	
	// fetch all user Data
	public List<User> getAllUser();
	
	//remove user 
	public boolean removeUser(User user);
	
	//find the password
	public String findPassword(String email);
	
}
