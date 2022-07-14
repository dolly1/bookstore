package controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import com.example.demo.controller.BookStoreController;
import com.example.demo.model.BookStoreDTO;
import com.example.demo.model.Result;
import com.example.demo.service.BookStoreService;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class BookStoreControllerTestCase {
	
	@InjectMocks
	BookStoreController bookStoreController;
	
	@Mock
	BookStoreService bookStoreService;

	Result result = new Result();
	BookStoreDTO bookStoreDTO = new BookStoreDTO();
	Long id;
	List<BookStoreDTO> bookList = new ArrayList<>();
	
	@BeforeEach
	public void setUp() {
		result.setMessage("success");
	}
	
	@Test
	public void createBook() {
		Mockito.when(bookStoreService.createBook(bookStoreDTO)).thenReturn(result);
		bookStoreController.createBook(bookStoreDTO);
		
	}
	
	@Test
	public void listAllBooks() {
		Mockito.when(bookStoreService.listAllBooks()).thenReturn(bookList);
				bookStoreController.listAllBooks();		
	}
	
	@Test
	public void getBookById() {
		Mockito.when(bookStoreService.getBookById(id)).thenReturn(result);
		bookStoreController.getBookById(id);			
	}
	
	@Test
	public void updateBook() {
		Mockito.when(bookStoreService.createBook(bookStoreDTO)).thenReturn(result);
		bookStoreController.updateBook(id, bookStoreDTO);		
	}
	
	@Test
	public void deleteBook() {
		Mockito.when(bookStoreService.createBook(bookStoreDTO)).thenReturn(result);
		bookStoreController.deleteBook(id);
		
	}
	

}
