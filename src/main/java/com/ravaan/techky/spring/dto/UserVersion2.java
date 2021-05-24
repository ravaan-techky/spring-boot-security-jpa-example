package com.ravaan.techky.spring.dto;

/**
 * The Class UserVersion2.
 */
public class UserVersion2 {

	/** The user name. */
	private Name userName;

	/**
	 * Instantiates a new user version 2.
	 *
	 * @param userName the user name
	 */
	public UserVersion2(Name userName) {
		this.userName = userName;
	}

	/**
	 * Gets the user name.
	 *
	 * @return the user name
	 */
	public Name getUserName() {
		return userName;
	}
}
