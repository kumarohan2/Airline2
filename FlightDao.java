package com.lti.flight;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class FlightDao {
	
	public List<Flight> searchFlight(String from, String to) {
		PreparedStatement pstmt = null;
		Connection conn = null;

		// Step 1. Loading the JDBC Driver
		try {

			ResultSet rs = null;
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// Step 2. Now we can try connecting to the database
			String url = "jdbc:oracle:thin:@infva06863:1521:xe";
			String user = "hr";
			String pass = "hr";

			// Get connection from database
			conn = DriverManager.getConnection(url, user, pass);

			// Query the  database
			String sql = "select * from journey where from_city = ? and to_city = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, from);
			pstmt.setString(2, to);
			 rs = pstmt.executeQuery();
			List<Flight> flights = new ArrayList<Flight>();
			
			//fetch product rows
			while(rs.next()) {
				Flight flight = new Flight();
				flight.setFno(rs.getInt("fno"));
				flight.setFname(rs.getString("fname"));
				flight.setToCity(rs.getString("to_city"));
				flight.setFromCity(rs.getString("from_city"));
				flights.add(flight);
				
			}
			return flights;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {pstmt.close();} catch (Exception e) {}
			try {conn.close();} catch (Exception e) {}
		}
		return null;
	}
}


