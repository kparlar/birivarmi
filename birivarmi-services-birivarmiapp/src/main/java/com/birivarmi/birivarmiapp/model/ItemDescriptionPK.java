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
public class ItemDescriptionPK implements Serializable{

	@OneToOne(fetch=FetchType.LAZY, cascade={CascadeType.PERSIST})
	@JoinColumn(name="ITEM_ID", insertable=true, updatable=true, nullable=false)
	private Item item;
	
	@Column(name="LOCAL_CODE", length=5, nullable=false)
	private String localCode;

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public String getLocalCode() {
		return localCode;
	}

	public void setLocalCode(String localCode) {
		this.localCode = localCode;
	}
	
	
}
