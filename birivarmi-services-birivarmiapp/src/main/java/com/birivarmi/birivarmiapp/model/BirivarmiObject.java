package com.birivarmi.birivarmiapp.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="BV_OBJECT")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "TYPE")
public class BirivarmiObject {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@Transient
	public String getType(){
		DiscriminatorValue discriminatorValue = this.getClass().getAnnotation(DiscriminatorValue.class);
		return discriminatorValue == null ? null : discriminatorValue.value();
	}
	
	@JsonIgnore
	@OneToMany(fetch=FetchType.LAZY, mappedBy="updaterId")
	private List<Admin> admins;
	
	@JsonIgnore
	@OneToMany(fetch=FetchType.LAZY, mappedBy="updaterId")
	private List<User> users;

	public List<Admin> getAdmins() {
		return admins;
	}

	public void setAdmins(List<Admin> admins) {
		this.admins = admins;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	
	
}
