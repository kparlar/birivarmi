package com.birivarmi.birivarmiapp.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="BV_USER")
@DiscriminatorValue("BV_USER")
public class User extends BirivarmiUser{
	
}
