package com.birivarmi.birivarmiapp.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="BV_ITEM_DESCRIPTION")
public class ItemDescription extends BirivarmiItemWithoutId	{

	@EmbeddedId
    private ItemDescriptionPK id;
	
	@Column(name="TITLE", length=100, nullable=false)
	private String title;
	
	@Column(name="DESCRIPTION", length=65535, nullable=false)
	private String description;

	public ItemDescriptionPK getId() {
		return id;
	}

	public void setId(ItemDescriptionPK id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
