package ua.logos.domain;

import java.sql.Date;

import javax.persistence.Column;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class EventsDTO {
	private Long id;
	
	private String eventName;

	private String eventDescription;
	
	private Date date;

}
