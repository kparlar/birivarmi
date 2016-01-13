package com.birivarmi.birivarmiapp.dto;

import java.util.Hashtable;
import java.util.List;

public class CategoryDto {

	private String id;
	private String parentId;
	private String expirationDays;
	private String position;
	private String enabled;
	private String priceEnabled;
	private String iconPath;	
	private List<CategoryDescriptionDto> categoryDescriptionDtos;
	private CategoryStatsDto categoryStatsDto;
	/**
	 * Child Categories.
	 */
	private List<CategoryDto> childCategoryDtos;
	
	private Hashtable<Long, CategoryDto> htOfChildCategoryDtos;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getExpirationDays() {
		return expirationDays;
	}

	public void setExpirationDays(String expirationDays) {
		this.expirationDays = expirationDays;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	public String getPriceEnabled() {
		return priceEnabled;
	}

	public void setPriceEnabled(String priceEnabled) {
		this.priceEnabled = priceEnabled;
	}

	public String getIconPath() {
		return iconPath;
	}

	public void setIconPath(String iconPath) {
		this.iconPath = iconPath;
	}

	public List<CategoryDescriptionDto> getCategoryDescriptionDtos() {
		return categoryDescriptionDtos;
	}

	public void setCategoryDescriptionDtos(List<CategoryDescriptionDto> categoryDescriptionDtos) {
		this.categoryDescriptionDtos = categoryDescriptionDtos;
	}

	public CategoryStatsDto getCategoryStatsDto() {
		return categoryStatsDto;
	}

	public void setCategoryStatsDto(CategoryStatsDto categoryStatsDto) {
		this.categoryStatsDto = categoryStatsDto;
	}

	public List<CategoryDto> getChildCategoryDtos() {
		return childCategoryDtos;
	}

	public void setChildCategoryDtos(List<CategoryDto> childCategoryDtos) {
		this.childCategoryDtos = childCategoryDtos;
	}

	public Hashtable<Long, CategoryDto> getHtOfChildCategoryDtos() {
		return htOfChildCategoryDtos;
	}

	public void setHtOfChildCategoryDtos(Hashtable<Long, CategoryDto> htOfChildCategoryDtos) {
		this.htOfChildCategoryDtos = htOfChildCategoryDtos;
	}

	
	
	
}
