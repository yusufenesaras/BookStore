package bookStoreYEA.bookStore.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bookStoreYEA.bookStore.business.abstracts.PublisherService;
import bookStoreYEA.bookStore.business.constans.Messages;
import bookStoreYEA.bookStore.core.utilities.Business.BusinessRules;
import bookStoreYEA.bookStore.core.utilities.DtoTransfer.DtoService;
import bookStoreYEA.bookStore.core.utilities.results.DataResult;
import bookStoreYEA.bookStore.core.utilities.results.ErrorResult;
import bookStoreYEA.bookStore.core.utilities.results.Result;
import bookStoreYEA.bookStore.core.utilities.results.SuccessDataResult;
import bookStoreYEA.bookStore.core.utilities.results.SuccessResult;
import bookStoreYEA.bookStore.dataAccess.abstracts.PublisherDao;
import bookStoreYEA.bookStore.entities.DTOs.PublisherDto;
import bookStoreYEA.bookStore.entities.concretes.Book;
import bookStoreYEA.bookStore.entities.concretes.Category;
import bookStoreYEA.bookStore.entities.concretes.Customer;
import bookStoreYEA.bookStore.entities.concretes.Publisher;

@Service
public class PublisherManager implements PublisherService {

	PublisherDao publisherDao;
	DtoService dtoService;
	
	@Autowired
	public PublisherManager(PublisherDao publisherDao,
			DtoService dtoService) {
		super();
		this.publisherDao = publisherDao;
		this.dtoService = dtoService;
	}
	
	@Override
	public Result add(PublisherDto publisher) {
		this.publisherDao.save((Publisher) 
				dtoService.dtoClassConverter(publisher, Publisher.class));
		return new SuccessResult(Messages.added);
	}
	
	@Override
	public Result update(PublisherDto publisher) {
		this.publisherDao.save((Publisher) 
				dtoService.dtoClassConverter(publisher, Publisher.class));
		return new SuccessResult(Messages.updated);
	}

	@Override
	public Result delete(int publisherId) {
		this.publisherDao.deleteById(publisherId);
		return new SuccessResult(Messages.deleted);
	}
	
	@Override
	public DataResult<Publisher> findById(int id) {
		return new SuccessDataResult<Publisher>
		(this.publisherDao.getById(id),Messages.listed);
	}

	@Override
	public DataResult<Publisher> getByPublisherName(String name) {
		return new SuccessDataResult<Publisher>
		(this.publisherDao.getOneByPublisherName(name),Messages.listed);
	}

	@Override
	public DataResult<List<Publisher>> getAll() {
		return new SuccessDataResult<List<Publisher>>
		(this.publisherDao.findAll(),Messages.publisherListed);
	}

}
