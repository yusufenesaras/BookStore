package bookStoreYEA.bookStore.api.controllers;

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

import bookStoreYEA.bookStore.business.abstracts.AuthorService;
import bookStoreYEA.bookStore.business.abstracts.BookAuthorService;
import bookStoreYEA.bookStore.core.utilities.results.DataResult;
import bookStoreYEA.bookStore.core.utilities.results.Result;
import bookStoreYEA.bookStore.entities.DTOs.BookAuthorDto;
import bookStoreYEA.bookStore.entities.concretes.Author;
import bookStoreYEA.bookStore.entities.concretes.BookAuthor;

@RestController
@RequestMapping("/api/bookAuthors")
@CrossOrigin
public class BookAuthorsController {
	
	private BookAuthorService bookAuthorService;
	
	@Autowired
	public BookAuthorsController(BookAuthorService bookAuthorService) {
		super();
		this.bookAuthorService = bookAuthorService;
	}
	
	
	@GetMapping("getall")
	public DataResult<List<BookAuthor>> getAll(){
		return this.bookAuthorService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody BookAuthor bookAuthor){
		return this.bookAuthorService.add(bookAuthor);
	}
	
	@DeleteMapping("delete")
	public Result delete(@RequestParam int bookAuthorId) {
		return this.bookAuthorService.delete(bookAuthorId);
	}
	
	@PutMapping("update")
	public ResponseEntity<?> update(@Valid @RequestBody BookAuthor bookAuthor) {
		return ResponseEntity.ok(this.bookAuthorService.update(bookAuthor));
	}
	
	@GetMapping("/findById")
	public DataResult<List<BookAuthor>> findById(@RequestParam int id){
		return this.bookAuthorService.findById(id);
	}
}
