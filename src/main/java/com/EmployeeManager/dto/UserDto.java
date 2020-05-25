package com.EmployeeManager.dto;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author SAVAN
 *
 */
public class UserDto {
	
	private MultipartFile File;
	private String profile;
	private Long userId;
	private String userRole;
	
	/**
	 * @return the file
	 */
	public MultipartFile getFile() {
		return File;
	}
	/**
	 * @param file the file to set
	 */
	public void setFile(MultipartFile file) {
		File = file;
	}
	/**
	 * @return the profile
	 */
	public String getProfile() {
		return profile;
	}
	/**
	 * @param profile the profile to set
	 */
	public void setProfile(String profile) {
		this.profile = profile;
	}
	/**
	 * @return the userId
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * @return the userRole
	 */
	public String getUserRole() {
		return userRole;
	}
	/**
	 * @param userRole the userRole to set
	 */
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

}
