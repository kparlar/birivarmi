package com.birivarmi.birivarmiapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.birivarmi.birivarmiapp.model.Category;



public interface CategoryRepository extends CrudRepository<Category, Long>{

	@Query("Select ctgry from Category ctgry order by ctgry.id asc ")
	public List<Category> getCategoriesOrderByIdAsc();
	 
}
