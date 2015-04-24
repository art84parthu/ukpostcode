package com.wcc.interview.postal.code.distance.service.config;

import java.util.Iterator;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.wcc.interview.postal.code.distance.service.config.ConfigParams.ConfigParamNames;

/**
 * Simple servlet for loading custom properties. 
 */
public class CustomJerseyConfigLoader extends HttpServlet {

	private static final long serialVersionUID = 1L;
	static Logger LOGGER = LogManager.getLogger(CustomJerseyConfigLoader.class);

	/**
	 * Method init.
	 * overridden to load db properties and user login credentials
	 * 
	 * @param config ServletConfig
	 * @throws ServletException
	 * @see javax.servlet.Servlet#init(ServletConfig)
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		LOGGER.info("Loading custom config DB properties.");
		String path = config.getInitParameter(ConfigParamNames.db_config_properties_location.getValue());
		try{
			LOGGER.info("Properties file path= " + path);
			Configuration dbConfig = new PropertiesConfiguration(path);
			
			Iterator<String> keys = dbConfig.getKeys();
		    while(keys.hasNext()){
		    	String key = keys.next();
		    	String value = dbConfig.getString(key);
			    DBConfig.addDBProperty(DBConfig.getEnumConstant(key), value);
			    LOGGER.info("Adding DB Prop " + key + " = " + value);
		    }
		    
		    LOGGER.info("Loading custom config user properties.");
			path = config.getInitParameter(ConfigParamNames.user_config_properties_location.getValue());
			LOGGER.info("Properties file path= " + path);
			Configuration userConfig = new PropertiesConfiguration(path);
			
			keys = userConfig.getKeys();
		    while(keys.hasNext()){
		    	String key = keys.next();
		    	String value = userConfig.getString(key);
			    UserConfig.addUserProperty(UserConfig.getEnumConstant(key), value);
			    LOGGER.info("Adding User Prop " + key + " = " + value);
		    }
		}
		catch(ConfigurationException ce){
			LOGGER.error("Exception occured while loading DB properties\n");
			LOGGER.error("Stack Trace : " + ce.getMessage() + ce.getStackTrace());
		}
		super.init(config);
	}
}