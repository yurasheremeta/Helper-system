package ua.logos.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import ua.logos.domain.CategoryDTO;
import ua.logos.entity.CategoryEntity;

public interface CategoryService {
	
	void saveCategory(CategoryDTO dto);
	
	List<CategoryDTO> findAllCategories();
	
	CategoryDTO findByid(Long id);
	
	void updpateCategory(CategoryDTO dto);
	
	void delete (Long id);
	



}
