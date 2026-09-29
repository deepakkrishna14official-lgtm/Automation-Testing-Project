package Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	 
	private final Properties properties;

	    public ConfigReader() {

	        properties = new Properties();

	        try (FileInputStream fis =
	                     new FileInputStream("src/main/resources/Config.Properties")) {

	            properties.load(fis);

	        } catch (IOException e) {

	            throw new RuntimeException("Unable to load config.properties", e);
	            
	        }
	    }

	    public String getProperty(String key) {

	        return properties.getProperty(key);

	    }





	}


