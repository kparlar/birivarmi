package com.birivarmi.birivarmiapp.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.birivarmi.birivarmiapp.model.json.JsonUpdaterBirivarmiObjectSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;


@MappedSuperclass
public abstract class BirivarmiItem extends BirivarmiObject{
	
	@ManyToOne(fetch=FetchType.LAZY, cascade={CascadeType.PERSIST})
	@JoinColumn(name="UPDATER_ID", insertable=true, updatable=true, nullable=true)
	private BirivarmiObject updaterId;
	@Column(name="UPDATE_DATE", nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date updateDate;
	@Column(name="UPDATE_STATUS", nullable=false)
	private Character updateStatus;
	
	@JsonSerialize(using=JsonUpdaterBirivarmiObjectSerializer.class)
	public BirivarmiObject getUpdaterId() {
		return updaterId;
	}
	public void setUpdaterId(BirivarmiObject updaterId) {
		this.updaterId = updaterId;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public Character getUpdateStatus() {
		return updateStatus;
	}
	public void setUpdateStatus(Character updateStatus) {
		this.updateStatus = updateStatus;
	}
	
	
	
	
}
