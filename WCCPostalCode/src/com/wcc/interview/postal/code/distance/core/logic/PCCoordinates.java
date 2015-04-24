package com.wcc.interview.postal.code.distance.core.logic;

import com.wcc.interview.postal.code.distance.db.persistance.dao.UKPCCoordinatesDaoImpl;

/**
 * Class for representing Postal Code Coordinates
 */
public class PCCoordinates {
	private Double latit;
	private Double longt;
	private UKPostalCode pc;
	
	/**
	 * Constructor for PCCoordinates.
	 * @param pc UKPostalCode
	 */
	public PCCoordinates(UKPostalCode pc){
		this.pc = pc;
		this.latit = null;
		this.longt = null;
	}
	
	/**
	 * Constructor for PCCoordinates.
	 * @param pc UKPostalCode
	 * @param latit Double
	 * @param longt Double
	 */
	public PCCoordinates(UKPostalCode pc, Double latit, Double longt){
		this.latit = latit;
		this.longt = longt;
		this.pc = pc;
	}
	
	/**
	 * This method will connect to DB for fetching the lat and lng 
	 * coordinates
	 */
	private void populateLatLong(){
		PCCoordinates xy = new UKPCCoordinatesDaoImpl().fetchPCCoordnates(pc);
		if(xy != null){
			this.latit = xy.latit;
			this.longt = xy.longt;
		}
	}
	
	/**
	 * Method getLatitude.
	 * @return Double
	 */
	public Double getLatitude(){
		if(this.latit == null){
			populateLatLong();
		}
		return this.latit;
	}
	
	/**
	 * Method getLongitude.
	 * @return Double
	 */
	public Double getLongitude(){
		if(this.longt == null){
			populateLatLong();
		}
		return this.longt;
	}
	
	/**
	 * Method getUKPostalCode.
	 * @return UKPostalCode
	 */
	public UKPostalCode getUKPostalCode(){
		return this.pc;
	}
	
}
