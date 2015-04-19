package com.wcc.interview.postal.code.distance.core.logic.error.handling;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

public class AuthenticationException extends WebApplicationException {
	private static final long serialVersionUID = 1L;

	/**
	 * @param message
	 */
	public AuthenticationException(String message) {
		 super(Response.status(Response.Status.UNAUTHORIZED).
		            entity(message).type("text/plain").build());
	}	
}
