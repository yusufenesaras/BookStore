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
import bookStoreYEA.bookStore.core.utilities.results.DataResult;
import bookStoreYEA.bookStore.core.utilities.results.Result;
import bookStoreYEA.bookStore.entities.concretes.Author;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@RestController
@RequestMapping("/api/authors")
@CrossOrigin
public class AuthorsController {
	
	
	private AuthorService authorService;
	
	@Autowired
	public AuthorsController(AuthorService authorService) {
		super();
		this.authorService = authorService;
	}
	
	
	@GetMapping("getall")
	public DataResult<List<Author>> getAll(){
		return this.authorService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Author author){
		return this.authorService.add(author);
	}
	
	@DeleteMapping("delete")
	public Result delete(@RequestParam int authorId) {
		return this.authorService.delete(authorId);
	}
	
	@PutMapping("update")
	public ResponseEntity<?> update(@Valid @RequestBody Author author) {
		return ResponseEntity.ok(this.authorService.update(author));
	}
	
	@GetMapping("/findById")
	public DataResult<List<Author>> findById(@RequestParam int id){
		return this.authorService.findById(id);
	}
	
	
}
