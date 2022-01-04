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

import bookStoreYEA.bookStore.business.abstracts.CustomerService;
import bookStoreYEA.bookStore.core.utilities.results.DataResult;
import bookStoreYEA.bookStore.core.utilities.results.Result;
import bookStoreYEA.bookStore.entities.DTOs.CustomerDto;
import bookStoreYEA.bookStore.entities.concretes.Book;
import bookStoreYEA.bookStore.entities.concretes.Customer;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@RestController
@RequestMapping("/api/customer")
@AllArgsConstructor
@NoArgsConstructor
@CrossOrigin
public class CustomersController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/getall")
	public DataResult<List<Customer>> getAll(){
		return this.customerService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Customer customer){
		return this.customerService.add(customer);
	}
	
	@DeleteMapping("delete")
	public Result delete(@RequestParam int id) {
		return this.customerService.delete(id);
	}
	
	@PutMapping("update")
	public ResponseEntity<?> update(@Valid @RequestBody CustomerDto customerDto) {
		return ResponseEntity.ok(this.customerService.update(customerDto));
	}
	
	@GetMapping("/getByCustomerId")
	public DataResult<Customer> getById(@RequestParam int customerId){
		return this.customerService.getByCustomerId(customerId);
	}

}
