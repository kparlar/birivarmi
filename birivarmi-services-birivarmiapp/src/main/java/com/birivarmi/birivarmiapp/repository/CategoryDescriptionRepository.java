package com.birivarmi.birivarmiapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import com.birivarmi.birivarmiapp.model.CategoryDescription;
import com.birivarmi.birivarmiapp.model.CategoryDescriptionPK;



public interface CategoryDescriptionRepository extends CrudRepository<CategoryDescription, CategoryDescriptionPK>{
	
	@Query("Select cd from CategoryDescription cd where cd.id.category.id = ?1")
	public List<CategoryDescription> getCategoryDescriptionsByCategoryId(Long categoryId);
	

}
