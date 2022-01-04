package bookStoreYEA.bookStore.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bookStoreYEA.bookStore.business.abstracts.AuthorService;
import bookStoreYEA.bookStore.business.constans.Messages;
import bookStoreYEA.bookStore.core.utilities.results.DataResult;
import bookStoreYEA.bookStore.core.utilities.results.Result;
import bookStoreYEA.bookStore.core.utilities.results.SuccessDataResult;
import bookStoreYEA.bookStore.core.utilities.results.SuccessResult;
import bookStoreYEA.bookStore.dataAccess.abstracts.AuthorDao;
import bookStoreYEA.bookStore.entities.concretes.Author;
import bookStoreYEA.bookStore.entities.concretes.Book;
import bookStoreYEA.bookStore.entities.concretes.Category;

@Service
public class AuthorManager implements AuthorService{

	@Autowired
	private AuthorDao authorDao;
	
	public AuthorManager(AuthorDao authorDao) {
		super();
		this.authorDao = authorDao;
	}
	
	@Override
	public Result add(Author author) {
		return new SuccessDataResult<Author>
		(this.authorDao.save(author),Messages.added);
	}

	@Override
	public Result update(Author author) {
		return new SuccessDataResult<Author>
		(this.authorDao.save(author),Messages.updated);
	}

	@Override
	public Result delete(int authorId) {
		this.authorDao.deleteById(authorId);
		return new SuccessResult(Messages.deleted);
	}

	@Override
	public DataResult<List<Author>> findById(int id) {
		
		return new SuccessDataResult<List<Author>>
		(this.authorDao.findById(id),Messages.listed);
	}
	@Override
	public DataResult<List<Author>> getAll() {
		return new SuccessDataResult<List<Author>>
		(this.authorDao.findAll(),Messages.listed);
	}

}
