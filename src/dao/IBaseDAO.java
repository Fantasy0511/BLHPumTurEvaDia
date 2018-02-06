package dao;

import java.util.HashMap;

import util.DataInfo;
import util.DataUtils;

/**
 * DAO基本接口
 * @author lh
 * */
public interface IBaseDAO {
	
	
	public DataUtils queRecord(String table, int id,long starttime, long endtime);//得到数据
	public HashMap<String, DataInfo> queInfo();//查询参数信息
}
