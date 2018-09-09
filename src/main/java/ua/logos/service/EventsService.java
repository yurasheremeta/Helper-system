package ua.logos.service;

import java.util.List;

import ua.logos.domain.EventsDTO;

public interface EventsService {
	
	void Save(EventsDTO dto);
	
	List<EventsDTO> findAllEvents ();
	
	EventsDTO findById(Long id);
	
	void updateEvent(EventsDTO dto);
	
	void delete(Long id);

}
