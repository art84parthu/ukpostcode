package com.wcc.interview.postal.code.distance.core.logic;

/**
 * Object representation of postal code
 * Just a provision for representing incode and outcode (in case requied).
 */
public class UKPostalCode {
	private String outCode;
	private String ukPostalCode;
	
	/**
	 * Constructor for UKPostalCode.
	 * @param ukPostalCode String
	 */
	public UKPostalCode(String ukPostalCode){
		this.ukPostalCode = ukPostalCode;
		this.ukPostalCode = this.ukPostalCode == null ? this.ukPostalCode : this.ukPostalCode.trim().toUpperCase();
		this.outCode = null;
	}
	
	/**
	 * Method getPostalCode.
	 * @return String
	 */
	public String getPostalCode(){
		return this.ukPostalCode;
	}
	
	/**
	 * Method getOutCode.
	 * @return String
	 */
	public String getOutCode(){
		if(this.outCode == null){
			populateInOutCodes();
		}
		return this.outCode;
	}
	
	private void populateInOutCodes(){
		outCode = ukPostalCode;
	}
}

