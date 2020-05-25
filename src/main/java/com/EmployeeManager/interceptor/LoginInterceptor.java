package com.EmployeeManager.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.EmployeeManager.model.User;
import com.EmployeeManager.service.UserService;

/**
 * @author SAVAN
 *
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {
	
	@Autowired
	UserService userService;
	
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session = request.getSession();
		
		String userName =  request.getParameter("userName");
		String password =  request.getParameter("password");
		
		if (userName != null && !userName.isEmpty() && password != null && !password.isEmpty()) {
			
			//get user data
			User u = userService.getUser(userName, password);
			
			if (u != null) {
				session.setAttribute("userId", u.getId());
				session.setAttribute("userRole", u.getRole().getRole());
				return true;
			} 
			else {
				session.setAttribute("loginErr", "*Invalid credentials");
				response.sendRedirect("/");
				return false;
			}
		}
		else {
			session.setAttribute("loginErr", "*Invalid credentials");
			response.sendRedirect("/");
			return false;
		}
		
	}

}
