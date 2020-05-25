package com.EmployeeManager.model;

import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


/**
 * @author SAVAN
 *
 */
@Entity
@Table(name = "user_detail")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "user_id",length = 10)
	private Long id;
	
	@NotEmpty(message = "{NotNull.user.firstName}")
	@Size(max = 20,min = 2)
	@Pattern(regexp = "^[a-zA-Z]+$",message = "{Pattern.user.firstName}")
	@Column(name = "first_name",nullable = false,length = 30)
	private String firstName;

	@NotEmpty(message = "{NotNull.user.lastName}")
	@Size(max = 20,min = 2)
	@Pattern(regexp = "^[a-zA-Z]+$",message = "{Pattern.user.lastName}")
	@Column(name = "last_name",nullable = false,length = 30)
	private String lastName;
	
	@NotEmpty
	@Column(name = "password",nullable = false,length = 30)
	private String password;
	
	@NotEmpty(message = "{NotNull.user.email}")
	@Column(name = "email",nullable = false,length = 30,unique = true)
	private String email;
	
	@NotEmpty(message = "{NotNull.user.Contact}")
	@Size(min = 10,max = 10)
	@Pattern(regexp = "(^[0-9]{10})",message = "{Pattern.user.Contact}")
	@Column(name = "contact",nullable = false,length = 10)
	private String contact;
	
	@Column(name = "gender",nullable = true,length = 10)
	private String gender;
	
	@Column(name = "permission",nullable = true,length = 30)
	private String permission;
	
	@Column(name = "hobbies",nullable = true,length = 30)
	private String hobbies;
	
	@Column(name = "profile_picture", nullable = true)
	private byte[] profilePicture;

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "role_id")
	private Role role;
	
	@NotEmpty
	@Valid
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "user",orphanRemoval = true,fetch = FetchType.EAGER,targetEntity = Address.class)
	private List<Address> address;

	@Transient
	private String base64image;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the contact
	 */
	public String getContact() {
		return contact;
	}

	/**
	 * @param contact the contact to set
	 */
	public void setContact(String contact) {
		this.contact = contact;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the permission
	 */
	public String getPermission() {
		return permission;
	}

	/**
	 * @param permission the permission to set
	 */
	public void setPermission(String permission) {
		this.permission = permission;
	}

	/**
	 * @return the hobbies
	 */
	public String getHobbies() {
		return hobbies;
	}

	/**
	 * @param hobbies the hobbies to set
	 */
	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}

	/**
	 * @return the profilePicture
	 */
	public byte[] getProfilePicture() {
		return profilePicture;
	}

	/**
	 * @param profilePicture the profilePicture to set
	 */
	public void setProfilePicture(byte[] profilePicture) {
		this.profilePicture = profilePicture;
	}

	/**
	 * @return the role
	 */
	public Role getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(Role role) {
		this.role = role;
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

	/**
	 * @return the base64image
	 */
	public String getBase64image() {
		return base64image;
	}

	/**
	 * @param base64image the base64image to set
	 */
	public void setBase64image(String base64image) {
		this.base64image = base64image;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", password=" + password
				+ ", email=" + email + ", contact=" + contact + ", gender=" + gender + ", permission=" + permission
				+ ", hobbies=" + hobbies + ", profilePicture=" + Arrays.toString(profilePicture) + ", role=" + role
				+ ", address=" + address + "]";
	}

	

}
