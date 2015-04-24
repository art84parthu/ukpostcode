package com.wcc.interview.postal.code.distance.auth;

import java.io.IOException;

import javax.xml.bind.DatatypeConverter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.wcc.interview.postal.code.distance.service.config.UserConfig;

/**
 */
public class AuthenticationService {
	static Logger LOGGER = LogManager.getLogger(AuthenticationService.class);
	
	/**
	 * Method authenticate.
	 * @param authCredentials String
	 * @return boolean
	 */
	public boolean authenticate(String authCredentials) {

		LOGGER.trace("Entering AUTHENTICATION service");
		if (null == authCredentials)
			return false;
		//Replacing "Basic THE_BASE_64" to "THE_BASE_64" directly
		final String encodedUserPassword = authCredentials.replaceFirst("[B|b]asic ", "");
		String usernameAndPassword = null;
		try {
			byte[] decodedBytes = DatatypeConverter.parseBase64Binary(encodedUserPassword);
			usernameAndPassword = new String(decodedBytes, "UTF-8");
		} catch (IOException e) {
			LOGGER.error("Exception occured when decoding user entered credentials");
			LOGGER.error("Exception mesage : " + e.getMessage() + "\n" + e.getStackTrace());
		}
		String[] arr = usernameAndPassword.split(":", 2);
		boolean authenticationStatus = UserConfig.getUserProperty(UserConfig.UserPropertyKeys.USERNAME).equals(arr[0]) 
				&& UserConfig.getUserProperty(UserConfig.UserPropertyKeys.PASSWORD).equals(arr[1]);
		return authenticationStatus;
	}
}