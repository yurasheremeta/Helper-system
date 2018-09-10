package ua.logos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.logos.domain.NewsDTO;
import ua.logos.entity.NewsEntity;
import ua.logos.repository.NewsRepository;
import ua.logos.service.NewsService;
import ua.logos.utils.ObjectMapperUtils;
@Service
public class NewsServiceImpl implements NewsService {
	@Autowired
	private NewsRepository newsRepository;
	@Autowired
	private ObjectMapperUtils modelMapper;
	@Override
	public void save(NewsDTO dto) {
		NewsEntity entity = modelMapper.map(dto, NewsEntity.class);
		newsRepository.save(entity);
		
	}
	@Override
	public List<NewsDTO> findAllNews() {
		List<NewsEntity> entity = newsRepository.findAll();
		List<NewsDTO> dto = modelMapper.mapAll(entity, NewsDTO.class);
		return dto;
	}
	@Override
	public NewsDTO findByid(Long id) {
		NewsEntity entity = newsRepository.findById(id).get();
		return modelMapper.map(entity, NewsDTO.class);
	}
	@Override
	public void update(NewsDTO dto) {
		newsRepository.save(modelMapper.map(dto, NewsEntity.class));
		
	}
	@Override
	public void delete(Long id) {
		newsRepository.deleteById(id);
		
	}
	
	

}
