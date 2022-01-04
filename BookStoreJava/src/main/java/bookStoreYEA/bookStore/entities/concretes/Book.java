package bookStoreYEA.bookStore.entities.concretes;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "book")
@AllArgsConstructor
@NoArgsConstructor
public class Book {
	
	@Id
	@Column(name = "book_id")
	private int bookId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "summary")
	private String summary;
	
	@Column(name = "isbn13")
	private String isbn13;
	
	@Column(name = "num_pages")
	private int numPages;
	
	@Column(name = "publication_date")
	private Date publicationDate;
	
	@Column(name = "book_image_url")
	private String bookImageUrl;
	
	@ManyToOne()
	@JoinColumn(name = "category_id")
	private Category category;
	
	@ManyToOne()
	@JoinColumn(name = "language_id")
	private BookLanguage bookLanguage;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "publisher_id", nullable = false)
	private Publisher publisher;
	
}
