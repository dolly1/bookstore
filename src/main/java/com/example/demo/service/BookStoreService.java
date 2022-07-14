package com.example.demo.service;

import java.util.List;

import com.example.demo.model.BookStoreDTO;
import com.example.demo.model.Result;

public interface BookStoreService {

	
	Result createBook(BookStoreDTO bookStoreDTO);
	
	List<BookStoreDTO> listAllBooks();
	
	Result getBookById(Long id);
	
	Result updateBook (Long id , BookStoreDTO bookStoreDTO);
	
	Result deleteBook (Long id);
	
	
	
}
