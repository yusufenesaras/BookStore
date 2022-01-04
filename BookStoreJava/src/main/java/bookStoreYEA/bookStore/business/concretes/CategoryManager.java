package bookStoreYEA.bookStore.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bookStoreYEA.bookStore.business.abstracts.CategoryService;
import bookStoreYEA.bookStore.business.constans.Messages;
import bookStoreYEA.bookStore.core.utilities.results.DataResult;
import bookStoreYEA.bookStore.core.utilities.results.Result;
import bookStoreYEA.bookStore.core.utilities.results.SuccessDataResult;
import bookStoreYEA.bookStore.core.utilities.results.SuccessResult;
import bookStoreYEA.bookStore.dataAccess.abstracts.CategoryDao;
import bookStoreYEA.bookStore.entities.concretes.Category;
import bookStoreYEA.bookStore.entities.concretes.Customer;

@Service
public class CategoryManager implements CategoryService {
	
	private CategoryDao categoryDao;
	
	public CategoryManager(CategoryDao categoryDao) {
		super();
		this.categoryDao = categoryDao;
	}

	@Override
	public Result add(Category category) {
		return new SuccessDataResult<Category>
		(this.categoryDao.save(category),Messages.added);
	}


	@Override
	public Result update(Category category) {
		return new SuccessDataResult<Category>
		(this.categoryDao.save(category),Messages.updated);
	}


	@Override
	public Result delete(int categoryId) {
		this.categoryDao.deleteById(categoryId);
		return new SuccessResult(Messages.deleted);
	}
	
	@Override
	public DataResult<Category> findById(int id) {
		return new SuccessDataResult<Category>
		(this.categoryDao.findById(id),Messages.listed);
	}

	@Override
	public DataResult<List<Category>> getAll() {
		return new SuccessDataResult<List<Category>>
		(this.categoryDao.findAll(),Messages.categoryListed);
	}

}
