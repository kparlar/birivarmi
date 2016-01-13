package com.birivarmi.birivarmiapp.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name="BV_META_FIELDS")
@DiscriminatorValue("BV_META_FIELDS")
public class MetaFields extends BirivarmiItem{
	

	@Column(name="NAME", length=255, nullable=false)
	private String name;
	
	@Column(name="SLUG", length=255, nullable=false)
	private String slug;
	
	// the **Enum** to map (to be persisted or updated) : 
	@Column(name="TYPE")
	@Enumerated(EnumType.ORDINAL)
	private MetaFieldType metaFieldType;
	
	@Column(name="OPTIONS", length=2048, nullable=true)
	private String options;
	
	/**
	 * Values : T, F
	 */
	@Column(name="REQUIRED", nullable=false)
	private Character required;
	
	/**
	 * Values : T, F
	 */
	@Column(name="SEARCHABLE", nullable=false)
	private Character searchable;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public MetaFieldType getMetaFieldType() {
		return metaFieldType;
	}

	public void setMetaFieldType(MetaFieldType metaFieldType) {
		this.metaFieldType = metaFieldType;
	}

	public String getOptions() {
		return options;
	}

	public void setOptions(String options) {
		this.options = options;
	}

	public Character getRequired() {
		return required;
	}

	public void setRequired(Character required) {
		this.required = required;
	}

	public Character getSearchable() {
		return searchable;
	}

	public void setSearchable(Character searchable) {
		this.searchable = searchable;
	}
	
	

}
