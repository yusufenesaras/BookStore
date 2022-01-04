package bookStoreYEA.bookStore.api.controllers;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import bookStoreYEA.bookStore.business.abstracts.BookService;
import bookStoreYEA.bookStore.core.utilities.results.DataResult;
import bookStoreYEA.bookStore.core.utilities.results.Result;
import bookStoreYEA.bookStore.entities.DTOs.BookDto;
import bookStoreYEA.bookStore.entities.DTOs.CustomerDto;
import bookStoreYEA.bookStore.entities.concretes.Book;
import bookStoreYEA.bookStore.entities.concretes.Customer;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@RestController
@RequestMapping("/api/books/")
@AllArgsConstructor
@NoArgsConstructor
@CrossOrigin
public class BooksController {
	
	@Autowired
	private BookService bookService;
	
	@PostMapping("add")
	public Result add(@RequestBody BookDto book){
		return this.bookService.add(book);
	}
	
	@DeleteMapping("delete")
	public Result delete(@RequestParam int bookId) {
		return this.bookService.delete(bookId);
	}
	
	@PutMapping("update")
	public ResponseEntity<?> update(@Valid @RequestBody BookDto book) {
		return ResponseEntity.ok(this.bookService.update(book));
	}
	
	@GetMapping("getall")
	public DataResult<List<Book>> getAll(){
		return this.bookService.getAll();
	}
	
	@GetMapping("findById")
	public DataResult<List<Book>> findById(@RequestParam int id){
		return this.bookService.findById(id);
	}
	
	@GetMapping("findOneByName")
	public DataResult<List<Book>> findOneByName(@RequestParam String name){
		return this.bookService.getByName(name);
	}
	
	@GetMapping("getByNameAndCategory")
	public DataResult<List<Book>> getByNameAndCategory(@RequestParam String name, int categoryId) {
		return this.bookService.getByNameAndCategory(name,categoryId);
	}
	
	@GetMapping("getByCategory")
	public DataResult<List<Book>> getOneByCategory(@RequestParam int categoryId) {
		return this.bookService.getOneByCategory(categoryId);
	}
	
	@GetMapping("getOneByLanguage")
	public DataResult<List<Book>> getOneByLanguage(@RequestParam int languageId) {
		return this.bookService.getOneByLanguage(languageId);
	}
	
	@GetMapping("getOneByPublisher")
	public DataResult<List<Book>> getOneByPublisher(@RequestParam int publisherId) {
		return this.bookService.getOneByPublisher(publisherId);
	}
	
	@GetMapping("getOneByPublisherName")
	public DataResult<List<Book>> getOneByPublisherName(@RequestParam String name) {
		return this.bookService.getOneByPublisherName(name);
	}
	@GetMapping("getAllSortedByAsc")
	public DataResult<List<Book>> getAllSortedByAsc() {
		return this.bookService.getAllSortedByAsc();
	}
	
	@GetMapping("getAllSortedByDesc")
	public DataResult<List<Book>> getAllSortedByDesc() {
		return this.bookService.getAllSortedByDesc();
	}
	
	
	@PostMapping("uploadPhoto")
	public Result uploadPhoto(@RequestParam int bookId, 
			@RequestParam MultipartFile multipartFile) throws IOException{
		return this.bookService.uploadPhoto(bookId, multipartFile);
	}
	
}
