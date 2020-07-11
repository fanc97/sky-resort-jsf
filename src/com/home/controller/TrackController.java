package com.home.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import com.home.dao.TrackDAO;
import com.home.entity.Track;

@ManagedBean
@SessionScoped
public class TrackController {
	private int localId;
	private String localSearch="name";
	private String sort;
	private List<Track> tracks;
	private TrackDAO dao;
	private Logger logger = Logger.getLogger(getClass().getName());

	public TrackController() throws Exception {
		tracks=new ArrayList<>();
		dao = TrackDAO.getInstance();
	}
	
	public List<Track> getTracks() {
		return tracks;
	}

	public void loadTracks(int mountain_id) {
		if(localSearch.equalsIgnoreCase("nn")) {
			mountain_id=localId;
			localSearch="name";
		}
		else if(localSearch.equalsIgnoreCase("rating")) {
			mountain_id=localId;
		}else if(localSearch.equalsIgnoreCase("lenght_km")) {
			mountain_id=localId;
		}
		logger.info("loading tracks where mountain id is : " + mountain_id);
		
		try {
			
			tracks=dao.getTracksOrderBy(mountain_id, localSearch);
			
			
		} catch (Exception exc) {
		
			logger.log(Level.SEVERE, "Error tracks where mountain id is : " + mountain_id, exc);
			
			addErrorMessage(exc);
		}
	}
	public void sortTable(ValueChangeEvent event) {
		localSearch=event.getNewValue().toString();
		localId=tracks.get(1).getMountain_id();
			logger.info("Variable localID : " + tracks.get(1).getMountain_id() +" lovakSearch "+event.getNewValue().toString());

	}
	private void addErrorMessage(Exception exc) {
		FacesMessage message = new FacesMessage("Error: " + exc.getMessage());
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	
}
