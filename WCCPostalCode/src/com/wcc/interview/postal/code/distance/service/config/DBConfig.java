package com.wcc.interview.postal.code.distance.service.config;

import java.util.HashMap;

/**
 * Config class for loading and maintaining db connection 
 * properties through out the app. 
 * 
 * Maintained as static map.
 */
public class DBConfig {
	private static final HashMap<DBPropertyKeys, String> dbPropsMap = new HashMap<DBPropertyKeys, String>();
	
	/**
	 * DB properties represented as enum
	 * for better type safety 
	 */
	public static enum DBPropertyKeys{
		SQLite_DB_PATH("SQLite_DB_PATH"),
		SQLite_DB_NAME("SQLite_DB_NAME"),
		SQLite_TABLE_NAME("SQLite_TABLE_NAME"),
		DRIVER_NAME("DRIVER_NAME");
		
		private String value;
		/**
		 * Constructor for DBPropertyKeys.
		 * @param value String
		 */
		private DBPropertyKeys(String value){
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
	 * Method addDBProperty.
	 * Ensures it is indeed a valid property before adding to the internal map. 
	 * @param prop DBPropertyKeys
	 * @param value String
	 */
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
	
	/**
	 * Method getDBProperty.
	 * @param key DBPropertyKeys
	 * @return String
	 */
	public static String getDBProperty(DBPropertyKeys key){
		return dbPropsMap.get(key);
	}
	
	/**
	 * Method getEnumConstant.
	 * @param value String
	 * @return DBPropertyKeys
	 */
	public static DBPropertyKeys getEnumConstant(String value){
		for(DBPropertyKeys key : DBPropertyKeys.values()){
			if(value.trim().equals(key.value)){
				return key;
			}
		}
		return null;
	}
}
