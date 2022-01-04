package bookStoreYEA.bookStore.business.concretes;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import bookStoreYEA.bookStore.business.abstracts.BookService;
import bookStoreYEA.bookStore.business.constans.Messages;
import bookStoreYEA.bookStore.core.utilities.Business.BusinessRules;
import bookStoreYEA.bookStore.core.utilities.CloudinaryHelper.CloudImageService;
import bookStoreYEA.bookStore.core.utilities.DtoTransfer.DtoService;
import bookStoreYEA.bookStore.core.utilities.results.DataResult;
import bookStoreYEA.bookStore.core.utilities.results.ErrorResult;
import bookStoreYEA.bookStore.core.utilities.results.Result;
import bookStoreYEA.bookStore.core.utilities.results.SuccessDataResult;
import bookStoreYEA.bookStore.core.utilities.results.SuccessResult;
import bookStoreYEA.bookStore.dataAccess.abstracts.BookDao;
import bookStoreYEA.bookStore.entities.DTOs.BookDto;
import bookStoreYEA.bookStore.entities.concretes.Book;
import bookStoreYEA.bookStore.entities.concretes.Category;
import bookStoreYEA.bookStore.entities.concretes.Customer;

@Service
public class BookManager implements BookService {
	
	private BookDao bookDao;
	private DtoService dtoService;
	private CloudImageService cloudImageService;
	
	@Autowired
	public BookManager(BookDao bookDao, DtoService dtoService,CloudImageService cloudImageService) {
		super();
		this.bookDao = bookDao;
		this.dtoService = dtoService;
		this.cloudImageService = cloudImageService;
	}

	@Override
	public Result add(BookDto book) {
	Result engine = BusinessRules.run(isbnLenght(book));
		if(!engine.isSuccess()) {
			return new ErrorResult(engine.getMessage());
		}else{
			this.bookDao.save((Book) 
					dtoService.dtoClassConverter(book, Book.class));
			return new SuccessResult(Messages.added);
		}
	}
	
	@Override
	public Result update(BookDto book) {
		this.bookDao.save((Book) 
				dtoService.dtoClassConverter(book, Book.class));
		return new SuccessResult(Messages.updated);
	}

	@Override
	public Result delete(int bookId) {
		
		this.bookDao.deleteById(bookId);
		return new SuccessResult(Messages.deleted);
	}
	
	@Override
	public DataResult<List<Book>> getAll() {
		return new SuccessDataResult<List<Book>>
		(this.bookDao.findAll(),Messages.bookListed);
	}


	@Override
	public DataResult<List<Book>> findById(int id) {
		return new SuccessDataResult<List<Book>>
		(this.bookDao.findById(id),Messages.listed);
	}


	@Override
	public DataResult<List<Book>> getByName(String name) {
		return new SuccessDataResult<List<Book>>
		(this.bookDao.findOneByName(name),Messages.listed);
	}


	@Override
	public DataResult<List<Book>> getByNameAndCategory(String title, int categoryId) {
		
		return new SuccessDataResult<List<Book>>
		(this.bookDao.getByNameAndCategory(title, categoryId),Messages.listed);
	}


	@Override
	public DataResult<List<Book>> getOneByCategory(int categoryId) {
		
		return new SuccessDataResult<List<Book>>
		(this.bookDao.getOneByCategory(categoryId),Messages.listed);
	}
	
	@Override
	public DataResult<List<Book>> getOneByLanguage(int languageId) {
		return new SuccessDataResult<List<Book>>
		(this.bookDao.getOneByLanguage(languageId),Messages.listed);
	}

	@Override
	public DataResult<List<Book>> getOneByPublisher(int publisherId) {
		return new SuccessDataResult<List<Book>>
		(this.bookDao.getOneByPublisher(publisherId),Messages.listed);
	}
	
	@Override
	public Result uploadPhoto(int bookId, MultipartFile multipartFile) throws IOException {
		
		  var result = this.cloudImageService.upload(multipartFile);
	      var url = result.getData().get("url");
	      Book ref = this.bookDao.getOne(bookId); 
	      ref.setBookImageUrl(url.toString());
	      this.bookDao.save(ref); 
	      
	      return new SuccessResult("Başarılı");
	}
	
	@Override
	public DataResult<List<Book>> getAllSortedByAsc() {
		Sort sort = Sort.by(Sort.Direction.ASC,"numPages");
		return new SuccessDataResult<List<Book>>
		(this.bookDao.findAll(sort),"Başarılı");
	}
	
	@Override
	public DataResult<List<Book>> getAllSortedByDesc() {
		Sort sort = Sort.by(Sort.Direction.DESC,"numPages");
		return new SuccessDataResult<List<Book>>
		(this.bookDao.findAll(sort),"Başarılı");
	}
	
	@Override
	public DataResult<List<Book>> getOneByPublisherName(String publisherName) {
		return new SuccessDataResult<List<Book>>
		(this.bookDao.getOneByPublisherName(publisherName),Messages.listed);
	}
	
	// private methods
	
	private Result isbnLenght(BookDto book) {
	     if(book.getIsbn13().length() == 13) {
	    		return new SuccessResult();
	     }else{
		     return new ErrorResult(Messages.isbnVerification);
	     }
	}

}
