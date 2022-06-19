package com.udemy.master.hibernate.jpa.controller.book;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.master.hibernate.jpa.entity.book.Book;

/**
 * The Class BookController.
 */
@RestController
public class BookController {

	/**
	 * Gets the all books.
	 *
	 * @return the all books
	 */
	@GetMapping("/books")
	public List<Book> getAllBooks() {
		return Arrays.asList(new Book(1L, "Harry Potter: and the philosopher's stone", "J.K. Rolling"));
	}

}
