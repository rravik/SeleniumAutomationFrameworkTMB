package com.tmb.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

import com.tmb.constants.FrameworkConstants;

public final class ReadPropertyFile {

	private static Properties property = new Properties();
	private static final Map<String, String> CONFIGMAP = new HashMap<>();

	private ReadPropertyFile() {

	}

	// Static block is used to initialize the property details
	static {

		try {

			FileInputStream file = new FileInputStream(FrameworkConstants.getConfigFilePath());

			property.load(file);
			
			//All the property detail storing into the hashmap

			for (Map.Entry<Object, Object> entry : property.entrySet()) {

				CONFIGMAP.put(String.valueOf(entry.getKey()), String.valueOf(property.get(entry.getKey())));
			}

			// Lambda Expression
			// property.entrySet().forEach(entry ->
			// CONFIGMAP.put(String.valueOf(entry.getKey()),
			// String.valueOf(entry.getValue())));

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public static String get(String key) throws Exception {

		if (Objects.isNull(key) || Objects.isNull(property.get(key))) {

			throw new Exception("Property Name " + key + "is not found. Please check config.properties");
		}

		return CONFIGMAP.get(key);

	}

	/*
	 * 
	 * public static String getValue(String key) throws Exception {
	 * 
	 * if (Objects.isNull(property.getProperty(key)) || Objects.isNull(key)) {
	 * 
	 * throw new Exception("Property Name " + key +
	 * "is not found. Please check config.properties"); } return
	 * property.getProperty(key); }
	 * 
	 */
}
