package com.EmployeeManager.serviceImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.EmployeeManager.dto.AddressDto;
import com.EmployeeManager.dto.UserDto;
import com.EmployeeManager.enums.RoleType;
import com.EmployeeManager.model.Address;
import com.EmployeeManager.model.User;
import com.EmployeeManager.repository.UserRepository;
import com.EmployeeManager.service.AddressService;
import com.EmployeeManager.service.RoleService;
import com.EmployeeManager.service.UserService;

/**
 * @author SAVAN
 *
 */
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleService roleService;
	
	@Autowired
	AddressService addressService;

	@Override
	public User getUser(String userName, String password) {
		
		//get the user from user name
		User u =userRepository.findByEmail(userName);
		
		//authenticate password
		if(u != null && u.getPassword().contentEquals(password)) {
			return u;
		}
		
		return null;
	}

	@Override
	public boolean save(User entity) {
		
		//set User role By default
		entity.setRole(roleService.findByRole(RoleType.USER.name()));
		
		//get the inserted user 
		User user = userRepository.save(entity);
		
		if (user != null) {
			return true;
		}
		return false;
	}

	@Override
	public Optional<User> getById(Long id) {
		return userRepository.findById(id);
	}

	@Override
	public boolean checkUser(int userId, String email) {
		
		//get the user from user name
		User user =userRepository.findByEmail(email);
		
		// check user updating
		if (user != null) {
			if (user.getId() == userId) {
				return true;
			} 
			else {
				return false;
			}
		} 
		else {
		 return true;
		}
	}

	@Override
	public boolean updateUser(User u, UserDto userdto, AddressDto addressdto) {
		
		// Manipulation of profile picture
		try {
			MultipartFile file = userdto.getFile();
			if (file != null && file.getSize() > 0) {
				u.setProfilePicture(file.getBytes());
			} else {
				byte[] Image = Base64.getDecoder().decode(userdto.getProfile());
				u.setProfilePicture(Image);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		// setting user id
		u.setId(userdto.getUserId());

		// setting user Role
		u.setRole(roleService.findByRole(userdto.getUserRole()));

		// get all existing addresses of user
		List<Address> addressList = getAllAddresses(userdto.getUserId());

		// list of existing address id's
		List<Long> existingAddressIds = new ArrayList<Long>();

		// add address id's to the existingAddressIds list
		addressList.stream().forEach(addr -> {
			existingAddressIds.add(addr.getId());
		});

		// Distinguish all addresses
		addressdto.getAddress().stream().forEach(addr -> {

			// set user to address
			addr.setUser(u);

			// find addresses to remove
			if (existingAddressIds.contains(addr.getId())) {
				existingAddressIds.remove(Long.valueOf(addr.getId()));
			}
		});

		// setting updated address to user
		u.setAddress(addressdto.getAddress());

		// deleting the address from the entity
		addressList.stream().forEach(addr -> {
			if (existingAddressIds.contains(addr.getId())) {
				addressService.removeAddress(addr);
			}
		});

		User user = userRepository.save(u);
		
		if (user != null) {
			return true;
		}
		
		return false;
	}

	@Override
	public List<Address> getAllAddresses(Long userId) {
		
		// user all info.
		Optional<User> u = userRepository.findById(userId);

		// list of all available addresses
		List<Address> existingAddressIds = new ArrayList<Address>();

		u.get().getAddress().stream().forEach(addId -> {
			existingAddressIds.add(addId);
		});

		return existingAddressIds;
	}

	@Override
	public List<User> getAllUser() {
		
		// complete user information
		List<User> userlist = userRepository.findAll();

		// Particular info. to display
		List<User> displayinfo = new ArrayList<User>();

		userlist.stream().forEach(user -> {

			User u = new User();

			u.setId(user.getId());
			u.setFirstName(user.getFirstName());
			u.setEmail(user.getEmail());
			u.setGender(user.getGender());
			u.setContact(user.getContact());
			if (user.getProfilePicture() != null) {
				// image byte[] to Base64String
				String base64Image = Base64.getEncoder().encodeToString(user.getProfilePicture());
				u.setBase64image(base64Image);
			} else {
				System.out.println("User with id " + user.getId() + " has no image available...");
			}
			displayinfo.add(u);

		});
				
		return displayinfo;
	}

	@Override
	public boolean removeUser(User user) {
		try {
			userRepository.delete(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public String findPassword(String email) {
		
		//get the user from user name
		User user =userRepository.findByEmail(email);
		
		if (user != null ) {
			String password = user.getPassword();
			return password;
		}
		
		return null;
	}

}
