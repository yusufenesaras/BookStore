package bookStoreYEA.bookStore.entities.DTOs;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {
	
	private int bookId;
	private int categoryId;
	private int publisherId;
	private int bookLanguageId;
	
	private Date publicationDate;
	
	private String name;
	private String summary;
	private String isbn13;
	private String numPages;
	private String bookImageUrl;
}
