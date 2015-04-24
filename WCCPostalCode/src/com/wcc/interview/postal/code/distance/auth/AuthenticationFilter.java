package com.wcc.interview.postal.code.distance.auth;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.wcc.interview.postal.code.distance.core.logic.error.handling.AuthenticationException;

/**
 * Filter for all requests
 * Will check if Basic Http Auth credentials are provided and will validate the same 
 * using AuthenticationService
 */
@Provider
public class AuthenticationFilter implements ContainerRequestFilter {
	private static final String AUTHENTICATION_HEADER = "Authorization";
	static Logger LOGGER = LogManager.getLogger(AuthenticationFilter.class);

	/**
	 * Overridden method filter
	 * 
	 * Will extract the authorization header and will send 
	 * the validation request to AuthenticationService
	 * 
	 * @param containerRequest ContainerRequestContext
	 * @throws AuthenticationException
	 * @see javax.ws.rs.container.ContainerRequestFilter#filter(ContainerRequestContext)
	 */
	@Override
	public void filter(ContainerRequestContext containerRequest)throws AuthenticationException {
		String authCredentials = containerRequest.getHeaderString(AUTHENTICATION_HEADER);
		AuthenticationService authenticationService = new AuthenticationService();
		boolean authenticationStatus = authenticationService.authenticate(authCredentials);
		if (!authenticationStatus) {
			String message = "Invalid user name / password combination. Access denied!";
			LOGGER.error("Authentication Failed");
			LOGGER.error("Error message" + message);
			throw new AuthenticationException(message);
		}
	}
}