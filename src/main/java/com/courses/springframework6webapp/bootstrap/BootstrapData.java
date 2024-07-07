/**
 * Created by Giovane, 6 de jul. de 2024.
 */
package com.courses.springframework6webapp.bootstrap;

import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.courses.springframework6webapp.domain.Author;
import com.courses.springframework6webapp.domain.Book;
import com.courses.springframework6webapp.domain.Publisher;
import com.courses.springframework6webapp.repositories.AuthorRepository;
import com.courses.springframework6webapp.repositories.BookRepository;
import com.courses.springframework6webapp.repositories.PublisherRepository;

import jakarta.transaction.Transactional;

/**
 * 
 */
@Component
public class BootstrapData implements CommandLineRunner {
	
	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;
	private final PublisherRepository publisherRepository;
		
	public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}

	@Transactional
	@Override
	public void run(String... args) throws Exception {
		Publisher publisher = new Publisher();
		publisher.setPublisherName("O'Reilly Media Inc");
		publisher.setAddress("1005 Gravenstein Hwy N");
		publisher.setCity("Sebastopol");
		publisher.setState("California");
		publisher.setZipCode("95472");
		
		Publisher publisherSaved = publisherRepository.save(publisher);
		
		Author author = new Author();

		Book book = new Book();
		book.setTitle("Dominando Spring");
		book.setIsbn("123456");
		book.setPublisher(publisherSaved);

		Book bookSaved = bookRepository.save(book);

		author.setFirstName("Giovane");
		author.setLastName("de Deus");
		author.getBooks().add(bookSaved);
		
		Author authorSaved = authorRepository.save(author);
		
		bookSaved.getAuthors().add(authorSaved);
		bookRepository.save(bookSaved);
		
		book = new Book();
		book.setTitle("Dominando Preguiça");
		book.setIsbn("123457");
		book.setPublisher(publisherSaved);

		bookSaved = bookRepository.save(book);

		author = new Author();
		author.setFirstName("Francisco");
		author.setLastName("Neto");
		author.getBooks().add(bookSaved);
		
		authorSaved = authorRepository.save(author);
		
		bookSaved.getAuthors().add(authorSaved);
		bookRepository.save(bookSaved);
		
		System.out.println("In Bootstrap");
		System.out.println("Author count: " + authorRepository.count());
		System.out.println("Book count: " + bookRepository.count());
		System.out.println("Publisher count: " + publisherRepository.count());
		
		for (Author a : authorRepository.findAll()) {
			Set<Book> books = a.getBooks();
			for (Book b : books) {
				System.out.println("Author: " + a.getFirstName() + " " + a.getLastName() + " - Book: " + b.getTitle() + " - Publisher: " + b.getPublisher().getPublisherName());
			}
			
		}
	}
}
