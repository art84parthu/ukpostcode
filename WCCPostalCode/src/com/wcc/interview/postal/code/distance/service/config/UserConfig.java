package com.wcc.interview.postal.code.distance.service.config;

import java.util.HashMap;

public class UserConfig {
	static final HashMap<UserPropertyKeys, String> userPropsMap = new HashMap<UserPropertyKeys, String>();
	
	public static enum UserPropertyKeys{
		USERNAME("USERNAME"),
		PASSWORD("PASSWORD");
		
		private String value;
		private UserPropertyKeys(String value){
			this.value = value;
		}
		
		public String getValue(){
			return this.value;
		}
	}
	
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
	
	public static String getUserProperty(UserPropertyKeys key){
		return userPropsMap.get(key);
	}
	
	public static UserPropertyKeys getEnumConstant(String value){
		for(UserPropertyKeys key : UserPropertyKeys.values()){
			if(value.trim().equals(key.value)){
				return key;
			}
		}
		return null;
	}
}
