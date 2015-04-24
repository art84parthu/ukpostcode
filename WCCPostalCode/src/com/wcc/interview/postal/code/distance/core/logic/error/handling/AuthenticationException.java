package com.wcc.interview.postal.code.distance.core.logic.error.handling;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

/**
 * Custom Exception class
 * Will be thrown if authentication fails.
 */
public class AuthenticationException extends WebApplicationException {
	private static final long serialVersionUID = 1L;

	/**
	 * Sets response code as HTTP status code 401
	 * @param message
	 */
	public AuthenticationException(String message) {
		 super(Response.status(Response.Status.UNAUTHORIZED).
		            entity(message).type("text/plain").build());
	}	
}
