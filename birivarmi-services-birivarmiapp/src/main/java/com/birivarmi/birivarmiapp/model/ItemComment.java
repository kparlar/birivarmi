package com.birivarmi.birivarmiapp.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="BV_ITEM_COMMENT")
@DiscriminatorValue("BV_ITEM_COMMENT")
public class ItemComment extends BirivarmiItem{
	
	@ManyToOne(fetch=FetchType.LAZY, cascade={CascadeType.PERSIST})
	@JoinColumn(name="ITEM_ID", insertable=true, updatable=true, nullable=false)
	private Item item;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade={CascadeType.PERSIST})
	@JoinColumn(name="USER_ID", insertable=true, updatable=true, nullable=false)
	private User user;
	
	@Column(name="CREATE_DATE", nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;
	
	@Column(name="PUBLISH_DATE", nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date publishDate;
	
	@Column(name="TITLE", length=200, nullable=false)
	private String title;

	@Column(name="AUTHOR_NAME", length=100, nullable=false)
	private String authorName;
	
	@Column(name="AUTHOR_SURNAME", length=100, nullable=false)
	private String authorSurname;
	
	@Column(name="AUTHOR_EMAIL", length=100, nullable=false)
	private String authorEmail;
	
	@Column(name="SUMMARY", length=65535, nullable=false)
	private String summary;
	
	/**
	 * Values : T, F
	 */
	@Column(name="ENABLED", nullable=false)
	private Character enabled;
	
	/**
	 * Values : T, F
	 */
	@Column(name="ACTIVE", nullable=false)
	private Character active;
	
	/**
	 * Values : T, F
	 */
	@Column(name="SPAM", nullable=false)
	private Character spam;
}
