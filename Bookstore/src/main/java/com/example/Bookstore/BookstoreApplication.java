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
import com.example.Bookstore.domain.Category;
import com.example.Bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository brepository, CategoryRepository crepository) {
		
		return (args) -> {
			log.info("save a couple of books");
			/*Book k1 = new Book("Kirja", "Kirjailija", 2020, 1234.5, 25.50);
			Book k2 = new Book("Kirja2", "Kirjailija2", 2019, 1234.6, 22.50);
			
			repository.save(k1);
			repository.save(k2);*/
			
			crepository.save(new Category("Kauhu"));
			crepository.save(new Category("Komedia"));
			crepository.save(new Category("Farssi"));
			
			
			brepository.save(new Book("Paskalla on tekijänsä", "Santeri Perma", 1998, 1234.5, 25.50, 
					crepository.findByName("Farssi").get(0)));
			brepository.save(new Book("Riffien kuningas", "Gerhard Rihmakallo", 2019, 1234.6, 22.50,
					crepository.findByName("Komedia").get(0)));
			
			log.info("fetch all books");
			for (Book book : brepository.findAll()) {
				log.info(book.toString());
			}
		};
		
	}

}
