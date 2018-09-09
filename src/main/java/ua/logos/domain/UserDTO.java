package ua.logos.domain;

import java.sql.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.logos.entity.BaseEntity;

@Getter
@Setter
@NoArgsConstructor

public class UserDTO {
	private Long id;
private String firstName;
	
	private String lastName;
	
	private String username;
	
	private String password;
	
	private Date dayOfBirth;
	
	
}
