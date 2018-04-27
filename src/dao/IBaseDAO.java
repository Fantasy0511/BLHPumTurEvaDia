package dao;

import java.sql.SQLException;
import java.util.HashMap;

import util.DataInfo;
import util.DataUtils;

/**
 * DAO基本接口
 * @author lh
 * */
public interface IBaseDAO {
	
	
	public DataUtils queRecord(String table, int id,long starttime, long endtime) throws ClassNotFoundException, SQLException;//得到数据

	public HashMap<String, DataInfo> queInfo()
			throws ClassNotFoundException, SQLException;//查询参数信息
}
