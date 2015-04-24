package com.wcc.interview.postal.code.distance.db.persistance.dao;

import com.wcc.interview.postal.code.distance.core.logic.PCCoordinates;
import com.wcc.interview.postal.code.distance.core.logic.UKPostalCode;

/**
 * DAO interface 
 * for defining methods to perform CRUD operations
 * 
 * For no, only fetch is defined here. 
 */
public interface UKPCCoordinatesDao {
	/**
	 * Method fetchPCCoordnates.
	 * 
	 * @param pc UKPostalCode
	 * @return PCCoordinates
	 */
	PCCoordinates fetchPCCoordnates(UKPostalCode pc);
	//boolean insertRecord(PCCoordinates xy);
}
