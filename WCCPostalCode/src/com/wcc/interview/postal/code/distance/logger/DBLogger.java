package com.wcc.interview.postal.code.distance.logger;

/**
 * This class is a place holder for the actual sophisticated logging mechanism.
 * 
 * Right now for the sake of simplicity, the service uses only Log4j. 
 * We have two options here:
 * 
 * 1. With the current Log4j implementation, we can later be integrate it with some log scraping tool
 *    which will in turn aggregate them to a DB table for better persistance. 
 *    
 * 2. Or, we can skip the log4j completely and implement a custom logger here itself 
 * 	  which will directly persist the logs into log DB. 
 * 
 * Option 1 is faster and doesnt impact performance. 
 * 
 * This class is a place-holder which can later be implemented for persisting in log DB 
 * either through scraping tool or direct persistance.
 * 
 */
public class DBLogger {

	/**
	 * This method needs to be called for DB persistance
	 * 
	 * Config property has to be defined for table and 
	 * that will be fetched here for persistance 
	 */
	public static void logRequestResponseInfo(){
		
	}
}
