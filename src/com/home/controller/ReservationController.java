package com.home.controller;

import java.util.Date;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import com.home.dao.ReservationDAO;
import com.home.dao.SkyPassDAO;
import com.home.entity.UserInfo;

@ManagedBean
@SessionScoped
public class ReservationController {
	private String error;
	private ReservationDAO dao;
	private SkyPassDAO SkyDAO;
	private Logger logger = Logger.getLogger(getClass().getName());

	public ReservationController() throws Exception {
		dao = ReservationDAO.getInstance();
		SkyDAO=SkyPassDAO.getInstance();
	}
	public String loadReservation(int mountain_id,UserInfo user) {
		
		logger.info("Saving reservation of user: "+user.getUsername());
		
		if(calculateDiference(user.getFrom(),user.getTo())>7&&calculateDiference(user.getFrom(),user.getTo())<7) {
			error="Reservation must be from 1-7";
			return"error";
		}
		try {
			int price=SkyDAO.getPriceByDurationAndMountainID(mountain_id,calculateDiference(user.getFrom(),user.getTo()));
			user.setPrice(price);
			dao.saveReservation(mountain_id,user);
			UserInfo reservation=dao.getReservationByUsername(user.getUsername());
			ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();		

			Map<String, Object> requestMap = externalContext.getRequestMap();
			requestMap.put("reservation", reservation);	
			
		} catch (Exception exc) {
		
			logger.log(Level.SEVERE, "Error loading mountain id:" + mountain_id, exc);
			
			
			addErrorMessage(exc);
			
			return "error";
		}
				
		return "reservation";
		
	}
	
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	private int calculateDiference(java.util.Date date,java.util.Date date2) {
		return Math.round(((date2.getTime()-date.getTime())/(24*60*60*1000)));
	}

	private void addErrorMessage(Exception exc) {
		FacesMessage message = new FacesMessage("Error: " + exc.getMessage());
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
}
