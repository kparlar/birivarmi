package com.birivarmi.birivarmiapp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public class BirivarmiUser extends BirivarmiItem{
	@Column(name="NAME", length=100, nullable=false)
	private String name;
	@Column(name="SURNAME", length=100, nullable=false)
	private String surname;
	@Column(name="PASSWORD", length=255, nullable=false)
	private String password;
	@Column(name="EMAIL", length=100, nullable=false, unique=true)
	private String email;
	@Column(name="USERNAME", nullable=false)
	private String username;
	@Column(name="REGISTRATION_DATE", nullable=false)
	private Date reqistrationDate;
	@Column(name="LAST_LOGIN", nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastLogin;
	@Column(name="LOGIN_TRY", nullable=false)
	private Integer loginTry;
	
	@Column(name="AUTHENTICATE_KEY", length=20, nullable=true)
	private String authenticateKey;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Date getReqistrationDate() {
		return reqistrationDate;
	}
	public void setReqistrationDate(Date reqistrationDate) {
		this.reqistrationDate = reqistrationDate;
	}
	public Date getLastLogin() {
		return lastLogin;
	}
	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}
	public Integer getLoginTry() {
		return loginTry;
	}
	public void setLoginTry(Integer loginTry) {
		this.loginTry = loginTry;
	}
	public String getAuthenticateKey() {
		return authenticateKey;
	}
	public void setAuthenticateKey(String authenticateKey) {
		this.authenticateKey = authenticateKey;
	}
	
	
}
