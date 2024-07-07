/**
 * Created by Giovane, 6 de jul. de 2024.
 */
package com.courses.springframework6webapp.services;

import com.courses.springframework6webapp.domain.Book;

/**
 * 
 */
public interface BookService {
	
	public Iterable<Book> findAll();

}
