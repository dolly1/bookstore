package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.BookStoreDO;
import com.example.demo.model.BookStoreDTO;
import com.example.demo.model.Result;
import com.example.demo.repository.BookStoreRepository;

@Service
public class BookStoreServiceImpl implements BookStoreService{

	@Autowired
	private BookStoreRepository bookStoreRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	Result result =new Result();
	
	
	@Override
	public Result createBook(BookStoreDTO bookStoreDTO) {
	
		BookStoreDO bookStoreDO = mapToEntity(bookStoreDTO);
		BookStoreDO book = bookStoreRepository.save(bookStoreDO);
		BookStoreDTO bookStore = mapToDTO(book);
		result.setData(bookStore);
		result.setMessage("book added successfully");		
		return result;		
	}

	@Override
	public List<BookStoreDTO> listAllBooks() {
		List<BookStoreDTO> bookList = new ArrayList<>();
		List<BookStoreDO> bookStoreDO =bookStoreRepository.findAll();
		
		if(bookStoreDO != null) {
			for(BookStoreDO book: bookStoreDO) {				
				bookList.add(mapToDTO(book));
			}						
		}
		return bookList;
	}
	

	@Override
	public Result getBookById(Long id) {
		
		if(bookStoreRepository.existsById(id)) {
			BookStoreDO bookStoreDO = bookStoreRepository.getReferenceById(id);	
			BookStoreDTO bookStore = mapToDTO(bookStoreDO);
			result.setData(bookStore);
			result.setMessage("Book details related with id");
			return result;
	}
		else {
			result.setMessage("Book does not exist");
			result.setData(null);
			return result;
		}
	}

	@Override
	public Result updateBook(Long id, BookStoreDTO bookStoreDTO) {
		
		
		if(bookStoreRepository.existsById(id)) {
			BookStoreDO bookStoreDO = bookStoreRepository.getReferenceById(id);
			
			bookStoreDO.setTitle(bookStoreDTO.getTitle());
			bookStoreDO.setAuthor(bookStoreDTO.getAuthor());
			bookStoreDO.setPrice(bookStoreDTO.getPrice());
			bookStoreDO.setCategory(bookStoreDTO.getCategory());
			bookStoreDO.setPublisher(bookStoreDTO.getPublisher());
			bookStoreDO.setCount(bookStoreDTO.getCount());
			bookStoreDO.setEdition(bookStoreDTO.getEdition());		
		
			BookStoreDO updateBook = bookStoreRepository.save(bookStoreDO);
			BookStoreDTO bookDTO = mapToDTO(updateBook);
			result.setData(bookDTO);
			result.setMessage("book updated successfully");		
			return result;
	}
		else {
			result.setMessage("Creating new data");
			BookStoreDO bookStore = mapToEntity(bookStoreDTO);
			BookStoreDO book = bookStoreRepository.save(bookStore);
			BookStoreDTO bookDTO = mapToDTO(book);
			result.setData(bookDTO);
			return result;
			}
	}

	@Override
	public Result deleteBook(Long id) {
		Result result = new Result();
		if (bookStoreRepository.existsById(id)) {
			   bookStoreRepository.deleteById(id);
			   result.setMessage("Deleted successfully");
		}
		else {
			result.setMessage("Book not exist with id provided");
			result.setData(null);
		}
		return result;
	}
	
	private BookStoreDTO mapToDTO(BookStoreDO bookStoreDO) {		
		BookStoreDTO bookStoreDTO = modelMapper.map(bookStoreDO, BookStoreDTO.class);
		return bookStoreDTO;
	}
	
	private BookStoreDO mapToEntity(BookStoreDTO bookStoreDTO) {		
		BookStoreDO bookStoreDO = modelMapper.map(bookStoreDTO, BookStoreDO.class);
		return bookStoreDO;
	}

}
