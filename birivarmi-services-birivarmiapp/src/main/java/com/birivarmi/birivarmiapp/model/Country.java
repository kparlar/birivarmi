package com.birivarmi.birivarmiapp.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="BV_COUNTRY")
@DiscriminatorValue("BV_COUNTRY")
public class Country extends BirivarmiItem{
	
	@Column(name="CODE", length=3, nullable=false)
	private String code;
	
	@Column(name="NAME", length=80, nullable=false)
	private String name;
	
	@Column(name="SLUG", length=80, nullable=false)
	private String slug;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	
}
