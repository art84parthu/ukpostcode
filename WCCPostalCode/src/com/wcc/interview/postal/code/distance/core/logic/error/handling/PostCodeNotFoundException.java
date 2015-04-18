package com.wcc.interview.postal.code.distance.core.logic.error.handling;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;


public class PostCodeNotFoundException extends WebApplicationException {
	
	private static final long serialVersionUID = 1L;

	/**
	 * @param message
	 */
	public PostCodeNotFoundException(String message) {
		 super(Response.status(Response.Status.NOT_FOUND).
		            entity(message).type("text/plain").build());
	}	
}
