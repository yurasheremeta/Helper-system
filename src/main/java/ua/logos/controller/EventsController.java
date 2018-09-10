package ua.logos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListenerMethodProcessor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ua.logos.domain.EventsDTO;
import ua.logos.service.EventsService;

@RestController
@RequestMapping("events")
public class EventsController {
	@Autowired
	private EventsService eventsService;
	@PostMapping
	public ResponseEntity<Void> save(@RequestBody EventsDTO dto){
		eventsService.Save(dto);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	@GetMapping
	public ResponseEntity<List<EventsDTO>> findAll(){
		List<EventsDTO> dto = eventsService.findAllEvents();
		return new ResponseEntity<List<EventsDTO>>(dto , HttpStatus.OK);
	}

	@GetMapping("/{eventId}")
	public ResponseEntity<EventsDTO> findById(@PathVariable("eventId") Long id){
		EventsDTO dto = eventsService.findById(id);
		return new ResponseEntity<EventsDTO>(dto , HttpStatus.OK);	
	}
	@PutMapping("/update/{eventId}")
	public ResponseEntity<Void> update(@PathVariable("eventId") Long id , @RequestBody EventsDTO dto){
		EventsDTO dtoFromDb = eventsService.findById(id);
		if(dtoFromDb != null) {
			dto.setId(id);
			eventsService.updateEvent(dto);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	@DeleteMapping("/delete/{eventId}")
	public ResponseEntity<EventsDTO> delete(@PathVariable("eventId") Long id){
		EventsDTO dto= eventsService.findById(id);
		if(dto != null) {
			eventsService.delete(id);
			return new ResponseEntity<EventsDTO>(dto , HttpStatus.OK);
		}
		return new ResponseEntity<EventsDTO>(dto , HttpStatus.NOT_FOUND);
		
	}
}
