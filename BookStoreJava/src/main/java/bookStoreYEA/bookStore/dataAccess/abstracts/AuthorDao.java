package bookStoreYEA.bookStore.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import bookStoreYEA.bookStore.entities.concretes.Author;
import bookStoreYEA.bookStore.entities.concretes.Book;

public interface AuthorDao extends JpaRepository<Author, Integer>{

 	List<Author> findById(@Param("") int id);

}
