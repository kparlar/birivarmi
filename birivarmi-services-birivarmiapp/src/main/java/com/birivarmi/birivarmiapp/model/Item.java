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
@Table(name="BV_ITEM")
@DiscriminatorValue("BV_ITEM")
public class Item extends BirivarmiItem{
	
	@ManyToOne(fetch=FetchType.LAZY, cascade={CascadeType.PERSIST})
	@JoinColumn(name="USER_ID", insertable=true, updatable=true, nullable=false)
	private User user;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade={CascadeType.PERSIST})
	@JoinColumn(name="CATEGORY_ID", insertable=true, updatable=true, nullable=false)
	private Category category;
	
	@Column(name="CREATE_DATE", nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;
	
	@Column(name="PUBLISH_DATE", nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date publishDate;
	
	@Column(name="EXPIRATION_DATE", nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date expirationDate;
	
	@Column(name="PRICE", nullable=true)
	private Float price;

	@ManyToOne(fetch=FetchType.LAZY, cascade={CascadeType.PERSIST})
	@JoinColumn(name="CURRENCY_ID", insertable=true, updatable=true, nullable=true)
	private Currency currency;
	
	@Column(name="IP", length=64, nullable=false)
	private String ip;
	
	/**
	 * Values : T, F
	 */
	@Column(name="PREMIUM", nullable=false)
	private Character premium;
	
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
	
	
	@Column(name="SECRET", length=40, nullable=true)
	private String secret;
	
	
	/**
	 * Values : T, F
	 */
	@Column(name="SHOW_EMAIL", nullable=false)
	private Character showEmail;


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}


	public Date getPublishDate() {
		return publishDate;
	}


	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}


	public Date getExpirationDate() {
		return expirationDate;
	}


	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}


	public Float getPrice() {
		return price;
	}


	public void setPrice(Float price) {
		this.price = price;
	}


	public Currency getCurrency() {
		return currency;
	}


	public void setCurrency(Currency currency) {
		this.currency = currency;
	}


	public String getIp() {
		return ip;
	}


	public void setIp(String ip) {
		this.ip = ip;
	}


	public Character getPremium() {
		return premium;
	}


	public void setPremium(Character premium) {
		this.premium = premium;
	}


	public Character getEnabled() {
		return enabled;
	}


	public void setEnabled(Character enabled) {
		this.enabled = enabled;
	}


	public Character getActive() {
		return active;
	}


	public void setActive(Character active) {
		this.active = active;
	}


	public Character getSpam() {
		return spam;
	}


	public void setSpam(Character spam) {
		this.spam = spam;
	}


	public String getSecret() {
		return secret;
	}


	public void setSecret(String secret) {
		this.secret = secret;
	}


	public Character getShowEmail() {
		return showEmail;
	}


	public void setShowEmail(Character showEmail) {
		this.showEmail = showEmail;
	}
	
	
	
}
