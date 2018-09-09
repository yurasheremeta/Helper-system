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
@Table(name = "news")
public class NewsEntity extends BaseEntity {
	
	private String newsName ;
	
	private String description;
	
	private Date date;

}
