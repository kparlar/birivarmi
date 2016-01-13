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
@Table(name="BV_REGION")
@DiscriminatorValue("BV_REGION")
public class Region extends BirivarmiItem{
	
	@ManyToOne(fetch=FetchType.LAZY, cascade={CascadeType.PERSIST})
	@JoinColumn(name="COUNTRY_ID", insertable=true, updatable=true, nullable=false)
	private Country country;
	
	@Column(name="NAME", length=60, nullable=false)
	private String name;
	
	@Column(name="SLUG", length=60, nullable=false)
	private String slug;
	
	/**
	 * Values : T, F
	 */
	@Column(name="ACTIVE", nullable=false)
	private Character active;

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
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

	public Character getActive() {
		return active;
	}

	public void setActive(Character active) {
		this.active = active;
	}
	
	
}
