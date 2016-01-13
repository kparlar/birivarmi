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
@Table(name="BV_CITY_AREA")
@DiscriminatorValue("BV_CITY_AREA")
public class CityArea extends BirivarmiItem{
	
	@ManyToOne(fetch=FetchType.LAZY, cascade={CascadeType.PERSIST})
	@JoinColumn(name="CITY_ID", insertable=true, updatable=true, nullable=false)
	private City city;
	
	
	@Column(name="NAME", length=255, nullable=false)
	private String name;


	public City getCity() {
		return city;
	}


	public void setCity(City city) {
		this.city = city;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	
}
