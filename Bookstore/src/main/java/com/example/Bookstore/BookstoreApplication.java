package com.example.Bookstore;
//mod 1414
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository repository) {
		
		return (args) -> {
			log.info("save a couple of books");
			/*Book k1 = new Book("Kirja", "Kirjailija", 2020, 1234.5, 25.50);
			Book k2 = new Book("Kirja2", "Kirjailija2", 2019, 1234.6, 22.50);
			
			repository.save(k1);
			repository.save(k2);*/
			
			repository.save(new Book("Kirja", "Kirjailija", 2020, 1234.5, 25.50));
			repository.save(new Book("Kirja2", "Kirjailija2", 2019, 1234.6, 22.50));
			
			log.info("fetch all books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}
		};
		
	}

}
