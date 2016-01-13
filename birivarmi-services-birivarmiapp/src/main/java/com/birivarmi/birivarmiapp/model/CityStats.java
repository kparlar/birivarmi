package com.birivarmi.birivarmiapp.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="BV_CITY_STATS")
public class CityStats extends BirivarmiItemWithoutId{
	
	@EmbeddedId
    private CityStatsPK id;
	
	@Column(name="NUM_ITEMS", nullable=false)
	private Long numItems;

	public CityStatsPK getId() {
		return id;
	}

	public void setId(CityStatsPK id) {
		this.id = id;
	}

	public Long getNumItems() {
		return numItems;
	}

	public void setNumItems(Long numItems) {
		this.numItems = numItems;
	}
	
	
}
