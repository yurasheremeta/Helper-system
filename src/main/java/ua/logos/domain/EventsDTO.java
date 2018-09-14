package ua.logos.domain;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.logos.entity.ActionEntity;
import ua.logos.entity.LocationEntity;
import ua.logos.entity.UserEntity;

@Getter
@Setter
@NoArgsConstructor

public class EventsDTO {
	private Long id;
	
	private String eventId;
	
	private String eventName;

	private String eventDescription;
	
	private Date date;
	
	private LocationEntity location;
	

	private ActionEntity action;

	
	private UserEntity user;

}
