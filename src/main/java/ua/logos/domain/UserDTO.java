package ua.logos.domain;

import java.sql.Date;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.logos.entity.BaseEntity;
import ua.logos.entity.EventsEntity;
import ua.logos.entity.UserEntity;
import ua.logos.entity.enums.UserRole;

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
	
	private List<EventsEntity> events;
	
	private UserEntity user;
	
	private UserRole role;
	
	
}
