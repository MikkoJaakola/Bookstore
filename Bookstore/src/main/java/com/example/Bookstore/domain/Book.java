package com.example.Bookstore.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String Title, Author;
	private int Year;
	private Double isbn, Price;
	
	
	public Book() {
		
	}
	
	
	public Book(String title, String author, int year, Double isbn, Double price) {
		super();
		Title = title;
		Author = author;
		Year = year;
		this.isbn = isbn;
		Price = price;
	}
	
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getAuthor() {
		return Author;
	}
	public void setAuthor(String author) {
		Author = author;
	}
	public int getYear() {
		return Year;
	}
	public void setYear(int year) {
		Year = year;
	}
	public Double getIsbn() {
		return isbn;
	}
	public void setIsbn(Double isbn) {
		this.isbn = isbn;
	}
	public Double getPrice() {
		return Price;
	}
	public void setPrice(Double price) {
		Price = price;
	}
	
	
	
}
