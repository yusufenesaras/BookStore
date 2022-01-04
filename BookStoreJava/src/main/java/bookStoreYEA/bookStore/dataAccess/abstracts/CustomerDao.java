package bookStoreYEA.bookStore.dataAccess.abstracts;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import bookStoreYEA.bookStore.entities.concretes.Customer;

public interface CustomerDao extends JpaRepository<Customer, Integer> {
	
	Customer getByCustomerId(int customerId);
	
	Customer getByFirstName(String firstName);
	
	Customer getByLastName(String lastName);
	
	Customer getByPhoneNumber(String phoneNumber);
	
	Optional<Customer> findByEmail(String email);
	
}
