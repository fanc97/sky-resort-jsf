package com.home.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.home.entity.SkyResort;

public class SkyResortDAO {
	private static SkyResortDAO instance;
	private DataSource dataSource;
	private SkyResortDAO()throws Exception{
		dataSource=Connectivity.getDataSource();
	}
	public static SkyResortDAO getInstance()throws Exception{
		if(instance==null) {
			instance=new SkyResortDAO();
		}
		return instance;
	}
	public List<SkyResort>getSkyResorts()throws Exception{
		List<SkyResort> resorts = new ArrayList<>();
		Connection connection=null;
		Statement statement=null;
		ResultSet result=null;
		try {
			connection=getConnection();
			String query="select * from sky_resort";
			statement=connection.createStatement();
			result=statement.executeQuery(query);
			while(result.next()) {
				int id=result.getInt("id");
				String name=result.getString("name");
				resorts.add(new SkyResort(id,name));
			}
			return resorts;
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
