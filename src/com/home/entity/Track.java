package com.home.entity;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Track {
	private int id;
	private int mountain_id;
	private String name;
	private float lenghtKM;
	private float rating;
	public Track() {
	}
	public Track(int id, int mountain_id, String name, float lenghtKM, float rating) {
		super();
		this.id = id;
		this.mountain_id = mountain_id;
		this.name = name;
		this.lenghtKM = lenghtKM;
		this.rating = rating;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMountain_id() {
		return mountain_id;
	}
	public void setMountain_id(int mountain_id) {
		this.mountain_id = mountain_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getLenghtKM() {
		return lenghtKM;
	}
	public void setLenghtKM(float lenghtKM) {
		this.lenghtKM = lenghtKM;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	
}
