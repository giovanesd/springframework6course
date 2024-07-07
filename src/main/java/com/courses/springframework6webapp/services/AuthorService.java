/**
 * Created by Giovane, 7 de jul. de 2024.
 */
package com.courses.springframework6webapp.services;

import com.courses.springframework6webapp.domain.Author;

/**
 * 
 */
public interface AuthorService {
	
	public Iterable<Author> findAll();

}
