package com.birivarmi.birivarmiapp.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@SuppressWarnings("serial")
@Embeddable
public class CategoryDescriptionPK implements Serializable{
	
	

	@OneToOne(fetch=FetchType.LAZY, cascade={CascadeType.PERSIST})
	@JoinColumn(name="CATEGORY_ID", insertable=true, updatable=true, nullable=false)
	private Category category;
	
	@Column(name="LOCAL_CODE", length=5, nullable=false)
	private String localCode;

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getLocalCode() {
		return localCode;
	}

	public void setLocalCode(String localCode) {
		this.localCode = localCode;
	}
	
	
}
