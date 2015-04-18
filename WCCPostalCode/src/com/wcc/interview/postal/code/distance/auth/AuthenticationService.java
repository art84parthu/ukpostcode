package com.wcc.interview.postal.code.distance.auth;

import java.io.IOException;

import javax.xml.bind.DatatypeConverter;

public class AuthenticationService {
	public boolean authenticate(String authCredentials) {

		if (null == authCredentials)
			return false;
		//Replacing "Basic THE_BASE_64" to "THE_BASE_64" directly
		final String encodedUserPassword = authCredentials.replaceFirst("[B|b]asic ", "");
		String usernameAndPassword = null;
		try {
			byte[] decodedBytes = DatatypeConverter.parseBase64Binary(encodedUserPassword);
			usernameAndPassword = new String(decodedBytes, "UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}
		String[] arr = usernameAndPassword.split(":", 2);
		boolean authenticationStatus = "admin".equals(arr[0]) && "admin123".equals(arr[1]);
		return authenticationStatus;
	}
}