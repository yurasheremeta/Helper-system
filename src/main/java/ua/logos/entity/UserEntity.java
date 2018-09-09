package ua.logos.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity {
	
	private String firstName;
	
	private String lastName;
	
	private String username;
	
	private String password;
	
	private Date dayOfBirth;
	
	

}
