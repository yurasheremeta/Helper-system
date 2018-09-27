package ua.logos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListenerMethodProcessor;
import org.springframework.stereotype.Service;



import ua.logos.domain.EventsDTO;
import ua.logos.entity.EventsEntity;
import ua.logos.exceptions.EventNotFoundException;
import ua.logos.exceptions.EventsServiceException;
import ua.logos.repository.CategoryRepository;
import ua.logos.repository.EventsRepository;
import ua.logos.service.EventsService;
import ua.logos.utils.ObjectMapperUtils;
import ua.logos.utils.StringUtils;
import static ua.logos.constants.ErrorMessages.*;

@Service
public class EventsServiceImpl implements EventsService {
	@Autowired
	private EventsRepository eventsRepository;
	@Autowired
	private ObjectMapperUtils modelMapper;
	@Autowired
	private StringUtils stringUtils;
	@Override
	public void Save(EventsDTO dto) {
		String eventId = stringUtils.generate();
		if(!eventsRepository.existsByEventId(eventId)) {
		EventsEntity entity = modelMapper.map(dto, EventsEntity.class);
		entity.setEventId(eventId);
		eventsRepository.save(entity);
		}else {
			throw new EventsServiceException(RECORD_ALREDY_EXIST);
		}
	}
	@Override
	public List<EventsDTO> findAllEvents() {
		List<EventsEntity> entity = eventsRepository.findAll();
		List<EventsDTO> dto = modelMapper.mapAll(entity, EventsDTO.class);
		return dto;
	}
	@Override
	public EventsDTO findById(String eventId) {
		EventsEntity entity = eventsRepository.findByEventId(eventId);
		if(entity == null) {
			throw new EventsServiceException(NO_RECORD_FOUND);
		}
		return modelMapper.map(entity, EventsDTO.class);
	}
	@Override
	public void updateEvent(EventsDTO dto) {
		eventsRepository.save(modelMapper.map(dto, EventsEntity.class));
		
	}
	@Override
	public void delete(Long id) {
		eventsRepository.deleteById(id);
		
	}
	
	@Override
	public EventsDTO deleteByEventId(String eventId) {
		EventsEntity entity = eventsRepository.deleteByEventId(eventId);
		if(entity == null) {
			throw new EventsServiceException(NO_RECORD_FOUND);
		}
		return modelMapper.map(entity, EventsDTO.class);
	}
	@Override
	public List<EventsDTO> findAccident() {
		List<EventsEntity> entity = eventsRepository.findAccident();
		List<EventsDTO> dto = modelMapper.mapAll(entity, EventsDTO.class);
		return dto;
	}
	@Override
	public List<EventsDTO> findMurder() {
		List<EventsEntity> entity = eventsRepository.findMurder();
		List<EventsDTO> dto = modelMapper.mapAll(entity, EventsDTO.class);
		return dto;
	}
	@Override
	public List<EventsDTO> findRobbery() {
		List<EventsEntity> entity = eventsRepository.findRobbery();
		List<EventsDTO> dto = modelMapper.mapAll(entity, EventsDTO.class);
		return dto;
	}
	@Override
	public List<EventsDTO> findFires() {
		List<EventsEntity> entity = eventsRepository.findFires();
		List<EventsDTO> dto = modelMapper.mapAll(entity, EventsDTO.class);
		return dto;
	}
	@Override
	public List<EventsDTO> findRape() {
		List<EventsEntity> entity = eventsRepository.findRape();
		List<EventsDTO> dto = modelMapper.mapAll(entity, EventsDTO.class);
		return dto;
	}
	
	
	
	
	

}
