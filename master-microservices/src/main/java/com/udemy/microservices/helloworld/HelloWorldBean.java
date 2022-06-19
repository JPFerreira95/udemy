package com.udemy.microservices.helloworld;

/**
 * The Class HelloWorldBean.
 */
public class HelloWorldBean {

	/** The message. */
	private String message;

	/**
	 * Instantiates a new hello world bean.
	 *
	 * @param message the message
	 */
	public HelloWorldBean(String message) {
		this.message = message;
	}

	/**
	 * Gets the message.
	 *
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Sets the message.
	 *
	 * @param message the new message
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "HelloWorldBean [message=" + message + "]";
	}

}
