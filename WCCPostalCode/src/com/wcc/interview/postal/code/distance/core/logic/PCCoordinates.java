package com.wcc.interview.postal.code.distance.core.logic;

import com.wcc.interview.postal.code.distance.db.persistance.dao.UKPCCoordinatesDaoImpl;

public class PCCoordinates {
	private Double latit;
	private Double longt;
	private UKPostalCode pc;
	
	public PCCoordinates(UKPostalCode pc){
		this.pc = pc;
		this.latit = null;
		this.longt = null;
	}
	
	public PCCoordinates(UKPostalCode pc, Double latit, Double longt){
		this.latit = latit;
		this.longt = longt;
		this.pc = pc;
	}
	
	private void populateLatLong(){
		PCCoordinates xy = new UKPCCoordinatesDaoImpl().fetchPCCoordnates(pc);
		if(xy != null){
			this.latit = xy.latit;
			this.longt = xy.longt;
		}
	}
	
	public Double getLatitude(){
		if(this.latit == null){
			populateLatLong();
		}
		return this.latit;
	}
	
	public Double getLongitude(){
		if(this.longt == null){
			populateLatLong();
		}
		return this.longt;
	}
	
	public UKPostalCode getUKPostalCode(){
		return this.pc;
	}
	
}
