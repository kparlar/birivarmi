package com.birivarmi.birivarmiapp.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.birivarmi.birivarmiapp.dto.CategoryDescriptionDto;
import com.birivarmi.birivarmiapp.dto.CategoryDto;
import com.birivarmi.birivarmiapp.dto.CategoryStatsDto;
import com.birivarmi.birivarmiapp.model.Category;
import com.birivarmi.birivarmiapp.model.CategoryDescription;
import com.birivarmi.birivarmiapp.model.CategoryStats;
import com.birivarmi.birivarmiapp.model.CategoryStatsPK;
import com.birivarmi.birivarmiapp.repository.CategoryDescriptionRepository;
import com.birivarmi.birivarmiapp.repository.CategoryStatsRepository;

@Component
public class BirivarmiDtoUtil {
	@Autowired
	CategoryDescriptionRepository categoryDescriptionRepository;
	
	@Autowired
	CategoryStatsRepository categoryStatsRepository;
	
	
	
	public CategoryDto newCategoryDto(Category category){
		
		List<CategoryDescription> categoryDescriptions = categoryDescriptionRepository.getCategoryDescriptionsByCategoryId(category.getId());
	    CategoryStatsPK categoryStatsPK = new CategoryStatsPK();
		categoryStatsPK.setCategory(category);
		CategoryStats categoryStats = categoryStatsRepository.findOne(categoryStatsPK);
		
		List<CategoryDescriptionDto> categoryDescriptionDtos = null;
		if(!CollectionUtils.isEmpty(categoryDescriptions)){
			categoryDescriptionDtos = new ArrayList<CategoryDescriptionDto>();
			for (CategoryDescription categoryDescription : categoryDescriptions) {
				CategoryDescriptionDto categoryDescriptionDto = newCategoryDescriotionDto(categoryDescription);
				categoryDescriptionDtos.add(categoryDescriptionDto);
			}
		}else{
			//do nothing.
		}
		
		CategoryDto categoryDto = new CategoryDto();
		categoryDto.setCategoryDescriptionDtos(categoryDescriptionDtos);		
		categoryDto.setCategoryStatsDto(newCategoryStatsDto(categoryStats));
		//categoryDto.setChildCategoryDtos(childCategoryDtos);
		categoryDto.setEnabled(category.getEnabled().equals(BirivarmiConstantsUtil.CHAR_TRUE)? BirivarmiConstantsUtil.ABBRVTN_TRUE: BirivarmiConstantsUtil.ABBRVTN_FALSE);
		categoryDto.setExpirationDays(category.getExpirationDays().toString());
		categoryDto.setIconPath(category.getIconPath()!=null?category.getIconPath():"");
		categoryDto.setId(category.getId().toString());
		categoryDto.setParentId(category.getParentId()!=null? category.getParentId().toString():"");
		categoryDto.setPosition(category.getPosition().toString());
		categoryDto.setPriceEnabled(category.getPriceEnabled().equals(BirivarmiConstantsUtil.CHAR_TRUE)?BirivarmiConstantsUtil.ABBRVTN_TRUE: BirivarmiConstantsUtil.ABBRVTN_FALSE);
		return categoryDto;
	}
	
	public CategoryDescriptionDto newCategoryDescriotionDto(CategoryDescription categoryDescription){
		CategoryDescriptionDto categoryDescriptionDto = new CategoryDescriptionDto();
		categoryDescriptionDto.setCategoryId(categoryDescription.getId().getCategory().getId().toString());
		categoryDescriptionDto.setDescription(categoryDescription.getDescription());
		categoryDescriptionDto.setLocalCode(categoryDescription.getId().getLocalCode());
		categoryDescriptionDto.setName(categoryDescription.getName());
		return categoryDescriptionDto;
	}
	
	public CategoryStatsDto newCategoryStatsDto(CategoryStats categoryStats){
		CategoryStatsDto categoryStatsDto = new CategoryStatsDto();
		categoryStatsDto.setCategoryId(categoryStats.getId().getCategory().getId().toString());
		categoryStatsDto.setNumItems(categoryStats.getNumItems().toString());
		return categoryStatsDto;
	}
	
}
