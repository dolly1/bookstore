package service;

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
import org.modelmapper.ModelMapper;

import com.example.demo.model.BookStoreDO;
import com.example.demo.model.BookStoreDTO;
import com.example.demo.model.Result;
import com.example.demo.repository.BookStoreRepository;
import com.example.demo.service.BookStoreServiceImpl;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class BookStoreServiceImplTestCase {
	
	@InjectMocks
	BookStoreServiceImpl bookStoreServiceImpl;
	
	@Mock
	BookStoreRepository bookStoreRepository;
	
	@Mock
	ModelMapper modelMapper;
	
	Result result = new Result();
	BookStoreDTO bookStoreDTO = new BookStoreDTO();
	BookStoreDO bookStore = new BookStoreDO();
	List<BookStoreDO> bookList = new ArrayList<>();
	List<BookStoreDTO> bookDTO = new ArrayList<>();
	Long id;

	@BeforeEach
	public void setUp() {
		result.setMessage("success");
		bookStore.setId(1L);
			
	}
	@Test
	public void createBook() {		
		Mockito.when(bookStoreRepository.save(bookStore)).thenReturn(bookStore);
		bookStoreServiceImpl.createBook(bookStoreDTO);
	}
	
	@Test
	public void listAllBooks() {
		Mockito.when(bookStoreRepository.findAll()).thenReturn(bookList);
		BookStoreDO bookOne = new BookStoreDO();
		BookStoreDO bookTwo = new BookStoreDO();
		BookStoreDO bookThree = new BookStoreDO();
		bookList.add(bookOne);
		bookList.add(bookTwo);
		bookList.add(bookThree);
		Mockito.when(bookStoreRepository.findAll()).thenReturn(bookList);
		bookStoreServiceImpl.listAllBooks();
		
	}
	
	@Test
	public void listAllBooksIsEmpty() {
		Mockito.when(bookStoreRepository.findAll()).thenReturn(null);
		bookStoreServiceImpl.listAllBooks();
		
	}
	@Test
	public void getBookById() {
		Long id = 1L;
		Mockito.when(bookStoreRepository.existsById(id)).thenReturn(true);
		Mockito.when(bookStoreRepository.getReferenceById(id)).thenReturn(bookStore);
		bookStoreServiceImpl.getBookById(id);
	}
	
	@Test
	public void getBookByIdNotExist() {
		bookStoreServiceImpl.getBookById(id);
	}
	@Test
	public void updateBook() {
		Long id = 1L	;
		
		Mockito.when(bookStoreRepository.existsById(id)).thenReturn(true);
		Mockito.when(bookStoreRepository.getReferenceById(id)).thenReturn(bookStore);
		
		bookStore.setId(1L);
		bookStore.setTitle("Spring");
		bookStore.setAuthor("R K");
		bookStore.setPrice(500);
		bookStore.setCategory("Drama");
		bookStore.setPublisher("hall");
		bookStore.setCount(4);
		bookStore.setEdition(12);
		
		Mockito.when(bookStoreRepository.save(bookStore)).thenReturn(bookStore);
		bookStoreServiceImpl.updateBook(id, bookStoreDTO);
		
		
	}
	
	@Test
	public void updateOrCreateBook() {
		Mockito.when(bookStoreRepository.save(bookStore)).thenReturn(bookStore);
		bookStoreServiceImpl.updateBook(id, bookStoreDTO);
		
	}
	
	@Test
	public void deleteBookById() {
		Long id= 1L;
		Mockito.when(bookStoreRepository.existsById(id)).thenReturn(true);
		bookStoreServiceImpl.deleteBook(id);
	}
	
	@Test
	public void deleteBookByIdNotExist() {
		bookStoreServiceImpl.deleteBook(id);
	}
	
	
}
