package bookStoreYEA.bookStore.entities.DTOs;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {
	
	private int customerId;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
}
