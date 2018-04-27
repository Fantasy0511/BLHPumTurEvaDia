package dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import dao.IBaseDAO;
import util.DataInfo;
import util.DataUtils;
import util.FaultUtils;
import util.TimeUtils;

/**
 * 数据读取class
 * 
 * @author lh
 */
public class ReadData implements IBaseDAO {

	/**
	 * 查询时间段内指定id的数据
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public DataUtils queRecord(String table, int id, long starttime,
			long endtime) throws SQLException, ClassNotFoundException {
		BaseDAO database = new BaseDAO();
		DataUtils data = database.queRecord(table, id, starttime, endtime);
		return data;
	}

	/**
	 * 查询时间段内指定id的数据
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public DataUtils queRecord(String table, int id, String startstr,
			String endstr) throws ClassNotFoundException, SQLException {
		BaseDAO database = new BaseDAO();
		long starttime = TimeUtils.StringtoLong(startstr);
		long endtime = TimeUtils.StringtoLong(endstr);
		DataUtils data = database.queRecord(table, id, starttime, endtime);
		return data;
	}

	/**
	 * 查询时间段内所有的数据
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public ArrayList<DataUtils> queAllRecord(long starttime, long endtime)
			throws ClassNotFoundException, SQLException {
		BaseDAO database = new BaseDAO();
		ArrayList<DataUtils> datas = database.queAllRecord(starttime, endtime);
		return datas;
	}

	/**
	 * 查询时间段内所有的数据 datas从1开始计数，bool-double-float
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public ArrayList<DataUtils> queAllRecord(String startstr, String endstr)
			throws ClassNotFoundException, SQLException {
		BaseDAO database = new BaseDAO();
		long starttime = TimeUtils.StringtoLong(startstr);
		long endtime = TimeUtils.StringtoLong(endstr);
		ArrayList<DataUtils> datas = database.queAllRecord(starttime, endtime);
		return datas;
	}

	/**
	 * 查询所有tableid的信息，结果为position.parameters.description
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public HashMap<String, DataInfo> queInfo() throws ClassNotFoundException, SQLException {
		BaseDAO database = new BaseDAO();
		HashMap<String, DataInfo> maps = database.queInfo();
		return maps;
	}

	/**
	 * 查询具体tableid的信息，结果为position.parameters.description
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public DataInfo queInfo(String typeid)
			throws ClassNotFoundException, SQLException {
		BaseDAO database = new BaseDAO();
		DataInfo dataInfo = database.queInfo(typeid);
		return dataInfo;
	}

	/**
	 * 查询所有故障信息
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public ArrayList<FaultUtils> queFault()
			throws ClassNotFoundException, SQLException {
		BaseDAO database = new BaseDAO();
		ArrayList<FaultUtils> faults = database.queFault();
		return faults;
	}

	/**
	 * 查询特定系统的故障信息
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public ArrayList<FaultUtils> queFault(String system, Long startTime,
			Long endTime) throws ClassNotFoundException, SQLException {
		BaseDAO database = new BaseDAO();
		ArrayList<FaultUtils> faults = database.queFault(system, startTime,
				endTime);
		return faults;
	}

	public ArrayList<FaultUtils> queFault(String system)
			throws ClassNotFoundException, SQLException {
		BaseDAO database = new BaseDAO();
		ArrayList<FaultUtils> faults = database.queFault(system);
		return faults;
	}

}
