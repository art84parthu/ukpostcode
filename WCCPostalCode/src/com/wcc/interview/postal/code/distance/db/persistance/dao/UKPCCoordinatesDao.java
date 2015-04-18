package com.wcc.interview.postal.code.distance.db.persistance.dao;

import com.wcc.interview.postal.code.distance.core.logic.PCCoordinates;
import com.wcc.interview.postal.code.distance.core.logic.UKPostalCode;

public interface UKPCCoordinatesDao {
	PCCoordinates fetchPCCoordnates(UKPostalCode pc);
	//boolean insertRecord(PCCoordinates xy);
}
