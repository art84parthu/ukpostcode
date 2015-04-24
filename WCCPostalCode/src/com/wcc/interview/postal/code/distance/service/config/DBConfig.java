package com.wcc.interview.postal.code.distance.service.config;

import java.util.HashMap;

public class DBConfig {
	static final HashMap<DBPropertyKeys, String> dbPropsMap = new HashMap<DBPropertyKeys, String>();
	
	public static enum DBPropertyKeys{
		SQLite_DB_PATH("SQLite_DB_PATH"),
		SQLite_DB_NAME("SQLite_DB_NAME"),
		SQLite_TABLE_NAME("SQLite_TABLE_NAME"),
		DRIVER_NAME("DRIVER_NAME");
		
		private String value;
		private DBPropertyKeys(String value){
			this.value = value;
		}
		
		public String getValue(){
			return this.value;
		}
	}
	
	public static void addDBProperty(DBPropertyKeys prop, String value){
		switch(prop){
		case SQLite_DB_PATH:
		case SQLite_DB_NAME:
		case SQLite_TABLE_NAME:
		case DRIVER_NAME:
			dbPropsMap.put(prop, value);
			break;
		default:
			//We wont corrupt our map. 
		}
	}
	
	public static String getDBProperty(DBPropertyKeys key){
		return dbPropsMap.get(key);
	}
	
	public static DBPropertyKeys getEnumConstant(String value){
		for(DBPropertyKeys key : DBPropertyKeys.values()){
			if(value.trim().equals(key.value)){
				return key;
			}
		}
		return null;
	}
}
