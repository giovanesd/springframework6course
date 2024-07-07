/**
 * Created by Giovane, 6 de jul. de 2024.
 */
package com.courses.springframework6webapp.services;

import org.springframework.stereotype.Service;

import com.courses.springframework6webapp.domain.Book;
import com.courses.springframework6webapp.repositories.BookRepository;

/**
 * 
 */
@Service
public class BookServiceImpl implements BookService{

	private final BookRepository bookRepository;
	
	/**
	 * @param bookRepository
	 */
	public BookServiceImpl(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	@Override
	public Iterable<Book> findAll() {
		return this.bookRepository.findAll();
	}

}
