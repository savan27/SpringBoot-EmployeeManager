package com.EmployeeManager.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * @author SAVAN	
 *
 */
@Entity
@Table(name = "user_address")
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "address_id")
	private Long id;
	
	@NotEmpty(message = "{NotNull.address.home}")
	@Size(max = 30,min = 5)
	@Column(name = "home",nullable = false,length = 30)
	private String home;
	
	@NotEmpty(message = "{NotNull.address.street}")
	@Size(max = 30,min = 5)
	@Column(name = "street",nullable = false,length = 30)
	private String street;
	
	@NotEmpty(message = "{NotNull.address.city}")
	@Size(max = 10,min = 5)
	@Pattern(regexp = "^[a-zA-Z]+$",message = "{Pattern.user.city}")
	@Column(name = "city",nullable = false,length = 10)
	private String city;
	
	@NotEmpty(message = "{NotNull.address.state}")
	@Size(max = 10,min = 5)
	@Pattern(regexp = "^[a-zA-Z]+$",message = "{Pattern.user.state}")
	@Column(name = "state",nullable = false,length = 10)
	private String state;
	
	@NotEmpty(message = "{NotNull.address.country}")
	@Size(max = 10,min = 4)
	@Pattern(regexp = "^[a-zA-Z]+$",message = "{Pattern.user.country}")
	@Column(name = "country",nullable = false,length = 10)
	private String country;
	
	@NotEmpty(message = "{NotNull.address.zipcode}")
	@Size(max = 6,min = 6)
	@Pattern(regexp = "(^[0-9]{6})",message = "{Pattern.user.zipcode}")
	@Column(name = "zipcode",nullable = false,length = 10)
	private String zipcode;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

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
	 * @return the home
	 */
	public String getHome() {
		return home;
	}

	/**
	 * @param home the home to set
	 */
	public void setHome(String home) {
		this.home = home;
	}

	/**
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * @param street the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the zipcode
	 */
	public String getZipcode() {
		return zipcode;
	}

	/**
	 * @param zipcode the zipcode to set
	 */
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", home=" + home + ", street=" + street + ", city=" + city + ", state=" + state
				+ ", country=" + country + ", zipcode=" + zipcode + ", user=" + user + "]";
	}

}
