package com.home.entity;

import java.util.Date;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class UserInfo {
	private int id;
	private String username;
	private String fullName;
	private Date from;
	private Date to;
	private int price;
	public UserInfo() {}
	
	

	public UserInfo(int id, String username, String fullName, Date from, Date to, int price) {
		super();
		this.id = id;
		this.username = username;
		this.fullName = fullName;
		this.from = from;
		this.to = to;
		this.price = price;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public Date getFrom() {
		return from;
	}
	public void setFrom(Date from) {
		this.from = from;
	}
	public Date getTo() {
		return to;
	}
	public void setTo(Date to) {
		this.to = to;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}
