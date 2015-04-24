package com.wcc.interview.postal.code.distance.service.config;

/**
 * Class for listing the properties which are defined in the web.xml for config loader servlet
 */
public class ConfigParams {
	/**
	 * Enum constants 
	 * for representing the config properties location
	 */
	public static enum ConfigParamNames{
		db_config_properties_location("db-config-properties-location"),
		user_config_properties_location("user-config-properties-location");
		
		private String value;
		/**
		 * Constructor for ConfigParamNames.
		 * @param value String
		 */
		private ConfigParamNames(String value){
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
}
