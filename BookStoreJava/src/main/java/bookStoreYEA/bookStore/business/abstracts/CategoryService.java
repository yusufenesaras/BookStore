package bookStoreYEA.bookStore.business.abstracts;


import java.util.List;

import bookStoreYEA.bookStore.core.utilities.results.DataResult;
import bookStoreYEA.bookStore.core.utilities.results.Result;
import bookStoreYEA.bookStore.entities.DTOs.PublisherDto;
import bookStoreYEA.bookStore.entities.concretes.Category;

public interface CategoryService {
	
	Result add(Category category);
	Result update(Category category);
	Result delete(int categoryId);
	
	DataResult<Category> findById(int id);
	DataResult<List<Category>> getAll();
}
