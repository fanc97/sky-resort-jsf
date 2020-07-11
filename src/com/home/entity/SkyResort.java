package com.home.entity;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class SkyResort {
	private int id;
	private String name;
	public SkyResort() {}
	public SkyResort(int id, String name) {
		super();
		this.id = id;
		this.name = name;
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
	@Override
	public String toString() {
		return "SkyResort [id=" + id + ", name=" + name + "]";
	}
	
}
