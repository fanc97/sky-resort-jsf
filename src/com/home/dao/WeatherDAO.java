package com.home.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.home.entity.Weather;

public class WeatherDAO {
	private static WeatherDAO instance;
	private DataSource dataSource;
	private WeatherDAO()throws Exception{
		dataSource=Connectivity.getDataSource();
	}
	public static WeatherDAO getInstance()throws Exception{
		if(instance==null) {
			instance=new WeatherDAO();
		}
		return instance;
	}
	public List<Weather>getWeather(int mountain_id)throws Exception{
		List<Weather> w = new ArrayList<>();
		Connection connection=null;
		PreparedStatement statement=null;
		ResultSet result=null;
		try {
			connection=getConnection();
			String query="select * from weather where mountain_id=?";
			statement=connection.prepareStatement(query);
			statement.setInt(1, mountain_id);
			result = statement.executeQuery();
			while(result.next()) {
				int id=result.getInt("id");
				int t_mountain_id=result.getInt("mountain_id");
				String[] res=result.getString("date").split("T");
				String t_max=result.getString("temperature_max");
				String t_min=result.getString("temperature_min");
				String wind=result.getString("wind");
				String ol=new String("asset/images/weather/"+result.getString("outlook")+".png");
				w.add(new Weather(id,t_mountain_id,res[0],t_min,t_max,wind,ol));
			}
			return w;
		}finally {close(connection,statement,result);}
	}
	private Connection getConnection() throws Exception {

		Connection theConn = dataSource.getConnection();
		
		return theConn;
	}
	
	
	private void close(Connection theConn, Statement theStmt, ResultSet theRs) {

		try {
			if (theRs != null) {
				theRs.close();
			}

			if (theStmt != null) {
				theStmt.close();
			}

			if (theConn != null) {
				theConn.close();
			}
			
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}
}
