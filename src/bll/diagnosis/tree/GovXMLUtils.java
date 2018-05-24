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

	public static String GetipFD() {
		return parse("GovAppconfig", "/Station/ipFD");
	}

	public static String GetDBNameFD() {
		return parse("GovAppconfig", "/Station/DBNameFD");
	}

	public static String GetuserFD() {
		return parse("GovAppconfig", "/Station/userFD");
	}

	public static String GetpwdFD() {
		return parse("GovAppconfig", "/Station/pwdFD");
	}

	private static String parse(String file, String xpath) {
		String result = "";
		String path = GetXMLPath(file);
		try {
			SAXReader saxReader = new SAXReader();
			Document document = saxReader.read(new File(path));
			@SuppressWarnings("unchecked")
			List<Element> list = document.selectNodes(xpath);
			Iterator<Element> iter = list.iterator();
			if (iter.hasNext()) {
				Element ownerElement = (Element) iter.next();
				result = ownerElement.getText();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return result;
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
