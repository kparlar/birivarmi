package com.birivarmi.birivarmiapp.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="BV_COUNTRY_STATS")
public class CountryStats extends BirivarmiItemWithoutId{

	@EmbeddedId
    private CountryStatsPK id;
	
	
	@Column(name="NUM_ITEMS", nullable=false)
	private Long numItems;


	public CountryStatsPK getId() {
		return id;
	}


	public void setId(CountryStatsPK id) {
		this.id = id;
	}


	public Long getNumItems() {
		return numItems;
	}


	public void setNumItems(Long numItems) {
		this.numItems = numItems;
	}
	
	
}
