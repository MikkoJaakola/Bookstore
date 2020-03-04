package com.example.Bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository repository) {
		
		return (args) -> {
			Book k1 = new Book("Kirja", "Kirjailija", 2020, 1234.5, 25.50);
			Book k2 = new Book("Kirja2", "Kirjailija2", 2019, 1234.6, 22.50);
			
			repository.save(k1);
			repository.save(k2);
		};
		
	}

}
