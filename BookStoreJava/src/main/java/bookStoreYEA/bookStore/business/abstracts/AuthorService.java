package bookStoreYEA.bookStore.business.abstracts;

import java.util.List;

import bookStoreYEA.bookStore.core.utilities.results.DataResult;
import bookStoreYEA.bookStore.core.utilities.results.Result;
import bookStoreYEA.bookStore.entities.concretes.Author;
import bookStoreYEA.bookStore.entities.concretes.Book;
public interface AuthorService {
	
	Result add(Author author);
	Result update(Author author);
	Result delete(int authorId);
	
	DataResult<List<Author>> findById(int id);
	DataResult<List<Author>> getAll();
}
