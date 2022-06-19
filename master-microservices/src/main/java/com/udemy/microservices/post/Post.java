package com.udemy.microservices.post;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.udemy.microservices.user.User;

/**
 * The Class Post.
 */
@Entity
public class Post {

	/** The id. */
	@Id
	@GeneratedValue
	private Integer id;

	/** The description. */
	private String description;

	/** The user. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private User user;

	/**
	 * Instantiates a new post.
	 */
	public Post() {
	}

	/**
	 * Instantiates a new post.
	 *
	 * @param id          the id
	 * @param description the description
	 * @param user        the user
	 */
	public Post(Integer id, String description, User user) {
		this.id = id;
		this.description = description;
		this.user = user;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the description.
	 *
	 * @param description the new description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Gets the user.
	 *
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * Sets the user.
	 *
	 * @param user the new user
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Post [id=" + id + ", description=" + description + "]";
	}

}
