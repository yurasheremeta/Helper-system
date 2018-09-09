package ua.logos.domain;

import java.sql.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class NewsDTO {
	private Long id;
	private String newsName ;
	
	private String description;
	
	private Date date;


}
