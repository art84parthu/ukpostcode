package com.wcc.interview.postal.code.distance.core.logic;

public class UKPostalCode {
	private String outCode;
	private String ukPostalCode;
	
	public UKPostalCode(String ukPostalCode){
		this.ukPostalCode = ukPostalCode;
		this.ukPostalCode = this.ukPostalCode == null ? this.ukPostalCode : this.ukPostalCode.trim().toUpperCase();
		this.outCode = null;
	}
	
	public String getPostalCode(){
		return this.ukPostalCode;
	}
	
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

