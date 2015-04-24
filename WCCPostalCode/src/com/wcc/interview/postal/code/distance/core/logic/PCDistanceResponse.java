package com.wcc.interview.postal.code.distance.core.logic;

/**
 * Response class 
 * which will be used for JSON 
 */
public class PCDistanceResponse {
	private PCCoordinates location1;
	private PCCoordinates location2;
	private Double distance;
	private String unit;
	
	/**
	 * Method getLocation2.
	 * @return PCCoordinates
	 */
	public PCCoordinates getLocation2() {
		return location2;
	}
	/**
	 * Method setLocation2.
	 * @param location2 PCCoordinates
	 */
	public void setLocation2(PCCoordinates location2) {
		this.location2 = location2;
	}
	/**
	 * Method getDistance.
	 * @return Double
	 */
	public Double getDistance() {
		return distance;
	}
	/**
	 * Method setDistance.
	 * @param distance Double
	 */
	public void setDistance(Double distance) {
		this.distance = distance;
	}
	/**
	 * Method getUnit.
	 * @return String
	 */
	public String getUnit() {
		return unit;
	}
	
	public void setUnit(){
		unit = "km";
	}
	
	/**
	 * Method getLocation1.
	 * @return PCCoordinates
	 */
	public PCCoordinates getLocation1() {
		return location1;
	}
	/**
	 * Method setLocation1.
	 * @param location1 PCCoordinates
	 */
	public void setLocation1(PCCoordinates location1) {
		this.location1 = location1;
	}
	
	
}
