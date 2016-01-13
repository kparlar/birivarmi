package com.birivarmi.birivarmiapp.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="BV_CURRENCY")
@DiscriminatorValue("BV_CURRENCY")
public class Currency extends BirivarmiItem{

	@Column(name="CODE", length=3, nullable=false)
	private String code;
	
	@Column(name="NAME", length=40, nullable=false)
	private String name;
	
	@Column(name="DESCRIPTION", length=80, nullable=true)
	private String description;
	
	@Column(name="ENABLED", nullable=false)
	private Character enabled;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Character getEnabled() {
		return enabled;
	}

	public void setEnabled(Character enabled) {
		this.enabled = enabled;
	}
}
