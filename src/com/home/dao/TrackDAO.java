package com.home.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.home.entity.Track;

public class TrackDAO {
	private static TrackDAO instance;
	private DataSource dataSource;
	private TrackDAO()throws Exception{
		dataSource=Connectivity.getDataSource();
	}
	public static TrackDAO getInstance()throws Exception{
		if(instance==null) {
			instance=new TrackDAO();
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
	public List<Track> getTracksOrderBy(int mountain_id, String orderby) throws Exception{
		List<Track> tracks = new ArrayList<>();
		Connection connection=null;
		PreparedStatement statement=null;
		ResultSet result=null;
		
		try {
			connection=getConnection();
			String query="select * from track where mountain_id=? order by "+orderby;
			statement=connection.prepareStatement(query);
			statement.setInt(1, mountain_id);
			result = statement.executeQuery();
			while(result.next()) {
				int id=result.getInt("id");
				int t_mountain_id=result.getInt("mountain_id");
				String name=result.getString("name");
				float lenghtKM=result.getFloat("lenght_km");
				float rating=result.getFloat("rating");
				tracks.add(new Track(id,t_mountain_id,name,lenghtKM,rating));
			}
			return tracks;
		}finally {close(connection,statement,result);}
	}
}
