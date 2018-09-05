package service.excel2Db.TransDb;

import java.sql.SQLException;
import java.util.HashMap;
import dao.impl.ReadData;
import util.DataInfo;

/**
 * 将电站软件解析的实时数据，通过查询系统数据库，将缺失的数据列进行补充， 使列内容与数据库中的bool、double、float保持一致
 * 
 * @author tiandiwei
 *
 */
public class TransDbMain {

	public HashMap<String, DataInfo> getExcle(String typeData) throws ClassNotFoundException, SQLException {
		ReadData rd = new ReadData();
		HashMap<String, DataInfo> maps;
		if (typeData.equals("bool")) {
			typeData="status";
		}
		if (typeData.equals("double")) {
			typeData="count";
		}
		if (typeData.equals("float")) {
			typeData="analog";
		}
		maps = rd.ExcleInfo(typeData);
		return maps;
	}
	
	/**测试*/
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		TransDbMain aDbMain=new TransDbMain();
		HashMap<String, DataInfo> aHashMap=aDbMain.getExcle("bool");
		System.out.println(aHashMap.get("bool1951").getTypeid());
		System.out.println(aHashMap.get("bool1951").getPosition());
		System.out.println(aHashMap.get("bool1951").getParameters());
		System.out.println(aHashMap.get("bool1951").getDescription());
	}

}
