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
import com.example.Bookstore.domain.User;
import com.example.Bookstore.domain.UserRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository brepository, CategoryRepository crepository, 
			UserRepository urepository) {
		
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
			brepository.save(new Book("Valintojen maailma", "Tom of Finland", 2002, 1674.6, 57.99,
					crepository.findByName("Komedia").get(0)));
			brepository.save(new Book("Selviytyjät", "Maxwell Gothenburg", 1992, 365.9, 6.50,
					crepository.findByName("Kauhu").get(0)));
			brepository.save(new Book("Kutuluola", "Pulkkinen", 1998, 1098.6, 18.50,
					crepository.findByName("Komedia").get(0)));
			brepository.save(new Book("Spirit of the new age", "Jussi Pattitussi", 1999, 1239.6, 21.50,
					crepository.findByName("Komedia").get(0)));
			brepository.save(new Book("Betoni", "Kalervo Jankko", 2015, 1354.6, 27.50,
					crepository.findByName("Komedia").get(0)));
			
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			
			
			
			log.info("fetch all books");
			for (Book book : brepository.findAll()) {
				log.info(book.toString());
			}
		};
		
	}

}
