package com.wcc.interview.postal.code.distance.db.persistance;

import java.sql.Connection;
import java.sql.DriverManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.wcc.interview.postal.code.distance.service.config.DBConfig;

public class DBConnection {

	static Logger LOGGER = LogManager.getLogger(DBConnection.class);
	
	public static Connection getConnection(){
		Connection con = null;
		try {
			LOGGER.info("Getting DB connection");
			Class.forName(DBConfig.getDBProperty(DBConfig.DBPropertyKeys.DRIVER_NAME));
			String path = DBConfig.getDBProperty(DBConfig.DBPropertyKeys.SQLite_DB_PATH);
			String db_name = DBConfig.getDBProperty(DBConfig.DBPropertyKeys.SQLite_DB_NAME);
			con = DriverManager.getConnection("jdbc:sqlite:"+path+db_name);
			LOGGER.info("Connection object = " + con);
		}catch(Exception e){
			LOGGER.error("Exception occured when trying to get a DB connection");
			LOGGER.error("Exception message : " + e.getMessage() + "\n" + e.getStackTrace());
		}
		return con;
	}

	public static void main(String[] args){
		getConnection();
	}
}

