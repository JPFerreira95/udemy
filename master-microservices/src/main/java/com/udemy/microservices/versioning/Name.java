package com.udemy.microservices.versioning;

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
	 */
	public Name() {
	}

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

}
