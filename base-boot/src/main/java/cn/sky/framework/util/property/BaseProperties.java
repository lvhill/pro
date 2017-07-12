package cn.sky.framework.util.property;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseProperties {
	private static final Logger logger = LoggerFactory.getLogger(BaseProperties.class);

	private static Map<String, Properties> mapProperties = new HashMap<String, Properties>();

	public static Properties load(String name) {
		if (mapProperties.containsKey(name)) {
			return mapProperties.get(name);
		}
		Properties properties = new Properties();
		InputStream inputStream = null;
		try {
			inputStream = BaseProperties.class.getResourceAsStream("/" + name);
			properties.load(inputStream);
		} catch (FileNotFoundException e) {
			logger.error(e.getMessage());
		} catch (IOException e) {
			logger.error(e.getMessage());
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					logger.error(e.getMessage());
				}
			}
		}
		mapProperties.put(name, properties);
		return properties;
	}

}
