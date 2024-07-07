/**
 * Created by Giovane, 7 de jul. de 2024.
 */
package com.courses.springframework6webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.courses.springframework6webapp.repositories.AuthorRepository;

/**
 * 
 */
@Controller
public class AuthorController {
	
	private final AuthorRepository authorService;

	/**
	 * @param authorService
	 */
	public AuthorController(AuthorRepository authorService) {
		this.authorService = authorService;
	}
	
	@RequestMapping("/authors")
	public String getAuthors (Model model) {
		model.addAttribute("authors", authorService.findAll());
		return "authors";
	}

}
