package com.udemy.master.hibernate.jpa.controller.book;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.master.hibernate.jpa.entity.book.Book;

@RestController
public class BookController {

	@GetMapping("/books")
	public List<Book> getAllBooks() {
		return Arrays.asList(new Book(1L, "Harry Potter: and the philosopher's stone", "J.K. Rolling"));
	}

}
