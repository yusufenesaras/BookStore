package bookStoreYEA.bookStore.business.abstracts;

import java.util.List;

import bookStoreYEA.bookStore.core.utilities.results.DataResult;
import bookStoreYEA.bookStore.core.utilities.results.Result;
import bookStoreYEA.bookStore.entities.DTOs.BookAuthorDto;
import bookStoreYEA.bookStore.entities.concretes.BookAuthor;

public interface BookAuthorService {
	
	Result add(BookAuthor bookAuthor);
	Result update(BookAuthor bookAuthor);
	Result delete(int bookAuthorId);
	
	DataResult<List<BookAuthor>> findById(int id);
	DataResult<List<BookAuthor>> getAll();
}
