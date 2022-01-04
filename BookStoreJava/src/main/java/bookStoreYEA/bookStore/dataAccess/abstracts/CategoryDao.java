package bookStoreYEA.bookStore.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import bookStoreYEA.bookStore.entities.concretes.Category;

public interface CategoryDao extends JpaRepository<Category, Integer>{
	 
	Category findById(int id);
}
