 package bookStoreYEA.bookStore.business.abstracts;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import bookStoreYEA.bookStore.core.utilities.results.DataResult;
import bookStoreYEA.bookStore.core.utilities.results.Result;
import bookStoreYEA.bookStore.entities.DTOs.BookDto;
import bookStoreYEA.bookStore.entities.concretes.Book;

public interface BookService {
	
	Result add(BookDto book);
	Result update(BookDto book);
	Result delete(int bookId);
	
	DataResult<List<Book>> getAll();
	DataResult<List<Book>> findById(int id);
	DataResult<List<Book>> getAllSortedByAsc();
	DataResult<List<Book>> getAllSortedByDesc();
	DataResult<List<Book>> getByName(String title);
	DataResult<List<Book>> getOneByCategory(int categoryId);
	DataResult<List<Book>> getOneByLanguage(int languageId);
	DataResult<List<Book>> getOneByPublisher(int publisherId);
	DataResult<List<Book>> getOneByPublisherName(String publisherName);
	DataResult<List<Book>> getByNameAndCategory(String title,int categoryId);
	
	Result uploadPhoto(int bookId, MultipartFile multipartFile) throws IOException;
}
