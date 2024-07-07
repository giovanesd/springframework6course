/**
 * Created by Giovane, 7 de jul. de 2024.
 */
package com.courses.springframework6webapp.services;

import org.springframework.stereotype.Service;

import com.courses.springframework6webapp.domain.Author;
import com.courses.springframework6webapp.repositories.AuthorRepository;

/**
 * 
 */
@Service
public class AuthorServiceImpl implements AuthorService {

	private final AuthorRepository authorRepository;
	
	/**
	 * @param authorRepository
	 */
	public AuthorServiceImpl(AuthorRepository authorRepository) {
		this.authorRepository = authorRepository;
	}

	@Override
	public Iterable<Author> findAll() {
		return authorRepository.findAll();
	}

}
