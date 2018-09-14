package ua.logos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.logos.domain.NewsDTO;
import ua.logos.entity.NewsEntity;
import ua.logos.exceptions.NewsServiceException;
import ua.logos.repository.NewsRepository;
import ua.logos.service.NewsService;
import ua.logos.utils.ObjectMapperUtils;
import ua.logos.utils.StringUtils;
import static ua.logos.constants.ErrorMessages.*;
@Service
public class NewsServiceImpl implements NewsService {
	@Autowired
	private NewsRepository newsRepository;
	@Autowired
	private ObjectMapperUtils modelMapper;
	@Autowired
	private StringUtils stringUtils;
	@Override
	public void save(NewsDTO dto) {
		String newsId = stringUtils.generate();
		if(!newsRepository.existsByNewsId(newsId)) {
		NewsEntity entity = modelMapper.map(dto, NewsEntity.class);
		entity.setNewsId(newsId);
		newsRepository.save(entity);
		}else {
			throw new NewsServiceException(RECORD_ALREDY_EXIST);
		}
		
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
