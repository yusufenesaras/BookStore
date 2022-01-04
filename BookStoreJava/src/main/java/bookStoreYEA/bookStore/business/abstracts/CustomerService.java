package bookStoreYEA.bookStore.business.abstracts;

import java.util.List;

import bookStoreYEA.bookStore.core.utilities.results.DataResult;
import bookStoreYEA.bookStore.core.utilities.results.Result;
import bookStoreYEA.bookStore.entities.DTOs.CustomerDto;
import bookStoreYEA.bookStore.entities.concretes.Customer;

public interface CustomerService {
	
	Result add(Customer customer);	
	Result update(CustomerDto customer);
	Result delete(int customerId);
	
	DataResult<Customer> getByCustomerId(int customerId);
	
	DataResult<Customer> getByFirstName(String firstName);

	DataResult<Customer> getByLastName(String lastName);
	
	DataResult<Customer> getByPhoneNumber(String phoneNumber);
		
	DataResult<List<Customer>> getAll();
}
