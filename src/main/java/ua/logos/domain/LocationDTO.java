package ua.logos.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
public class LocationDTO {
	
	private Long id;

	
private String country;
	
	private String city;
	
	private String street;
	
	private int streetCode;
	
	private int zipCode;

}
