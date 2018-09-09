package ua.logos.service;

import java.util.List;

import ua.logos.domain.ActionDTO;
import ua.logos.entity.ActionEntity;

public interface ActionService {
	
	void saveAction(ActionDTO dto);
	
	List<ActionDTO> findAllActions ();
	
	ActionDTO findById(Long id);
	
	void updateAction(ActionDTO dto);
	
	void deleteAction(Long id);

}
