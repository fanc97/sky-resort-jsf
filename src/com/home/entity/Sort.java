package com.home.entity;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Sort {
	private String sortby;
	public Sort() {
		
	}
	public String getSortby() {
		return sortby;
	}
	public void setSortby(String sortby) {
		this.sortby = sortby;
	}
	
}
