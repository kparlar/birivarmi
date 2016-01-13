package com.birivarmi.birivarmiapp.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="BV_ITEM_META")
@DiscriminatorValue("BV_ITEM_META")
public class ItemMeta extends BirivarmiItemWithoutId{

	@EmbeddedId
    private ItemMetaPK id;
	
	@Column(name="VALUE", length=65535, nullable=false)
	private String value;
	
	@Column(name="MULTI", length=20, nullable=false)
	private String multi;

	public ItemMetaPK getId() {
		return id;
	}

	public void setId(ItemMetaPK id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getMulti() {
		return multi;
	}

	public void setMulti(String multi) {
		this.multi = multi;
	}
	
	
}
