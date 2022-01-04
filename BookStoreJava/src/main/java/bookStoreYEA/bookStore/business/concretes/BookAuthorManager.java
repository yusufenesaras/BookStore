package bookStoreYEA.bookStore.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import bookStoreYEA.bookStore.business.abstracts.BookAuthorService;
import bookStoreYEA.bookStore.business.constans.Messages;
import bookStoreYEA.bookStore.core.utilities.DtoTransfer.DtoService;
import bookStoreYEA.bookStore.core.utilities.results.DataResult;
import bookStoreYEA.bookStore.core.utilities.results.Result;
import bookStoreYEA.bookStore.core.utilities.results.SuccessDataResult;
import bookStoreYEA.bookStore.core.utilities.results.SuccessResult;
import bookStoreYEA.bookStore.dataAccess.abstracts.BookAuthorDao;
import bookStoreYEA.bookStore.entities.DTOs.BookAuthorDto;
import bookStoreYEA.bookStore.entities.concretes.Book;
import bookStoreYEA.bookStore.entities.concretes.BookAuthor;
import bookStoreYEA.bookStore.entities.concretes.Category;

@Service
public class BookAuthorManager implements BookAuthorService{
	
	private BookAuthorDao bookAuthorDao;
	private DtoService dtoService;
	
	public BookAuthorManager(BookAuthorDao bookAuthorDao,DtoService dtoService) {
		super();
		this.bookAuthorDao = bookAuthorDao;
		this.dtoService = dtoService;
	}

	@Override
	public Result add(BookAuthor bookAuthor) {
		return new SuccessDataResult<BookAuthor>
		(this.bookAuthorDao.save(bookAuthor),Messages.added);
	}

	@Override
	public Result update(BookAuthor bookAuthor) {
		return new SuccessDataResult<BookAuthor>
		(this.bookAuthorDao.save(bookAuthor),Messages.updated);
	}

	@Override
	public Result delete(int bookAuthorId) {
		this.bookAuthorDao.deleteById(bookAuthorId);
		return new SuccessResult(Messages.deleted);
	}

	@Override
	public DataResult<List<BookAuthor>> findById(int id) {
		return new SuccessDataResult<List<BookAuthor>>
		(this.bookAuthorDao.findById(id),Messages.listed);
	}

	@Override
	public DataResult<List<BookAuthor>> getAll() {
		return new SuccessDataResult<List<BookAuthor>>
		(this.bookAuthorDao.findAll(),Messages.listed);
	}

}
