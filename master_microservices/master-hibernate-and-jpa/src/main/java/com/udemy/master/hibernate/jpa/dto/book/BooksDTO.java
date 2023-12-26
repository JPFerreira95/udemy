package com.udemy.master.hibernate.jpa.dto.book;

import java.io.Serializable;
import java.util.List;

/**
 * The Class BooksDTO.
 */
public class BooksDTO implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The books. */
	private List<BookDTO> books;

	/**
	 * Instantiates a new books DTO.
	 *
	 * @param books the books
	 */
	public BooksDTO(List<BookDTO> books) {
		this.books = books;
	}

	/**
	 * Gets the books.
	 *
	 * @return the books
	 */
	public List<BookDTO> getBooks() {
		return books;
	}

	/**
	 * Sets the books.
	 *
	 * @param books the new books
	 */
	public void setBooks(List<BookDTO> books) {
		this.books = books;
	}

}
