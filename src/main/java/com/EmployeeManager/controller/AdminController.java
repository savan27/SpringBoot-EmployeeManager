package com.EmployeeManager.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.EmployeeManager.model.User;
import com.EmployeeManager.service.UserService;

/**
 * @author SAVAN
 *
 */
@Controller
public class AdminController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/adminprofile")
	public String adminLogin(HttpSession session,Model m) {
		
		//getting user role
		String userRole = (String) session.getAttribute("userRole");
		
		//validate session
		if (userRole != null && userRole.contentEquals("ADMIN")) {
		
			// user data to display
			List<User> userList = userService.getAllUser();
	
			m.addAttribute("userDetail", userList);
	
			return "adminProfile";
		}
		else {
			return "redirect:/login";
		}
	}
	
	@PostMapping("removeUser")
	@ResponseBody
	public String removeUser(@RequestParam("userId") Long userId) {
		
		//get user to remove 
		Optional<User> u = userService.getById(userId);
		
		//remove user
		boolean isUserremoved = userService.removeUser(u.orElse(new User()));
		
		if (isUserremoved) {
			return "user Deletion successfll ... ";
		}
		
		return "Fail to Delelte User.........";
	}

}
