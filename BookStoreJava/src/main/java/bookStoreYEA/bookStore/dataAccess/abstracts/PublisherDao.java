package bookStoreYEA.bookStore.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import bookStoreYEA.bookStore.entities.concretes.Publisher;

public interface PublisherDao extends JpaRepository<Publisher, Integer>{
	
	Publisher findById(int id);
	Publisher getOneByPublisherName(@Param("") String name);
}
