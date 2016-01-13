package com.birivarmi.birivarmiapp.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="BV_ITEM_RESOURCE")
@DiscriminatorValue("BV_ITEM_RESOURCE")
public class ItemResource extends BirivarmiItem{

	@ManyToOne(fetch=FetchType.LAZY, cascade={CascadeType.PERSIST})
	@JoinColumn(name="ITEM_ID", insertable=true, updatable=true, nullable=false)
	private Item item;
	
	@Column(name="NAME", length=60, nullable=false)
	private String name;
	
	@Column(name="EXTENSION", length=60, nullable=false)
	private String extension;
	
	@Column(name="CONTENT_TYPE", length=40, nullable=false)
	private String contentType;
	
	@Column(name="PATH", length=250, nullable=false)
	private String path;

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	
	
}
