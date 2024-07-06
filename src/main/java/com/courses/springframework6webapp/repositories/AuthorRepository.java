package com.courses.springframework6webapp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.courses.springframework6webapp.domain.Author;

public interface AuthorRepository extends CrudRepository<Author, Long>{

}
