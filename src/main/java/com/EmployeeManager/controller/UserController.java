package com.EmployeeManager.controller;

import java.io.IOException;
import java.util.Base64;
import java.util.Optional;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.EmployeeManager.dto.AddressDto;
import com.EmployeeManager.dto.UserDto;
import com.EmployeeManager.model.User;
import com.EmployeeManager.service.UserService;

/**
 * @author SAVAN
 *
 */
@Controller
public class UserController {
	
	// logger initialization
	private Logger logger = LogManager.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@GetMapping("/register")
	public String register() {
		return "register";
	}

	@GetMapping("/userprofile")
	public String profile(HttpSession session, Model m) {

		// getting user roleuserLogin
		String userRole = (String) session.getAttribute("userRole");

		// validate session
		if (userRole != null && userRole.contentEquals("USER")) {

			// getting user id from user
			Long userId = (Long) session.getAttribute("userId");

			// getting user data from the database
			Optional<User> u = userService.getById(userId);

			// Converting Image to Base64 String
			if (u.get().getProfilePicture() != null) {

				// image byte[] to Base64String
				String base64Image = Base64.getEncoder().encodeToString(u.get().getProfilePicture());

				m.addAttribute("profilePicture", base64Image);
			}

			// add user object to model
			m.addAttribute("user", u);

			return "userProfile";
		} else {
			return "redirect:/login";
		}
	}

	@PostMapping("/registerUser")
	public String registerUser(@Valid User u, BindingResult result, AddressDto address,
			@RequestParam("File") MultipartFile File, Model m, HttpSession session) {

		// validating user data
		if (result.hasErrors()) {
			m.addAttribute("error", result);
			return "register";
		}

		// setting image as byte[]
		try {
			if (File != null && File.getSize() > 0) {
				u.setProfilePicture(File.getBytes());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		// address manipulation as per mapping
		address.getAddress().stream().forEach(addr -> {
			// set user to address
			addr.setUser(u);
		});

		// setting updated address to user
		u.setAddress(address.getAddress());

		// save user
		if (userService.save(u)) {
			logger.info("User Insertion SuccessFull...");
			session.setAttribute("loginMsg", "Login to Continue...");
			return "login";
		} else {
			logger.error("Fail to register the user...");
			session.setAttribute("loginErr", "Fail to Register! Please try again...");
			return "login";
		}

	}

	@GetMapping("/doUpdateUser")
	public String doupdateUser(@RequestParam("id") Long id, Model m) {

		// get the user data
		Optional<User> u = userService.getById(id);

		// Converting Image to Base64 String
		if (u.get().getProfilePicture() != null) {
			String base64Image = Base64.getEncoder().encodeToString(u.get().getProfilePicture());
			m.addAttribute("profilePicture", base64Image);
		} else {
			logger.info("User with id " + u.get().getId() + " has no image available at update time...");
		}

		m.addAttribute("user", u);
		m.addAttribute("userId", u.get().getId());
		m.addAttribute("userRole", u.get().getRole().getRole());
		m.addAttribute("userUpdate", "updateUser");

		return "register";
	}

	@PostMapping("/afterUserUpdate")
	public String afterUserUpdate(@Valid User u, BindingResult result, UserDto userdto, AddressDto addressdto,
			Model m,HttpSession session) {

		// validating user data
		if (result.hasErrors()) {

			m.addAttribute("error", result);
			m.addAttribute("userId", userdto.getUserId());
			m.addAttribute("userRole", userdto.getUserRole());
			m.addAttribute("userUpdate", "updateUser");
			// Manipulation of profile picture
			try {
				MultipartFile file = userdto.getFile();
				if (file != null && file.getSize() > 0) {
					String base64Image = Base64.getEncoder().encodeToString(file.getBytes());
					m.addAttribute("profilePicture", base64Image);
				} else {
					m.addAttribute("profilePicture", userdto.getProfile());
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

			return "register";
		}

		// update user
		if (userService.updateUser(u, userdto, addressdto)) {
			logger.info("User is Updated Successfully...");
		} else {
			logger.error("Fail to Update User");
		}

		if (userdto.getUserRole().contentEquals("ADMIN")) {
			return "redirect:/adminprofile";
		}

		return "redirect:/userprofile";
	}

	@PostMapping("/checkUserExistance")
	@ResponseBody
	public String checkUserExistance(@RequestParam("userEmail") String email, @RequestParam("userId") int userId) {

		boolean isUserExists = userService.checkUser(userId, email);

		if (isUserExists) {
			return "";
		} else {
			return "Email Already Exists...";
		}
	}

}
