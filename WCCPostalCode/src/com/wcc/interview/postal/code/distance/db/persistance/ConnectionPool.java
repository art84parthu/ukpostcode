package com.wcc.interview.postal.code.distance.db.persistance;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Dummy connection pool.
 * Does no real pooling. Just returns a connection 
 * without checking if it is already in use or not. 
 */
public class ConnectionPool {
	private static int pool_size = 10;
	private static Connection[] pool = null;
	
	private static void initPool(){
		pool = new Connection[pool_size];
		pool[0] = DBConnection.getConnection();
	}
	
	/**
	 * Method getConnection.
	 * @return Connection
	 */
	public static Connection getConnection(){
		if(pool == null){
			initPool();
			return pool[0];
		}
		
		for(int i=0; i<pool_size; i++){
			try {
				if(pool[i] != null && !pool[i].isClosed()){
					return pool[i];
				}else{
					pool[i] = DBConnection.getConnection();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
