package com.example.Bookstore.domain;
//mod 1204
import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository <Book, Long> {
	
	List<Book> findByTitle(String title);
	
}
