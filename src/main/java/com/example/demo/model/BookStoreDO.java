package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "BookStore")
public class BookStoreDO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	private Long id;
	
	@Column(name = "title", length = 250 )
	private String title;
	
	@Column(name = "author")
	private String author;
	
	@Column(name = "amount")
	private float price;
	
	@Column(name = "category")
	private String category;
	
	@Column(name = "publisher")
	private String publisher;
	
	@Column(name = "books_available")
	private int count;
	
	@Column(name = "edition")
	private int edition;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getEdition() {
		return edition;
	}

	public void setEdition(int edition) {
		this.edition = edition;
	}

	public BookStoreDO(Long id, String title, String author, float price, String category, String publisher, int count,
			int edition) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.price = price;
		this.category = category;
		this.publisher = publisher;
		this.count = count;
		this.edition = edition;
	}

	public BookStoreDO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
