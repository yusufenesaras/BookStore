package bookStoreYEA.bookStore.business.concretes;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bookStoreYEA.bookStore.business.abstracts.CustomerService;
import bookStoreYEA.bookStore.business.constans.Messages;
import bookStoreYEA.bookStore.core.utilities.Business.BusinessRules;
import bookStoreYEA.bookStore.core.utilities.DtoTransfer.DtoService;
import bookStoreYEA.bookStore.core.utilities.results.DataResult;
import bookStoreYEA.bookStore.core.utilities.results.ErrorDataResult;
import bookStoreYEA.bookStore.core.utilities.results.ErrorResult;
import bookStoreYEA.bookStore.core.utilities.results.Result;
import bookStoreYEA.bookStore.core.utilities.results.SuccessDataResult;
import bookStoreYEA.bookStore.core.utilities.results.SuccessResult;
import bookStoreYEA.bookStore.dataAccess.abstracts.CustomerDao;
import bookStoreYEA.bookStore.entities.DTOs.CustomerDto;
import bookStoreYEA.bookStore.entities.concretes.Customer;
import bookStoreYEA.bookStore.entities.concretes.Publisher;

@Service
public class CustomerManager implements CustomerService {
		
	CustomerDao customerDao;
	DtoService dtoService;
	
	@Autowired
	public CustomerManager(CustomerDao customerDao, DtoService dtoService) {
		super();
		this.customerDao = customerDao;
		this.dtoService = dtoService;
	}
		
	@Override
	public Result add(Customer customer) {
		Result engine = BusinessRules.run(
				isRealEmail(customer),
				emailNullChecker(customer),
				isMailRegistered(customer));
		if(!engine.isSuccess()) {
			return new ErrorDataResult<Customer>(null,engine.getMessage());
		}
		return new SuccessDataResult<Customer>
		(this.customerDao.save(customer),Messages.added);
	}
	
	@Override
	public Result delete(int id) {
		this.customerDao.deleteById(id);
		return new SuccessResult(Messages.deleted);
	}
	
	@Override
	public Result update(CustomerDto customer) {
		this.customerDao.save((Customer) 
				dtoService.dtoClassConverter(customer, Customer.class));
		return new SuccessResult(Messages.updated);
	}
	
	@Override
	public DataResult<Customer> getByCustomerId(int customerId) {
		return new SuccessDataResult<Customer>
		(this.customerDao.getByCustomerId(customerId));
	}

	@Override
	public DataResult<Customer> getByFirstName(String firstName) {
		return new SuccessDataResult<Customer>
		(this.customerDao.getByFirstName(firstName));
	}

	@Override
	public DataResult<Customer> getByLastName(String lastName) {
		return new SuccessDataResult<Customer>
		(this.customerDao.getByLastName(lastName));
	}

	@Override
	public DataResult<Customer> getByPhoneNumber(String phoneNumber) {
		return new SuccessDataResult<Customer>
		(this.customerDao.getByPhoneNumber(phoneNumber));
	}

	@Override
	public DataResult<List<Customer>> getAll() {
		return new SuccessDataResult<List<Customer>>
		(this.customerDao.findAll());
	}
	
	private Result isRealEmail(Customer customer) {
		 String regex = "^(.+)@(.+)$";
	     Pattern pattern = Pattern.compile(regex);
	     Matcher matcher = pattern.matcher(customer.getEmail());
	     if(!matcher.matches()) {
	    		return new ErrorResult(Messages.isRealMail);
	     }
	     return new SuccessResult();
	}
	
	private Result emailNullChecker(Customer customer) {
		if(customer.getEmail().isBlank() || customer.getEmail().equals(null)) {
			return new ErrorResult(Messages.requiredEmail);
		}
		return new SuccessResult();
	}
	
	private Result isMailRegistered(Customer customer) {
		if(customerDao.findByEmail(customer.getEmail()).stream().count() != 0) {
			return new ErrorResult(Messages.alreadyRegisteredMail);
		}
		 return new SuccessResult();
	}

	
}
