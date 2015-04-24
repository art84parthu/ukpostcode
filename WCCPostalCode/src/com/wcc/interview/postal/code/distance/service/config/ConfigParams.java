package com.wcc.interview.postal.code.distance.service.config;

public class ConfigParams {
	public static enum ConfigParamNames{
		db_config_properties_location("db-config-properties-location"),
		user_config_properties_location("user-config-properties-location");
		
		private String value;
		private ConfigParamNames(String value){
			this.value = value;
		}
		
		public String getValue(){
			return this.value;
		}
	}
}
