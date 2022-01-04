package bookStoreYEA.bookStore.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import bookStoreYEA.bookStore.entities.concretes.Book;

public interface BookDao extends JpaRepository<Book,Integer> {
	
	List<Book> findById(int id);
	
	List<Book> findOneByName(@Param("") String title);
		
	@Query("From Book where name=:name and categoryId=:categoryId")
	List<Book> getByNameAndCategory(String name, int categoryId);
	
	@Query("From Book where category.categoryId=:categoryId")
	List<Book> getOneByCategory(int categoryId);
	
	@Query("From Book where bookLanguage.languageId=:languageId")
	List<Book> getOneByLanguage(int languageId);
	
	@Query("From Book where publisher.publisherId=:publisherId")
	List<Book> getOneByPublisher(int publisherId);
	
	@Query("From Book where publisher.publisherName=:publisherName")
	List<Book> getOneByPublisherName(String publisherName);
	
	
}	
