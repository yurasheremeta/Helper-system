package ua.logos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListenerMethodProcessor;
import org.springframework.stereotype.Service;

import ua.logos.domain.EventsDTO;
import ua.logos.entity.EventsEntity;
import ua.logos.repository.CategoryRepository;
import ua.logos.repository.EventsRepository;
import ua.logos.service.EventsService;
import ua.logos.utils.ObjectMapperUtils;

@Service
public class EventsServiceImpl implements EventsService {
	@Autowired
	private EventsRepository eventsRepository;
	@Autowired
	private ObjectMapperUtils modelMapper;
	@Override
	public void Save(EventsDTO dto) {
		EventsEntity entity = modelMapper.map(dto, EventsEntity.class);
		eventsRepository.save(entity);
	}
	@Override
	public List<EventsDTO> findAllEvents() {
		List<EventsEntity> entity = eventsRepository.findAll();
		List<EventsDTO> dto = modelMapper.mapAll(entity, EventsDTO.class);
		return dto;
	}
	@Override
	public EventsDTO findById(Long id) {
		EventsEntity entity = eventsRepository.findById(id).get();
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
	
	

}
