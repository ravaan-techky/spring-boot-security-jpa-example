package com.ravaan.techky.spring.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

/**
 * The Class User.
 */
@Entity
public class User {
	
	/** The user id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	
	/** The first name. */
	@Size(min = 2, message = "Minimum allowed size is 2 character")
	@Column(name = "First_Name")
	private String firstName;

	/** The last name. */
	@Column(name = "Last_Name")
	private String lastName;

	/** The address. */
	@Column(name = "Address")
	private String address;

	/** The enroll date. */
	//@Past
	@Column(name = "Enroll_Date")
	private Date enrollDate;
	
	/** The posts. */
	@OneToMany(mappedBy = "user")
	private List<Post> posts;
		
	public User() {
		//DUMMY - Default Constructor
	}
	
	
	/**
	 * Instantiates a new user.
	 *
	 * @param userId the user Id
	 * @param firstName the first name
	 * @param lastName  the last name
	 * @param address   the address
	 */
	public User(Integer userId, String firstName, String lastName, String address) {
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.enrollDate = new Date();
	}

	/**
	 * Gets the first name.
	 *
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the first name.
	 *
	 * @param firstName the new first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets the last name.
	 *
	 * @return the last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the last name.
	 *
	 * @param lastName the new last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Gets the address.
	 *
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Sets the address.
	 *
	 * @param address the new address
	 */
	public void setAddress(String address) {
		this.address = address;
	}
		
	/**
	 * Gets the user id.
	 *
	 * @return the user id
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * Sets the user id.
	 *
	 * @param userId the new user id
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
		
	/**
	 * Gets the enroll date.
	 *
	 * @return the enroll date
	 */
	public Date getEnrollDate() {
		return enrollDate;
	}

	/**
	 * Sets the enroll date.
	 *
	 * @param enrollDate the new enroll date
	 */
	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}
	
	/**
	 * Gets the posts.
	 *
	 * @return the posts
	 */
	public List<Post> getPosts() {
		return posts;
	}

	/**
	 * Sets the posts.
	 *
	 * @param posts the new posts
	 */
	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + "]";
	}

}
