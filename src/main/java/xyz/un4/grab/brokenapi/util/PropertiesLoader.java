package xyz.un4.grab.brokenapi.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import xyz.un4.grab.brokenapi.model.GrabRequest;

public class PropertiesLoader {
	
	

	
	public static GrabRequest loader() {
		
		Properties prop = new Properties();
		InputStream input = null;
		
		GrabRequest grabRequest = new GrabRequest();

		try {

			input = new FileInputStream("config.properties");

			// load a properties file
			prop.load(input);
			grabRequest.setCounter(Integer.valueOf(prop.getProperty("counter")));
			grabRequest.setDelay(Integer.valueOf(prop.getProperty("delay")));
			grabRequest.setMethod(prop.getProperty("method"));
			grabRequest.setTargetNumber(prop.getProperty("targetNumber"));

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return grabRequest;
		
		
		
		
	}
	
	

}
