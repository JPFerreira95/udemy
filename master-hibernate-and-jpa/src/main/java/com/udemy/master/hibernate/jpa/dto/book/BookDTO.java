package com.udemy.master.hibernate.jpa.dto.book;

import java.io.Serializable;

import com.udemy.master.hibernate.jpa.entity.book.Book;

/**
 * The Class BookDTO.
 */
public class BookDTO implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	private Long id;

	/** The name. */
	private String name;

	/** The author. */
	private String author;

	/**
	 * Instantiates a new book DTO.
	 */
	public BookDTO() {
	}

	/**
	 * Instantiates a new book DTO.
	 *
	 * @param book the book
	 */
	public BookDTO(Book book) {
		this.setId(book.getId());
		this.setName(book.getName());
		this.setAuthor(book.getAuthor());
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Long id) {
		this.id = id;
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

	/**
	 * Gets the author.
	 *
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * Sets the author.
	 *
	 * @param author the new author
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

}
