package ua.logos.service;

import java.util.List;

import ua.logos.domain.LocationDTO;

public interface LocationService {
	
	void saveLocation(LocationDTO dto);
	
	LocationDTO findByid(Long id);
	
	List<LocationDTO> findAllLocations();
	
	void updateLocation(LocationDTO dto);
	
	void delete(Long id);

}
