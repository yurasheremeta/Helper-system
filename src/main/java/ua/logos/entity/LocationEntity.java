package ua.logos.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "location")
public class LocationEntity extends BaseEntity {
	
	private String country;
	
	private String city;
	
	private String street;
	
	private int streetCode;
	
	private int zipCode;

}
