package maven.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	Properties prop;
	
	public Properties initialize_prop() throws FileNotFoundException {
		
		
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("./src/test/resources/Config/properties/config.properties");
			prop.load(ip);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return prop;
		
	}

}
