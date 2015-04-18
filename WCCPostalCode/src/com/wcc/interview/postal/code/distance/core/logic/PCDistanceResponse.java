package com.wcc.interview.postal.code.distance.core.logic;

public class PCDistanceResponse {
	private PCCoordinates location1;
	private PCCoordinates location2;
	private Double distance;
	private String unit;
	
	public PCCoordinates getLocation2() {
		return location2;
	}
	public void setLocation2(PCCoordinates location2) {
		this.location2 = location2;
	}
	public Double getDistance() {
		return distance;
	}
	public void setDistance(Double distance) {
		this.distance = distance;
	}
	public String getUnit() {
		return unit;
	}
	
	public void setUnit(){
		unit = "km";
	}
	
	public PCCoordinates getLocation1() {
		return location1;
	}
	public void setLocation1(PCCoordinates location1) {
		this.location1 = location1;
	}
	
	
}
