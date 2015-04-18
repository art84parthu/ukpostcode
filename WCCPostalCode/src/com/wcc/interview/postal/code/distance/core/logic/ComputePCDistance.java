package com.wcc.interview.postal.code.distance.core.logic;

import com.wcc.interview.postal.code.distance.logger.DBLogger;

public class ComputePCDistance {
	
	private final static double EARTH_RADIUS = 6371; // radius in kilometers
	
	public PCDistanceResponse computeDistance(String postalCode1, String postalCode2){
		if(isValidPostalCode(postalCode1) && isValidPostalCode(postalCode2)){
			UKPostalCode pc1 = new UKPostalCode(postalCode1);
			PCCoordinates xy1 = new PCCoordinates(pc1);
			
			UKPostalCode pc2 = new UKPostalCode(postalCode2);
			PCCoordinates xy2 = new PCCoordinates(pc2);
			
			Double lat1 = xy1.getLatitude();
			Double longt1 = xy1.getLongitude();
			
			Double lat2 = xy2.getLatitude();
			Double longt2 = xy2.getLongitude();
			
			Double dist = null;
			if(lat1 != null && lat2 != null && longt1 != null && longt2 != null){
				dist = calculateDistance(lat1, longt1, lat2, longt2);
			}
			DBLogger.logRequestResponseInfo();
			
			PCDistanceResponse response = new PCDistanceResponse();
			response.setLocation1(xy1);
			response.setLocation2(xy2);
			response.setDistance(dist);
			response.setUnit();
			return response;
		}
		return null;
	}

    private boolean isValidPostalCode(String postalCode1) {
    	/*
    	 * Perform basic Validations here
    	 * Check for null / empty / spaces 
    	 * or any basic format validation if possible.
    	 * 
    	 */
    	
		return true;
	}

	private double calculateDistance(double latitude, double longitude, double latitude2, double longitude2) {
        // Using Haversine formula! See Wikipedia.
        double lon1Radians = Math.toRadians(longitude);
        double lon2Radians = Math.toRadians(longitude2);
        double lat1Radians = Math.toRadians(latitude);
        double lat2Radians = Math.toRadians(latitude2);

        double a = haversine(lat1Radians, lat2Radians)
          + Math.cos(lat1Radians) * Math.cos(lat2Radians) * haversine(lon1Radians, lon2Radians);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return (EARTH_RADIUS * c);
    }

    private double haversine(double deg1, double deg2) {
        return square(Math.sin((deg1 - deg2) / 2.0));
    }

    private double square(double x) {
        return x * x;
    }
}
