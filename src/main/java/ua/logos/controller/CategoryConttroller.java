package ua.logos.controller;

import java.util.List;
import java.util.Locale.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ua.logos.domain.CategoryDTO;
import ua.logos.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryConttroller {
	@Autowired
	private CategoryService categoryService;
	@PostMapping
	public ResponseEntity<Void> save(@RequestBody CategoryDTO dto){
		categoryService.saveCategory(dto);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	@GetMapping
	public ResponseEntity<List<CategoryDTO>> findAll(){
		List<CategoryDTO> dto = categoryService.findAllCategories();
		return new ResponseEntity<List<CategoryDTO>>(dto , HttpStatus.OK);
	}
	@GetMapping("/{categoryId}")
	public ResponseEntity<CategoryDTO> findByID(@PathVariable("categoryId") Long id){
		CategoryDTO dto = categoryService.findByid(id);
		return new ResponseEntity<CategoryDTO>(dto , HttpStatus.OK);
	}
	@PutMapping("/update/{categoryId}")
	public ResponseEntity<Void> update(@PathVariable("actionId") Long id , @RequestBody CategoryDTO dto){
		CategoryDTO dtoFromDB = categoryService.findByid(id);
		if(dtoFromDB != null) {
			dto.setId(id);
			categoryService.updpateCategory(dto);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	@DeleteMapping("/delete/{actionId}")
	public ResponseEntity<CategoryDTO> delete(@PathVariable("actionId") Long id){
		CategoryDTO dto = categoryService.findByid(id);
		if(dto != null) {
			categoryService.delete(id);
			return new ResponseEntity<CategoryDTO>(dto , HttpStatus.OK);
		}
		return new ResponseEntity<CategoryDTO>(dto , HttpStatus.NOT_FOUND);
	}
}
