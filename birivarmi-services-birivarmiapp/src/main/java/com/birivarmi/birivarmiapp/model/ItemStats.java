package com.birivarmi.birivarmiapp.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="BV_ITEM_STATS")
public class ItemStats extends BirivarmiItemWithoutId{

	@EmbeddedId
    private ItemStatsPK id;
	
	@Column(name="NUM_VIEWS", nullable=false)
	private Long numViews;
	
	@Column(name="NUM_SPAM", nullable=false)
	private Long numSpam;
	
	@Column(name="NUM_REPEATED", nullable=false)
	private Long numRepeated;
	
	@Column(name="NUM_BAD_CLASSIFIED", nullable=false)
	private Long numBadClassified;
	
	@Column(name="NUM_OFFENSIVE", nullable=false)
	private Long numOffensive;
	
	@Column(name="NUM_EXPIRED", nullable=false)
	private Long numExpired;
	
	@Column(name="NUM_PREMIUM_VIEWS", nullable=false)
	private Long numPremiumViews;

	public Long getNumViews() {
		return numViews;
	}

	public void setNumViews(Long numViews) {
		this.numViews = numViews;
	}

	public Long getNumSpam() {
		return numSpam;
	}

	public void setNumSpam(Long numSpam) {
		this.numSpam = numSpam;
	}

	public Long getNumRepeated() {
		return numRepeated;
	}

	public void setNumRepeated(Long numRepeated) {
		this.numRepeated = numRepeated;
	}

	public Long getNumBadClassified() {
		return numBadClassified;
	}

	public void setNumBadClassified(Long numBadClassified) {
		this.numBadClassified = numBadClassified;
	}

	public Long getNumOffensive() {
		return numOffensive;
	}

	public void setNumOffensive(Long numOffensive) {
		this.numOffensive = numOffensive;
	}

	public Long getNumExpired() {
		return numExpired;
	}

	public void setNumExpired(Long numExpired) {
		this.numExpired = numExpired;
	}

	public Long getNumPremiumViews() {
		return numPremiumViews;
	}

	public void setNumPremiumViews(Long numPremiumViews) {
		this.numPremiumViews = numPremiumViews;
	}
	
}
