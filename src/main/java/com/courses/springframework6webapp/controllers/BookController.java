/**
 * Created by Giovane, 7 de jul. de 2024.
 */
package com.courses.springframework6webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.courses.springframework6webapp.services.BookService;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 */
@Controller
public class BookController {

	private final BookService bookService;

	/**
	 * @param bookService
	 */
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}
	
	
	@RequestMapping("/books")
	public String getBooks(Model model) {
		model.addAttribute("books", this.bookService.findAll());
		return "books";
	}
}
