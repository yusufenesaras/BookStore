package bookStoreYEA.bookStore.entities.DTOs;

import java.sql.Date;
import java.util.List;


import bookStoreYEA.bookStore.entities.concretes.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookAuthorDto {
	
	private int bookId;
	private int authorId;
	

}
