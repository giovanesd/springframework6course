/**
 * Created by Giovane, 6 de jul. de 2024.
 */
package com.courses.springframework6webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.courses.springframework6webapp.domain.Author;
import com.courses.springframework6webapp.domain.Book;
import com.courses.springframework6webapp.domain.Publisher;
import com.courses.springframework6webapp.repositories.AuthorRepository;
import com.courses.springframework6webapp.repositories.BookRepository;
import com.courses.springframework6webapp.repositories.PublisherRepository;

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

	@Override
	public void run(String... args) throws Exception {
		Author author = new Author();
		author.setFirstName("Giovane");
		author.setLastName("de Deus");
		
		Book book = new Book();
		book.setTitle("Dominando Spring");
		book.setIsbn("123456");
		
		Author authorSaved = authorRepository.save(author);
		Book bookSaved = bookRepository.save(book);
		
		authorSaved.getBooks().add(bookSaved);
		authorRepository.save(authorSaved);
		
		author = new Author();
		author.setFirstName("Francisco");
		author.setLastName("Neto");
		
		book = new Book();
		book.setTitle("Dominando Preguiça");
		book.setIsbn("123457");
		
		authorSaved = authorRepository.save(author);
		bookSaved = bookRepository.save(book);
		
		authorSaved.getBooks().add(bookSaved);
		authorRepository.save(authorSaved);
		
		System.out.println("In Bootstrap");
		System.out.println("Author count: " + authorRepository.count());
		System.out.println("Book count: " + bookRepository.count());
		
		Publisher publisher = new Publisher();
		publisher.setPublisherName("O'Reilly Media Inc");
		publisher.setAddress("1005 Gravenstein Hwy N");
		publisher.setCity("Sebastopol");
		publisher.setState("California");
		publisher.setZip("95472");
		
		Publisher publisherSaved = publisherRepository.save(publisher);
		
		System.out.println("Publisher count: " + publisherRepository.count());
	}
}
