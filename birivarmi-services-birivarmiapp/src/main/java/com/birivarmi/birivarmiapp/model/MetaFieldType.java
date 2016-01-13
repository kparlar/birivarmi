package com.birivarmi.birivarmiapp.model;

public enum MetaFieldType {
	TEXT("TEXT"),
	TEXTAREA("TEXTAREA"),
	DROPDOWN("DROPDOWN"),
	RADIO("RADIO"),
	CHECKBOX("CHECKBOX"),
	URL("URL"),
	DATE("DATE"),
	DATEINTERVAL("DATEINTERVAL");
	
	private final String type;
	
	private MetaFieldType(String type){
		this.type = type;
	}
	
	public String getType(){
		return this.type;
	}
}
