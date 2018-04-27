package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReadUtil {
	public static Properties config(String configFileName)
			throws FileNotFoundException, IOException {
		Properties p = new Properties();
		p.load(new FileInputStream(PathUtil.getWebRealBasePath() + "/config/"
				+ configFileName + ".properties"));
		return p;
	}
}
