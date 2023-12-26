package com.udemy.microservices.versioning;

/**
 * The Class PersonV1.
 */
public class PersonV1 {

	/** The name. */
	private String name;

	/**
	 * Instantiates a new person V 1.
	 */
	public PersonV1() {
	}

	/**
	 * Instantiates a new person V 1.
	 *
	 * @param name the name
	 */
	public PersonV1(String name) {
		this.name = name;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

}
