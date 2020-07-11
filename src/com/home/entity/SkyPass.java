package com.home.entity;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class SkyPass {
	 	private int id;
		private int mountain_id;
		private int duration;
		private int price;
		
		public SkyPass() {
			super();
		}
		public SkyPass(int id, int mountain_id, int duration, int price) {
			super();
			this.id = id;
			this.mountain_id = mountain_id;
			this.duration = duration;
			this.price = price;
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
		public int getDuration() {
			return duration;
		}
		public void setDuration(int duration) {
			this.duration = duration;
		}
		public int getPrice() {
			return price;
		}
		public void setPrice(int price) {
			this.price = price;
		}
		
}
