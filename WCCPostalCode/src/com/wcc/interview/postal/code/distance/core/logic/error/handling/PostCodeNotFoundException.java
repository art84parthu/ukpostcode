package com.wcc.interview.postal.code.distance.core.logic.error.handling;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;


/**
 * Custom Exception class
 * Thrown when postal code is not found in the underlying DB
 */
public class PostCodeNotFoundException extends WebApplicationException {
	
	private static final long serialVersionUID = 1L;

	/**
	 * Sets HTTP response 404 when postal code not found. 
	 * @param message
	 */
	public PostCodeNotFoundException(String message) {
		 super(Response.status(Response.Status.NOT_FOUND).
		            entity(message).type("text/plain").build());
	}	
}
