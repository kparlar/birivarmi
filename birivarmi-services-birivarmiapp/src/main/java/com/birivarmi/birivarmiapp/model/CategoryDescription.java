package com.birivarmi.birivarmiapp.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="BV_CATEGORY_DESCRIPTION")
public class CategoryDescription extends BirivarmiItemWithoutId	{
	
	
	@EmbeddedId
    private CategoryDescriptionPK id;
	
	@Column(name="NAME", length=100, nullable=false)
	private String name;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name="DESCRIPTION", length=1000, nullable=true)
	private String description;
	@Column(name="SLUG", length=100, nullable=false)
	private String slug;
	
	public CategoryDescriptionPK getId() {
		return id;
	}
	public void setId(CategoryDescriptionPK id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSlug() {
		return slug;
	}
	public void setSlug(String slug) {
		this.slug = slug;
	}
	
	
}
