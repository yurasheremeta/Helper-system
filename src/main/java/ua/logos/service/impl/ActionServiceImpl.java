package ua.logos.service.impl;

import java.util.List;

import javax.persistence.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.logos.domain.ActionDTO;
import ua.logos.entity.ActionEntity;
import ua.logos.repository.ActionRepository;
import ua.logos.service.ActionService;
import ua.logos.utils.ObjectMapperUtils;
@Service
public class ActionServiceImpl implements ActionService{
	
	@Autowired
	private ActionRepository actionRepository;
	@Autowired
	private ObjectMapperUtils modelMapper;

	@Override
	public void saveAction(ActionDTO dto) {
		ActionEntity entity = modelMapper.map(dto, ActionEntity.class);
		actionRepository.save(entity);
	}

	@Override
	public List<ActionDTO> findAllActions() {
		List<ActionEntity> entity = actionRepository.findAll();
		List<ActionDTO> dto = modelMapper.mapAll(entity, ActionDTO.class);
		return dto;
	}

	@Override
	public ActionDTO findById(Long id) {
		ActionEntity entity = actionRepository.findById(id).get();
		return modelMapper.map(entity, ActionDTO.class);
	}

	@Override
	public void updateAction(ActionDTO dto) {
		actionRepository.save(modelMapper.map(dto, ActionEntity.class));
		
	}

	@Override
	public void deleteAction(Long id) {
		actionRepository.deleteById(id);
		
	}
	
	

}
