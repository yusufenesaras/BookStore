package bookStoreYEA.bookStore.entities.DTOs;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import bookStoreYEA.bookStore.entities.concretes.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PublisherDto {
	
	private int publisherId;
	private String publisherName;
	
	@JsonIgnore
	private List<Book> books;
}
