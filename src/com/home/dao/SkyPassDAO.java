package com.home.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.home.entity.SkyPass;

public class SkyPassDAO {
	private static SkyPassDAO instance;
	private DataSource dataSource;
	private SkyPassDAO()throws Exception{
		dataSource=Connectivity.getDataSource();
	}
	public static SkyPassDAO getInstance()throws Exception{
		if(instance==null) {
			instance=new SkyPassDAO();
		}
		return instance;
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
	public List<SkyPass> getSkyPass(int mountain_id) throws Exception{
		List<SkyPass> skypass = new ArrayList<>();
		Connection connection=null;
		PreparedStatement statement=null;
		ResultSet result=null;
		
		try {
			connection=getConnection();
			String query="select * from skypass where mountain_id=? ";
			statement=connection.prepareStatement(query);
			statement.setInt(1, mountain_id);
			result = statement.executeQuery();
			while(result.next()) {
				int id=result.getInt("id");
				int t_mountain_id=result.getInt("mountain_id");
				int duration=result.getInt("duration");;
				int price=result.getInt("price");
				skypass.add(new SkyPass(id,t_mountain_id,duration,price));
			}
			return skypass;
		}finally {close(connection,statement,result);}
	}
	public int getPriceByDurationAndMountainID(int mountain_id, int calculateDiference) throws Exception {
		int retVal=0;
		Connection connection=null;
		PreparedStatement statement=null;
		ResultSet result=null;
		
		try {
			connection=getConnection();
			String query="SELECT price FROM skypass where mountain_id=? and duration=?";
			statement=connection.prepareStatement(query);
			statement.setInt(1, mountain_id);
			statement.setInt(2, calculateDiference);
			result = statement.executeQuery();
			while(result.next()) {
				retVal=result.getInt("price");
			}
			return retVal;
		}finally {close(connection,statement,result);}
	}
}
