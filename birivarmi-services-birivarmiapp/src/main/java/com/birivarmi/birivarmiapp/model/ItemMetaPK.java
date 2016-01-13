package com.birivarmi.birivarmiapp.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@SuppressWarnings("serial")
@Embeddable
public class ItemMetaPK implements Serializable{
	
	@ManyToOne(fetch=FetchType.LAZY, cascade={CascadeType.PERSIST})
	@JoinColumn(name="ITEM_ID", insertable=true, updatable=true, nullable=false)
	private Item item;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade={CascadeType.PERSIST})
	@JoinColumn(name="META_FIELD_ID", insertable=true, updatable=true, nullable=false)
	private MetaFields metaFields;

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public MetaFields getMetaFields() {
		return metaFields;
	}

	public void setMetaFields(MetaFields metaFields) {
		this.metaFields = metaFields;
	}
	
	

}
