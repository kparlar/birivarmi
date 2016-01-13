package com.birivarmi.birivarmiapp.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="BV_REGION_STATS")
public class RegionStats extends BirivarmiItemWithoutId	{
	@EmbeddedId
    private RegionStatsPK id;
	
	@Column(name="NUM_ITEMS", nullable=false)
	private Long numItems;

	public RegionStatsPK getId() {
		return id;
	}

	public void setId(RegionStatsPK id) {
		this.id = id;
	}

	public Long getNumItems() {
		return numItems;
	}

	public void setNumItems(Long numItems) {
		this.numItems = numItems;
	}
	
	

}
