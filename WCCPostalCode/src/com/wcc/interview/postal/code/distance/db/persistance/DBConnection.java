package com.wcc.interview.postal.code.distance.db.persistance;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	public static Connection getConnection(){
		Connection con = null;
		try {
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection("jdbc:sqlite:/home/arthy/Desktop/my-data/softwares/SQLite/uk_postal_codes");

		}catch(Exception e){
			e.printStackTrace();
		}
		return con;
	}

	public static void main(String[] args){
		getConnection();
	}
}

