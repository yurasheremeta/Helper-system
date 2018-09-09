package ua.logos.service;

import java.util.List;

import ua.logos.domain.CategoryDTO;
import ua.logos.entity.CategoryEntity;

public interface CategoryService {
	
	void saveCategory(CategoryDTO dto);
	
	List<CategoryDTO> findAllCategories();
	
	CategoryDTO findByid(Long id);
	
	void updpateCategory(CategoryDTO dto);
	
	void delete (Long id);
	

}
