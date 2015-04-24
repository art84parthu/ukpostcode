package com.wcc.interview.postal.code.distance.db.persistance.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.wcc.interview.postal.code.distance.core.logic.PCCoordinates;
import com.wcc.interview.postal.code.distance.core.logic.UKPostalCode;
import com.wcc.interview.postal.code.distance.db.persistance.DBConnection;
import com.wcc.interview.postal.code.distance.service.config.DBConfig;

/**
 * Actual implementation of the DAO interface
 * 
 * For now only fetch operation is implemented. 
 */
public class UKPCCoordinatesDaoImpl implements UKPCCoordinatesDao{

	private Connection con;
	
	public UKPCCoordinatesDaoImpl() {
		con = DBConnection.getConnection();
	}
	
	/**
	 * Method fetchPCCoordnates.
	 * 
	 * Executed a simple fetch query in SQLite DB table for getting lat and lng info.  
	 * 
	 * @param pc UKPostalCode
	 * @return PCCoordinates
	 * @see com.wcc.interview.postal.code.distance.db.persistance.dao.UKPCCoordinatesDao#fetchPCCoordnates(UKPostalCode)
	 */
	@Override
	public PCCoordinates fetchPCCoordnates(UKPostalCode pc) {
		PCCoordinates xy = null;
		
		Statement stmt = null;
		try{
			String sql = "select lat, lng from " + DBConfig.getDBProperty(DBConfig.DBPropertyKeys.SQLite_TABLE_NAME) + " where outcode = '" + pc.getOutCode() + "';";
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
}
