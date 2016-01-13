package com.birivarmi.birivarmiapp.operations;

import java.util.Enumeration;
import java.util.Hashtable;

import org.springframework.stereotype.Component;

import com.birivarmi.birivarmiapp.dto.CategoryDto;
import com.birivarmi.birivarmiapp.model.Category;
@Component
public class CategoryOperations {

	public CategoryDto findParentCategoryDtoOfGivenCategoryFromGivenHashtabel(Category category, Hashtable<Long, CategoryDto> htOfCategoryDtos){
		
		
		if(htOfCategoryDtos.containsKey(category.getParentId())){
			  CategoryDto parentCategoryDto = htOfCategoryDtos.get(category.getParentId());
			  return parentCategoryDto;
		}else{
			 Enumeration<Long> keys= htOfCategoryDtos.keys();
			 while(keys.hasMoreElements()){
				 CategoryDto tempParentCategoryDto = htOfCategoryDtos.get(keys.nextElement());
				 CategoryDto parentCategoryDto =  findParentCategoryDtoOfGivenCategoryFromGivenHashtabel(category, tempParentCategoryDto.getHtOfChildCategoryDtos());
				 if(parentCategoryDto!=null){
					 return parentCategoryDto;
				 }else{
					 continue;
				 }
			 }
			 return null;
		}
	}
}
