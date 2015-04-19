package com.wcc.interview.postal.code.distance.auth;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;

import com.wcc.interview.postal.code.distance.core.logic.error.handling.AuthenticationException;

@Provider
public class AuthenticationFilter implements ContainerRequestFilter {
	public static final String AUTHENTICATION_HEADER = "Authorization";

	@Override
	public void filter(ContainerRequestContext containerRequest)throws AuthenticationException {
		String authCredentials = containerRequest.getHeaderString(AUTHENTICATION_HEADER);
		AuthenticationService authenticationService = new AuthenticationService();
		boolean authenticationStatus = authenticationService.authenticate(authCredentials);
		if (!authenticationStatus) {
			throw new AuthenticationException("Invalid user name / password combination. Access denied!");
		}
	}
}