package com.wcc.interview.postal.code.distance.db.persistance.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.wcc.interview.postal.code.distance.core.logic.PCCoordinates;
import com.wcc.interview.postal.code.distance.core.logic.UKPostalCode;
import com.wcc.interview.postal.code.distance.db.persistance.ConnectionPool;
import com.wcc.interview.postal.code.distance.db.persistance.DBConnection;

public class UKPCCoordinatesDaoImpl implements UKPCCoordinatesDao{

	private static final String table_name = "uk_pc_table";
	private Connection con;
	
	public UKPCCoordinatesDaoImpl() {
		con = DBConnection.getConnection();
	}
	
	@Override
	public PCCoordinates fetchPCCoordnates(UKPostalCode pc) {
		PCCoordinates xy = null;
		
		Statement stmt = null;
		try{
			String sql = "select lat, lng from " + table_name + " where outcode = '" + pc.getOutCode() + "';";
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				Double lat = rs.getDouble("lat");
				Double lng = rs.getDouble("lng");
				
				xy = new PCCoordinates(pc, lat, lng);
				return xy;
			}
			con.close();
		}catch(SQLException sqle){
			sqle.printStackTrace();
		}
		
		return xy;
	}
/*
	@Override
	public boolean insertRecord(PCCoordinates xy) {
		Statement stmt = null;
		try{
			String sql = "";
			stmt = con.createStatement();
			
			con.close();
		}catch(SQLException sqle){
			sqle.printStackTrace();
		}
		
	}*/
	

}
