package ua.logos.domain;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.logos.entity.CategoryEntity;
import ua.logos.entity.NewsEntity;

@Getter
@Setter
@NoArgsConstructor

public class NewsDTO {
	@JsonIgnore
	private Long id;
	
	private String newsId;
	
	private String newsName ;
	
	private String description;
	
	private Date date;
	
	private CategoryEntity category;
	



}
