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
@Table(name = "action")
public class ActionEntity extends BaseEntity {
	
	private String actionName;
	
	private String actionDescription;

}
