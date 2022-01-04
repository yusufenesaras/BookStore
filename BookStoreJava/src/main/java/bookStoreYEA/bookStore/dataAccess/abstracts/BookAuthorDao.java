package bookStoreYEA.bookStore.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import bookStoreYEA.bookStore.entities.concretes.BookAuthor;

public interface BookAuthorDao extends JpaRepository<BookAuthor, Integer>{
	
 	List<BookAuthor> findById(@Param("") int id);

}
