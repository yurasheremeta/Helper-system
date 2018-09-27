package ua.logos.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import ua.logos.domain.EventsDTO;
import ua.logos.entity.EventsEntity;

public interface EventsService {
	
	void Save(EventsDTO dto);
	
	List<EventsDTO> findAllEvents ();
	
	EventsDTO findById(String eventId);
	
	void updateEvent(EventsDTO dto);
	
	void delete(Long id);
	
	EventsDTO deleteByEventId(String eventId);
	
	
	List<EventsDTO> findAccident();

	List<EventsDTO> findMurder();
	
	List<EventsDTO> findRobbery();
	
	List<EventsDTO> findFires();
	
	List<EventsDTO> findRape();

}
