package com.courses.springframework6webapp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.courses.springframework6webapp.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long>{

}
