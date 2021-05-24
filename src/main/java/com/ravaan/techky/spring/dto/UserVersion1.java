package com.ravaan.techky.spring.dto;

/**
 * The Class UserVersion1.
 */
public class UserVersion1 {
	
	/** The full name. */
	private String fullName;

	/**
	 * Instantiates a new user version 1.
	 *
	 * @param userFullName the user full name
	 */
	public UserVersion1(String userFullName) {
		this.fullName = userFullName;
	}

	/**
	 * Gets the full name.
	 *
	 * @return the full name
	 */
	public String getFullName() {
		return fullName;
	}
}
