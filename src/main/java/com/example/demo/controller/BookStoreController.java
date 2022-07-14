package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.BookStoreDTO;
import com.example.demo.model.Result;
import com.example.demo.service.BookStoreService;

@RestController
@RequestMapping("/bookstore")
public class BookStoreController {
	
	@Autowired
	private BookStoreService bookStoreService;
	
	/**
	 * This method add new book with unique ID.
	 * @param bookStoreDTO
	 * @return
	 */
		@PostMapping("/create")
		public Result createBook(@RequestBody BookStoreDTO bookStoreDTO) {
			return bookStoreService.createBook(bookStoreDTO);
	}
	
		
	/**
	 * Get all books available.
	 * @return
	 */
		@GetMapping("readall")
		public List<BookStoreDTO> listAllBooks(){
			return bookStoreService.listAllBooks();
	}
		
		
	/**
	 * Get books by ID.
	 * @param id
	 * @return
     */
		@GetMapping("readbyid/{id}")
		public Result getBookById(@PathVariable("id") Long id){
			return bookStoreService.getBookById(id);
	}
		
		
	/**
	 * Update book.
	 * @param id
	 * @param bookStoreDTO
	 * @return
	 */
		@PutMapping("/update/{id}")
		public Result updateBook (@PathVariable("id") Long id ,@RequestBody BookStoreDTO bookStoreDTO) {
			return bookStoreService.updateBook(id, bookStoreDTO);
	}
		
	/**
	  * Delete book.
	  * @param id
	  * @return
	  */
		@DeleteMapping("/delete/{id}")
		public Result deleteBook (@PathVariable("id")  Long id) {
			return bookStoreService.deleteBook(id);
		}
	}
	

