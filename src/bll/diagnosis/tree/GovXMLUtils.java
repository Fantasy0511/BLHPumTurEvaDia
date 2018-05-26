package bll.diagnosis.tree;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import util.PathUtil;

/**
 * 读取XML配置类
 * 
 */
public class GovXMLUtils {
	private static String folder;

	static {
		folder = PathUtil.getWebRealBasePath();
		if (folder == null) {
			folder = PathUtil.getProjectPath();
		}
	}


	public static String GetXMLPath(String filename) {
		String result = folder + "/config/" + filename + ".xml";
		System.out.println("XMLPath:" + result);
		return result;
	}

	public static String getFolder() {
		return folder;
	}
}
