package com.wcc.interview.postal.code.distance.service;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.wcc.interview.postal.code.distance.core.logic.ComputePCDistance;
import com.wcc.interview.postal.code.distance.core.logic.PCDistanceResponse;
import com.wcc.interview.postal.code.distance.core.logic.error.handling.PostCodeNotFoundException;

@Path("PostalCodeDistance")
public class PostalCodeDistanceService {

	@GET
	@Path("/{pc1}/{pc2}")
	@Produces(MediaType.APPLICATION_JSON)
	public PCDistanceResponse getMsg(@PathParam("pc1") String postalCode1,
		    @PathParam("pc2") String postalCode2) throws PostCodeNotFoundException{
		PCDistanceResponse response = new ComputePCDistance().computeDistance(postalCode1, postalCode2);
		if(response.getDistance() == null){
			String message = "Unable to find distance.";
			if(response.getLocation1().getLatitude() == null ){
				message += "Location 1 postal code not found in the DB";
			}
			if(response.getLocation2().getLatitude() == null ){
				message += "Location 2 postal code not found in the DB";
			}
			throw new PostCodeNotFoundException(message);
		}
		return response;
 
	}
}
