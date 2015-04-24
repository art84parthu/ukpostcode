package com.wcc.interview.postal.code.distance.service.config;

import java.util.HashMap;

/**
 */
public class UserConfig {
	private static final HashMap<UserPropertyKeys, String> userPropsMap = new HashMap<UserPropertyKeys, String>();
	
	/**
	 */
	public static enum UserPropertyKeys{
		USERNAME("USERNAME"),
		PASSWORD("PASSWORD");
		
		private String value;
		/**
		 * Constructor for UserPropertyKeys.
		 * @param value String
		 */
		private UserPropertyKeys(String value){
			this.value = value;
		}
		
		/**
		 * Method getValue.
		 * @return String
		 */
		public String getValue(){
			return this.value;
		}
	}
	
	/**
	 * Method addUserProperty.
	 * @param prop UserPropertyKeys
	 * @param value String
	 */
	public static void addUserProperty(UserPropertyKeys prop, String value){
		assert(prop != null);
		switch(prop){
		case USERNAME:
		case PASSWORD:
			userPropsMap.put(prop, value);
			break;
		default:
			//We wont corrupt our map. 
		}
	}
	
	/**
	 * Method getUserProperty.
	 * @param key UserPropertyKeys
	 * @return String
	 */
	public static String getUserProperty(UserPropertyKeys key){
		return userPropsMap.get(key);
	}
	
	/**
	 * Method getEnumConstant.
	 * @param value String
	 * @return UserPropertyKeys
	 */
	public static UserPropertyKeys getEnumConstant(String value){
		for(UserPropertyKeys key : UserPropertyKeys.values()){
			if(value.trim().equals(key.value)){
				return key;
			}
		}
		return null;
	}
}
