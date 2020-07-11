package com.home.entity;


import javax.faces.bean.ManagedBean;

@ManagedBean
public class Mountain {
	private int id;
	private String name;
	private String description;
	private String country;
	private String highestPoint;
	private int topElevationM;
	private int baseElevationM;
	private String picture;
	public Mountain() {
		super();
	}
	
	public Mountain(int id, String name, String description, String country, String highestPoint, int topElevationM,
			int baseElevationM, byte[] picture) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.country = country;
		this.highestPoint = highestPoint;
		this.topElevationM = topElevationM;
		this.baseElevationM = baseElevationM;
		this.picture = new String(picture);
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getHighestPoint() {
		return highestPoint;
	}
	public void setHighestPoint(String highestPoint) {
		this.highestPoint = highestPoint;
	}
	public int getTopElevationM() {
		return topElevationM;
	}
	public void setTopElevationM(int topElevationM) {
		this.topElevationM = topElevationM;
	}
	public int getBaseElevationM() {
		return baseElevationM;
	}
	public void setBaseElevationM(int baseElevationM) {
		this.baseElevationM = baseElevationM;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}

	@Override
	public String toString() {
		return "Mountain [id=" + id + ", name=" + name + ", description=" + description + ", country=" + country
				+ ", highestPoint=" + highestPoint + ", topElevationM=" + topElevationM + ", baseElevationM="
				+ baseElevationM + ", picture=" + picture + "]";
	}
	
}
