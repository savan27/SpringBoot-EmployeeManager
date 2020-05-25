package com.EmployeeManager.controller;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.EmployeeManager.service.RoleService;
import com.EmployeeManager.service.UserService;

/**
 * @author SAVAN
 *
 */
@Controller
public class LoginController {
	
	//logger initialization
	private static final Logger logger = LogManager.getLogger(LoginController.class);
	
	@Autowired	
	RoleService roleservice;
	
	@Autowired
	UserService userService;
	
	@PostConstruct
	public void init() {
		if (roleservice.countRows().intValue() != 2) {
			if(roleservice.insert()) {
				logger.info("Role Updated Successfully...");
			}
		}
	}
	
	@RequestMapping("/")
	public String welcomeFile() {
		return "redirect:/login";
	}
	
	@GetMapping("/login")
	public String login(HttpSession session) {
		
		// getting user role
		String userRole = (String) session.getAttribute("userRole");

		// validate session
		if (userRole != null && userRole.contentEquals("USER")) {
			return "redirect:/userprofile";
		} else if (userRole != null && userRole.contentEquals("ADMIN")) {
			return "redirect:/adminprofile";
		}

		return "login";
		
	}
	
	@PostMapping("/afterLogin")
	public String afterLogin(HttpSession session) {
		
		String userRole = (String) session.getAttribute("userRole");
		
		if (userRole.contentEquals("ADMIN")) {
			return "redirect:/adminprofile";
		}
		else {
			return "redirect:/userprofile";
		}
	}
	
	@PostMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}
	
	@GetMapping("/forgotPassword")
	public String ForgotPassword() {
		return "forgotPassword";
	}
	
	@PostMapping("findPassword")
	@ResponseBody
	public String findPassword(@RequestParam("userEmail")String email) {
		
		//password fetched from the database
		String password = userService.findPassword(email);
		
		if(password != null) {
			return "Your Password Is : "+password+"";
		}
		else {
			return "Please Enter Valide Enail Id..!!";
		}
	}

}
