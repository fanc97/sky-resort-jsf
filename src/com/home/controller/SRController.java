package com.home.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import com.home.dao.MountainDAO;
import com.home.dao.SkyResortDAO;
import com.home.entity.Mountain;
import com.home.entity.SkyResort;
@ManagedBean
@SessionScoped
public class SRController {

	private List<SkyResort> resorts;
	private SkyResortDAO dao;
	private MountainDAO Mdao;
	private Logger logger = Logger.getLogger(getClass().getName());
	
	public SRController() throws Exception {
		resorts = new ArrayList<>();
		
		dao = SkyResortDAO.getInstance();
		Mdao= MountainDAO.getInstance();
	}
	

	public List<SkyResort> getResorts() {
		return resorts;
	}

public String loadMountain(int id) {
		
		logger.info("loading Mountain: " + id);
		
		try {
			
			Mountain mountain = Mdao.getMountainById(id);
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

	public void loadSkyResorts() {

		logger.info("Loading resorts");
		
		resorts.clear();

		try {
			
			resorts = dao.getSkyResorts();
			
		} catch (Exception exc) {
			logger.log(Level.SEVERE, "Error loading resorts", exc);
			
			addErrorMessage(exc);
		}
	}
				
	private void addErrorMessage(Exception exc) {
		FacesMessage message = new FacesMessage("Error: " + exc.getMessage());
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

}
