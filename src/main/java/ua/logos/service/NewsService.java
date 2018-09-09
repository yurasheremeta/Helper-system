package ua.logos.service;

import java.util.List;

import ua.logos.domain.NewsDTO;

public interface NewsService {
	
	void save(NewsDTO dto);
	
	List<NewsDTO> findAllNews();
	
	NewsDTO findByid(Long id);
	
	void update(NewsDTO dto);
	
	void delete(Long id);

}
