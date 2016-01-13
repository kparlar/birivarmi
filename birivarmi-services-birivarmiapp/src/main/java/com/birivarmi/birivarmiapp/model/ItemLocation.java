package com.birivarmi.birivarmiapp.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="BV_ITEM_LOCATION")
public class ItemLocation extends BirivarmiItemWithoutId{

	@EmbeddedId
    private ItemLocationPK id;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade={CascadeType.PERSIST})
	@JoinColumn(name="COUNTRY_ID", insertable=true, updatable=true, nullable=false)
	private Country country;
	
	@Column(name="ADDRESS", length=100, nullable=false)
	private String address;
	
	@Column(name="ZIP", length=15, nullable=false)
	private String zip;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade={CascadeType.PERSIST})
	@JoinColumn(name="REGION_ID", insertable=true, updatable=true, nullable=true)
	private Region region;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade={CascadeType.PERSIST})
	@JoinColumn(name="CITY_ID", insertable=true, updatable=true, nullable=false)
	private City city;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade={CascadeType.PERSIST})
	@JoinColumn(name="CITY_AREA_ID", insertable=true, updatable=true, nullable=false)
	private CityArea cityArea;
	
	@Column(name="COORD_LAT", precision=10, scale=6, nullable=true)
	private Float coordLat;
	
	@Column(name="COORD_LONG", precision=10, scale=6, nullable=true)
	private Float coordLong;

	public ItemLocationPK getId() {
		return id;
	}

	public void setId(ItemLocationPK id) {
		this.id = id;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public CityArea getCityArea() {
		return cityArea;
	}

	public void setCityArea(CityArea cityArea) {
		this.cityArea = cityArea;
	}

	public Float getCoordLat() {
		return coordLat;
	}

	public void setCoordLat(Float coordLat) {
		this.coordLat = coordLat;
	}

	public Float getCoordLong() {
		return coordLong;
	}

	public void setCoordLong(Float coordLong) {
		this.coordLong = coordLong;
	}
	
	
	
}
