package com.home.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.home.dao.WeatherDAO;
import com.home.entity.Weather;

@ManagedBean
@SessionScoped
public class WeatherController {
	private List<Weather> weather;
	private WeatherDAO dao;
	private Logger logger = Logger.getLogger(getClass().getName());

	public WeatherController() throws Exception {
		weather=new ArrayList<>();
		dao = WeatherDAO.getInstance();
	}
	

	public List<Weather> getWeather() {
		return weather;
	}


	public void loadWeather(int mountain_id) {
		
		logger.info("loading weather where mountain id is : " + mountain_id);
		
		try {
			
			weather=dao.getWeather(mountain_id);
			
			
		} catch (Exception exc) {
		
			logger.log(Level.SEVERE, "Error weather where mountain id is : " + mountain_id, exc);
			
			addErrorMessage(exc);
		}
	}

	private void addErrorMessage(Exception exc) {
		FacesMessage message = new FacesMessage("Error: " + exc.getMessage());
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
	
}
