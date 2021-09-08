package com.example.Bookstore.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String title, author;
	private int year;
	private Double isbn, price;
	
	
    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "categoryid")
    private Category category;
	
	
	public Book() {
		
	}
	
	
	public Book(String title, String author, int year, Double isbn, Double price, Category category) {
		super();
		this.title = title;
		this.author = author;
		this.year = year;
		this.isbn = isbn;
		this.price = price;
		this.category = category;
	}
	
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public Double getIsbn() {
		return isbn;
	}
	public void setIsbn(Double isbn) {
		this.isbn = isbn;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	@Override
	public String toString() {
		
		if (this.category != null)
				
			return "Book [id=" + id + ", Title=" + title + ", Author=" + author + ", Year=" + year +
			", isbn=" + isbn + ", Price=" + price + " category =" + this.getCategory() +"]";
			
		else
		
		return "Book [id=" + id + ", Title=" + title + ", Author=" + author + ", Year=" + year +
				", isbn=" + isbn + ", Price=" + price +"]";
	}
	
}
