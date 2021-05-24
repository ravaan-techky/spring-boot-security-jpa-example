package com.ravaan.techky.spring.dto;

/**
 * The Class Name.
 */
public class Name {

	/** The first name. */
	private String firstName;

	/** The last name. */
	private String lastName;

	/**
	 * Instantiates a new name.
	 *
	 * @param firstName the first name
	 * @param lastName  the last name
	 */
	public Name(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
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
	 * Gets the last name.
	 *
	 * @return the last name
	 */
	public String getLastName() {
		return lastName;
	}	
}
