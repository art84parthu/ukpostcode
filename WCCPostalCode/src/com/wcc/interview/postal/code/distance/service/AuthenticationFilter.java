package com.wcc.interview.postal.code.distance.service;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.Provider;

import com.wcc.interview.postal.code.distance.auth.AuthenticationService;

@Provider
public class AuthenticationFilter implements ContainerRequestFilter {
	public static final String AUTHENTICATION_HEADER = "Authorization";

	@Override
	public void filter(ContainerRequestContext containerRequest)throws WebApplicationException {
		String authCredentials = containerRequest.getHeaderString(AUTHENTICATION_HEADER);
		AuthenticationService authenticationService = new AuthenticationService();
		boolean authenticationStatus = authenticationService.authenticate(authCredentials);
		if (!authenticationStatus) {
			throw new WebApplicationException(Status.UNAUTHORIZED);
		}
	}
}