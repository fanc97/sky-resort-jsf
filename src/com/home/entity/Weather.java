package com.home.entity;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Weather {
	private int id;
	private int mountain_id;
	private String date;
	private String temp_min;
	private String temp_max;
	private String wind;
	private String outlook;
	public Weather() {
		super();
	}
	public Weather(int id, int mountain_id, String data, String temp_min, String temp_max, String wind,
			String outlook) {
		super();
		this.id = id;
		this.mountain_id = mountain_id;
		this.date = data;
		this.temp_min = temp_min;
		this.temp_max = temp_max;
		this.wind = wind;
		this.outlook = outlook;
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
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTemp_min() {
		return temp_min;
	}
	public void setTemp_min(String temp_min) {
		this.temp_min = temp_min;
	}
	public String getTemp_max() {
		return temp_max;
	}
	public void setTemp_max(String temp_max) {
		this.temp_max = temp_max;
	}
	public String getWind() {
		return wind;
	}
	public void setWind(String wind) {
		this.wind = wind;
	}
	public String getOutlook() {
		return outlook;
	}
	public void setOutlook(String outlook) {
		this.outlook = outlook;
	}
	
}
