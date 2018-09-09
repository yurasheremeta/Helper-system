package ua.logos.service.impl;

import java.util.List;
import java.util.Locale.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.logos.domain.CategoryDTO;
import ua.logos.entity.CategoryEntity;
import ua.logos.repository.CategoryRepository;
import ua.logos.service.CategoryService;
import ua.logos.utils.ObjectMapperUtils;

@Service
public class CategoryServiceImpl implements CategoryService{
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private ObjectMapperUtils modelMapper;
	@Override
	public void saveCategory(CategoryDTO dto) {
		CategoryEntity entity = modelMapper.map(dto, CategoryEntity.class);
		categoryRepository.save(entity);
		
	}
	@Override
	public List<CategoryDTO> findAllCategories() {
		List<CategoryEntity> entity = categoryRepository.findAll();
		List<CategoryDTO> dto = modelMapper.mapAll(entity, CategoryDTO.class);
		return dto;
	}
	@Override
	public CategoryDTO findByid(Long id) {
		CategoryEntity entity = categoryRepository.findById(id).get();
		return modelMapper.map(entity, CategoryDTO.class);
	}
	@Override
	public void updpateCategory(CategoryDTO dto) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void delete(Long id) {
		categoryRepository.deleteById(id);
		
	}
	
	

}
