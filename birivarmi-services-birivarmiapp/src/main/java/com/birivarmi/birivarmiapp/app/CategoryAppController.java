package com.birivarmi.birivarmiapp.app;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.birivarmi.birivarmiapp.dto.CategoryDto;
import com.birivarmi.birivarmiapp.model.Category;
import com.birivarmi.birivarmiapp.operations.CategoryOperations;
import com.birivarmi.birivarmiapp.repository.CategoryDescriptionRepository;
import com.birivarmi.birivarmiapp.repository.CategoryRepository;
import com.birivarmi.birivarmiapp.repository.CategoryStatsRepository;
import com.birivarmi.birivarmiapp.util.BirivarmiDtoUtil;
@RestController
@RequestMapping("/birivarmi/birivarmiapp/app/v1/category")
public class CategoryAppController {
	
	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(CategoryAppController.class);

	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	CategoryDescriptionRepository categoryDescriptionRepository;
	
	@Autowired
	CategoryStatsRepository categoryStatsRepository;
	
	@Autowired
	BirivarmiDtoUtil birivarmiDtoUtil;
	
	@Autowired
	CategoryOperations categoryOperations;
	
	@RequestMapping(method= RequestMethod.GET)
	public ResponseEntity<List<CategoryDto>> getCategories(){

	  List<Category> categories = categoryRepository.getCategoriesOrderByIdAsc();
	  Iterator<Category> iterOfCategories = categories.iterator();
	  Hashtable<Long, CategoryDto> htOfCategoryDtos = new Hashtable<Long, CategoryDto>();
	  while(iterOfCategories.hasNext()){
		  Category category = iterOfCategories.next();
		  CategoryDto categoryDto = birivarmiDtoUtil.newCategoryDto(category);
		  if(category.getParentId()!=null){
			  CategoryDto parentCategoryDto =  categoryOperations.findParentCategoryDtoOfGivenCategoryFromGivenHashtabel(category, htOfCategoryDtos);
			  if(parentCategoryDto.getHtOfChildCategoryDtos()!=null){
				  parentCategoryDto.getHtOfChildCategoryDtos().put(category.getId(), categoryDto);
			  }else{
				  Hashtable<Long, CategoryDto> tempHtOfCategoryDtos = new Hashtable<Long, CategoryDto>();
				  tempHtOfCategoryDtos.put(category.getId(), categoryDto);
				  parentCategoryDto.setHtOfChildCategoryDtos(tempHtOfCategoryDtos);
			  }
		  }else{
			  htOfCategoryDtos.put(category.getId(), categoryDto);			  
		  }
	  }
	  List<CategoryDto> listOfCategoryDtos = new ArrayList<CategoryDto>();
	  org.apache.commons.collections.CollectionUtils.addAll(listOfCategoryDtos, htOfCategoryDtos.values().iterator());
	  return new ResponseEntity<List<CategoryDto>>(listOfCategoryDtos, HttpStatus.OK);
	  
	}
}
