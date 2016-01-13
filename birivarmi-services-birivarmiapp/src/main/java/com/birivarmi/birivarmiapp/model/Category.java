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
@Table(name="BV_CATEGORY")
@DiscriminatorValue("BV_CATEGORY")
public class Category extends BirivarmiItem{

	@ManyToOne(fetch=FetchType.LAZY, cascade={CascadeType.PERSIST})
	@JoinColumn(name="PARENT_ID", insertable=true, updatable=true, nullable=true)
	private Category parentId;
	@Column(name="EXPIRATION_DAYS", nullable=false)
	private Integer expirationDays;
	@Column(name="POSITION", nullable=false)
	private Integer position;
	@Column(name="ENABLED", length=1, nullable=false)
	private Character enabled;
	@Column(name="PRICE_ENABLED", length=1, nullable=false)
	private Character priceEnabled;
	@Column(name="ICON_PATH", length=250, nullable=true)
	private String iconPath;
	public Category getParentId() {
		return parentId;
	}
	public void setParentId(Category parentId) {
		this.parentId = parentId;
	}
	public Integer getExpirationDays() {
		return expirationDays;
	}
	public void setExpirationDays(Integer expirationDays) {
		this.expirationDays = expirationDays;
	}
	public Integer getPosition() {
		return position;
	}
	public void setPosition(Integer position) {
		this.position = position;
	}
	public Character getEnabled() {
		return enabled;
	}
	public void setEnabled(Character enabled) {
		this.enabled = enabled;
	}
	public Character getPriceEnabled() {
		return priceEnabled;
	}
	public void setPriceEnabled(Character priceEnabled) {
		this.priceEnabled = priceEnabled;
	}
	public String getIconPath() {
		return iconPath;
	}
	public void setIconPath(String iconPath) {
		this.iconPath = iconPath;
	}
	
	
}
