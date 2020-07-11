package com.home.controller;


import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import com.home.dao.MountainDAO;
import com.home.entity.Mountain;


@ManagedBean
@SessionScoped
public class MountainController {
	Mountain mountain;
	private MountainDAO Mdao;
	private Logger logger = Logger.getLogger(getClass().getName());

	public MountainController() throws Exception {
		Mdao = MountainDAO.getInstance();
		mountain= new Mountain();
	}
	public String loadMountain(int id) {
		
		logger.info("loading Mountain: " + id);
		
		try {
			
			mountain = Mdao.getMountainById(id);
			logger.info(mountain.toString());
			
			ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();		

			Map<String, Object> requestMap = externalContext.getRequestMap();
			requestMap.put("mountain", mountain);	
			
		} catch (Exception exc) {
		
			logger.log(Level.SEVERE, "Error loading mountain id:" + id, exc);
			
			
			addErrorMessage(exc);
			
			return "error";
		}
				
		return "mountain";
		
	}
	
	public Mountain getMountain() {
		return mountain;
	}
	private void addErrorMessage(Exception exc) {
		FacesMessage message = new FacesMessage("Error: " + exc.getMessage());
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
	
}
