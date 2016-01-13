package com.birivarmi.birivarmiapp.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="BV_ADMIN")
@DiscriminatorValue("BV_ADMIN")
public class Admin extends BirivarmiUser{
	
}
