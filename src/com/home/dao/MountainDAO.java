package com.home.dao;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;

import com.home.entity.Mountain;


public class MountainDAO {
	private static MountainDAO instance;
	private DataSource dataSource;
	private MountainDAO()throws Exception{
		dataSource=Connectivity.getDataSource();
	}
	public static MountainDAO getInstance()throws Exception{
		if(instance==null) {
			instance=new MountainDAO();
		}
		return instance;
	}
	public Mountain getMountainById(int id)throws Exception{
		Mountain mountain=null;
		Connection connection=null;
		PreparedStatement statement=null;
		ResultSet result=null;
		try {
			connection=getConnection();
			String query="select * from mountain where id=?";
			statement=connection.prepareStatement(query);
			statement.setInt(1, id);
			
			result = statement.executeQuery();
			if (result.next()) {
				int mid = result.getInt("id");
				String name = result.getString("name");
				String description = result.getString("description");
				String country = result.getString("country");
				String highestPoint = result.getString("highest_point");
				int topElevationM = result.getInt("top_elevation_m");
				int baseElevationM = result.getInt("base_elevation_m");
				Blob blob =result.getBlob("picture");
				int blobLength = (int) blob.length();  
				byte[] blobAsBytes = blob.getBytes(1, blobLength);
				blob.free();

				mountain = new Mountain(mid,name,description,country,highestPoint,topElevationM,baseElevationM,blobAsBytes);
			}
			else {
				throw new Exception("Could not find Mountain id: " + id);
			}
			return mountain;
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
