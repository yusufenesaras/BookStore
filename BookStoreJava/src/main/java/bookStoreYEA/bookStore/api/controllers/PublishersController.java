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

import bookStoreYEA.bookStore.business.abstracts.PublisherService;
import bookStoreYEA.bookStore.core.utilities.results.DataResult;
import bookStoreYEA.bookStore.core.utilities.results.Result;
import bookStoreYEA.bookStore.entities.DTOs.BookDto;
import bookStoreYEA.bookStore.entities.DTOs.CustomerDto;
import bookStoreYEA.bookStore.entities.DTOs.PublisherDto;
import bookStoreYEA.bookStore.entities.concretes.Publisher;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@RestController
@RequestMapping("/api/publishers/")
@AllArgsConstructor
@NoArgsConstructor
@CrossOrigin
public class PublishersController {
	
	@Autowired
	private PublisherService publisherService;
	
	@PostMapping("add")
	public Result add(@RequestBody PublisherDto publisher){
		return this.publisherService.add(publisher);
	}
	
	@DeleteMapping("delete")
	public Result delete(@RequestParam int id) {
		return this.publisherService.delete(id);
	}
	
	@PutMapping("update")
	public ResponseEntity<?> update(@RequestBody PublisherDto publisher) {
		return ResponseEntity.ok(this.publisherService.update(publisher));
	}
	
	@GetMapping("getall")
	public DataResult<List<Publisher>> getAll(){
		return this.publisherService.getAll();
	}
	
	@GetMapping("findById")
	public DataResult<Publisher> findById(@RequestParam int id){
		return this.publisherService.findById(id);
	}
	
	@GetMapping("findOneByPublisherName")
	public DataResult<Publisher> getByPublisherName(@RequestParam String publisherName){
		return this.publisherService.getByPublisherName(publisherName);
	}
}
