package ua.logos.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Table;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

@Table(name = "events")
public class EventsEntity extends BaseEntity {
	
	@Column(name = "event_name")
	private String eventName;
	@Column(name = "event_description")
	private String eventDescription;
	
	private Date date;
	
	


}
