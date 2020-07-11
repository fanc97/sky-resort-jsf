package com.home.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.home.dao.SkyPassDAO;
import com.home.entity.SkyPass;
@ManagedBean
@SessionScoped
public class SkyPassController {
	private List<SkyPass> skypass;
	private SkyPassDAO dao;
	private Logger logger = Logger.getLogger(getClass().getName());

	public SkyPassController() throws Exception {
		skypass=new ArrayList<>();
		dao = SkyPassDAO.getInstance();
	}

	public List<SkyPass> getSkypass() {
		return skypass;
	}

	public void loadSkyPass(int mountain_id) {
		
		logger.info("loading skypass where mountain id is : " + mountain_id);
		
		try {
			
			skypass=dao.getSkyPass(mountain_id);
			
			
		} catch (Exception exc) {
		
			logger.log(Level.SEVERE, "Error skypass where mountain id is : " + mountain_id, exc);
			
			addErrorMessage(exc);
		}
	}

	private void addErrorMessage(Exception exc) {
		FacesMessage message = new FacesMessage("Error: " + exc.getMessage());
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
	
}
