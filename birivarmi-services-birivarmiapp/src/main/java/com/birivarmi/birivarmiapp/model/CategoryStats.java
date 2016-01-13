package com.birivarmi.birivarmiapp.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="BV_CATEGORY_STATS")
public class CategoryStats extends BirivarmiItemWithoutId{

	
	@EmbeddedId
    private CategoryStatsPK id;
	
	
	@Column(name="NUM_ITEMS", nullable=false)
	private Long numItems;
	
	
	public CategoryStatsPK getId() {
		return id;
	}
	public void setId(CategoryStatsPK id) {
		this.id = id;
	}
	public Long getNumItems() {
		return numItems;
	}
	public void setNumItems(Long numItems) {
		this.numItems = numItems;
	}
	
	
}
