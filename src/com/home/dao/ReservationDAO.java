package com.home.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.sql.DataSource;

import com.home.entity.UserInfo;

public class ReservationDAO {
	private static ReservationDAO instance;
	private DataSource dataSource;
	private ReservationDAO()throws Exception{
		dataSource=Connectivity.getDataSource();
	}
	public static ReservationDAO getInstance()throws Exception{
		if(instance==null) {
			instance=new ReservationDAO();
		}
		return instance;
	}
	public void saveReservation(int mountain_id, UserInfo user) throws Exception {
		Connection connection=null;
		PreparedStatement statement=null;
		ResultSet result=null;
		SimpleDateFormat ymd=new SimpleDateFormat("yyyy-MM-dd");
		try {
			connection=getConnection();
			String query="INSERT INTO reservation (`mountain_id`, `username`, `fullName`, `from_d`, `to_d`, `price`) VALUES (?,?,?,?,?,?)";
			statement=connection.prepareStatement(query);
			statement.setInt(1, mountain_id);
			statement.setString(2,user.getUsername());
			statement.setString(3,user.getFullName());
			statement.setDate(4,java.sql.Date.valueOf(new String(ymd.format(user.getFrom()))));
			statement.setDate(5,java.sql.Date.valueOf(new String(ymd.format(user.getFrom()))));
			statement.setInt(6,user.getPrice());
			statement.execute();
		}finally {close(connection,statement,result);}
		
	}
	public UserInfo getReservationByUsername(String username)throws Exception{
		UserInfo userdb=null;
		Connection connection=null;
		PreparedStatement statement=null;
		ResultSet result=null;
		try {
			connection=getConnection();
			String query="select * from reservation where username like ?";
			statement=connection.prepareStatement(query);
			statement.setString(1, username);
			
			result = statement.executeQuery();
			if (result.next()) {
				int u_id=result.getInt("id");
				int m_id=result.getInt("mountain_id");
				String u_username=result.getString("username");
				String fullName=result.getString("fullName");
				Date from=result.getDate("from_d");
				Date to=result.getDate("to_d");
				int price= result.getInt("price");;
				userdb=new UserInfo(u_id,u_username,fullName,from,to,price);
			}
			else {
				throw new Exception("Could not find reservation with username: " +username);
			}
			return userdb;
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
