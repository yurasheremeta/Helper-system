package ua.logos.repository;

import java.util.Locale.Category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;


import ua.logos.entity.CategoryEntity;
@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
	@Query("Select c from CategoryEntity c where c.id = 1")
	List<CategoryEntity> findCulture();
	@Query("Select c from CategoryEntity c where c.id = 2")
	List<CategoryEntity> findSport();
	@Query("Select c from CategoryEntity c where c.id = 3")
	List<CategoryEntity> findPolitics();

}
