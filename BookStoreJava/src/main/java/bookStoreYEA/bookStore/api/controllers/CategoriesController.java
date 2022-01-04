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

import bookStoreYEA.bookStore.business.abstracts.CategoryService;
import bookStoreYEA.bookStore.core.utilities.results.DataResult;
import bookStoreYEA.bookStore.core.utilities.results.Result;
import bookStoreYEA.bookStore.entities.DTOs.CustomerDto;
import bookStoreYEA.bookStore.entities.concretes.Category;
import bookStoreYEA.bookStore.entities.concretes.Customer;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@RestController
@RequestMapping("/api/categories")
@AllArgsConstructor
@NoArgsConstructor
@CrossOrigin
public class CategoriesController {
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/getall")
	public DataResult<List<Category>> getAll(){
		return this.categoryService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Category category){
		return this.categoryService.add(category);
	}
	
	@DeleteMapping("delete")
	public Result delete(@RequestParam int categoryId) {
		return this.categoryService.delete(categoryId);
	}
	
	@PutMapping("update")
	public ResponseEntity<?> update(@Valid @RequestBody Category category) {
		return ResponseEntity.ok(this.categoryService.update(category));
	}
	
	@GetMapping("/getById")
	public DataResult<Category> findById(@RequestParam int categoryId){
		return this.categoryService.findById(categoryId);
	}
	
	
}
