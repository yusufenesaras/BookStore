package bookStoreYEA.bookStore.business.abstracts;

import java.util.List;

import bookStoreYEA.bookStore.core.utilities.results.DataResult;
import bookStoreYEA.bookStore.core.utilities.results.Result;
import bookStoreYEA.bookStore.entities.DTOs.PublisherDto;
import bookStoreYEA.bookStore.entities.concretes.Publisher;

public interface PublisherService {
	
	Result add(PublisherDto publisher);
	Result update(PublisherDto publisher);
	Result delete(int publisherId);
	DataResult<List<Publisher>> getAll();
	DataResult<Publisher> findById(int id);
	DataResult<Publisher> getByPublisherName(String name);
}
