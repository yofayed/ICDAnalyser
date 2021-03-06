package com.csc.idc;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;

public class ProcPropertiesUtil {
	private static Properties props;
	static {
		props = new Properties();
		try {
			ProcPropertiesUtil util = new ProcPropertiesUtil();
			props = util.getPropertiesFromClasspath("procedure.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// private constructor
	private ProcPropertiesUtil() {
	}

	public static String getProperty(String key) {
		return props.getProperty(key);
	}

	public static Set<Object> getkeys() {
		return props.keySet();
	}

	private Properties getPropertiesFromClasspath(String propFileName)
			throws IOException {
		Properties props = new Properties();
		InputStream inputStream = this.getClass().getClassLoader()
				.getResourceAsStream(propFileName);
		if (inputStream == null) {
			throw new FileNotFoundException("property file '" + propFileName
					+ "' not found in the classpath");
		}
		props.load(inputStream);
		return props;
	}
}
