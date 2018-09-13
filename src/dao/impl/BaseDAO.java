package dao.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;

import dao.IBaseDAO;
import util.ConfigReadUtil;
import util.DataInfo;
import util.DataUtils;
import util.FaultUtils;
import util.TimeUtils;
import util.TypeNums;

/**
 * 数据读取实现class
 * 
 * @author lh
 */
public class BaseDAO implements IBaseDAO {
	private Connection conn = null;
	private Statement stmt = null;
	private Statement stmt1 = null;
	private ResultSet rs = null;
	private static String CONFIG_DRIVER_CLASS_NAME;
	private static String CONFIG_URL;
	private static String CONFIG_USER_NAME;
	private static String CONFIG_PASSWORD;

	public BaseDAO() throws ClassNotFoundException, SQLException {
		getConnection();
	}

	{
		try {
			Properties properties = ConfigReadUtil.config("db_config");
			CONFIG_DRIVER_CLASS_NAME = properties
					.getProperty("DRIVER_CLASS_NAME");
			CONFIG_URL = properties.getProperty("URL");
			CONFIG_USER_NAME = properties.getProperty("USER_NAME");
			CONFIG_PASSWORD = properties.getProperty("PASSWORD");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void getConnection() throws ClassNotFoundException, SQLException {
		Class.forName(CONFIG_DRIVER_CLASS_NAME);
		conn = DriverManager.getConnection(CONFIG_URL, CONFIG_USER_NAME,
				CONFIG_PASSWORD);
	}

	private void closeAll() {// 关闭数据库连接
		try {
			if (rs != null) {
				rs.close();
				rs = null;
			}
			if (stmt != null) {
				stmt.close();
				stmt = null;
			}
			if (conn != null) {
				conn.close();
				conn = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("数据库连接失败");
		}

	}

	/**
	 * 查询时间段内的id值与对应的时间
	 */
	public DataUtils queRecord(String table, int id, long starttime,
			long endtime) {
		try {
			getConnection();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ArrayList<String> sqls = getSQL(table, id, starttime, endtime);

		DataUtils data = new DataUtils(table, id);
		try {
			stmt = conn.createStatement();
			// 执行数据库查询语句
			for (String sql : sqls) {
				rs = stmt.executeQuery(sql);
				while (rs.next()) {
					data.addTime(rs.getLong("time"));
					data.addValue(rs.getDouble("value"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("数据库连接失败");
		}
		closeAll();
		return data;
	}

	/**
	 * 查询时间段内的所有数据
	 */
	public ArrayList<DataUtils> queAllRecord(long starttime, long endtime) {
		ArrayList<String> bool_sqls = getSQL("bool", starttime, endtime);
		ArrayList<String> float_sqls = getSQL("float", starttime, endtime);
		ArrayList<String> double_sqls = getSQL("double", starttime, endtime);
		int boolnums = TypeNums.BOOL.getNums(),
				doublenums = TypeNums.DOUBLE.getNums(),
				floatnums = TypeNums.FLOAT.getNums();
		ArrayList<DataUtils> datas = new ArrayList<>();
		for (int i = 0; i < boolnums; i++) {
			datas.add(new DataUtils("bool", i + 1));
		}
		for (int i = 0; i < doublenums; i++) {
			datas.add(new DataUtils("double", i + 1));
		}
		for (int i = 0; i < floatnums; i++) {
			datas.add(new DataUtils("float", i + 1));
		}
		try {
			stmt = conn.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			// 执行数据库查询语句
			for (String sql : bool_sqls) {
				System.out.println(sql);
				rs = stmt.executeQuery(sql);
				while (rs.next()) {
					int id = rs.getInt("id");
					datas.get(id - 1).addTime(rs.getLong("time"));
					datas.get(id - 1).addValue(rs.getDouble("value"));
				}
			}
			// closeAll();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("数据库连接失败");
		}

		try {
			// 执行数据库查询语句
			for (String sql : double_sqls) {
				System.out.println(sql);
				rs = stmt.executeQuery(sql);
				while (rs.next()) {
					int id = rs.getInt("id");
					datas.get(id + boolnums - 1).addTime(rs.getLong("time"));
					datas.get(id + boolnums - 1)
							.addValue(rs.getDouble("value"));
				}
			}
			// closeAll();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("数据库连接失败");
		}

		try {
			// 执行数据库查询语句
			for (String sql : float_sqls) {
				System.out.println(sql);
				rs = stmt.executeQuery(sql);
				while (rs.next()) {
					int id = rs.getInt("id");
					datas.get(id + boolnums + doublenums - 1)
							.addTime(rs.getLong("time"));
					datas.get(id + boolnums + doublenums - 1)
							.addValue(rs.getDouble("value"));
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("数据库连接失败");
		}
		closeAll();
		return datas;

	}

	/**
	 * 查询具体id对应的含义
	 */
	public DataInfo queInfo(String typeid) {
		String sql = "select * from InfoTable where typeid='" + typeid + "'";
		System.out.println(sql);
		DataInfo datainfo = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String position = rs.getString("position");
				String description = rs.getString("description");
				String parameters = rs.getString("parameters");
				String unit = rs.getString("unit");
				double alarmlevel = rs.getDouble("alarmlevel");
				double HHLimite = rs.getDouble("HHLimite");
				double LLLimite = rs.getDouble("LLLimite");
				double HLimite = rs.getDouble("HLimite");
				double LLimite = rs.getDouble("LLimite");
				datainfo = new DataInfo(typeid, position, parameters,
						description, unit, alarmlevel, HHLimite, LLLimite,
						HLimite, LLimite);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("数据库连接失败");
		}
		closeAll();

		return datainfo;
	}

	/**
	 * 查询所有id对应的含义
	 */
	public HashMap<String, DataInfo> queInfo() {
		String sql = "select * from InfoTable" + " ORDER BY typeid ASC";
		System.out.println(sql);
		HashMap<String, DataInfo> maps = new HashMap<String, DataInfo>();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String typeid = rs.getString("typeid");
				String position = rs.getString("position");
				String description = rs.getString("description");
				String parameters = rs.getString("parameters");
				String unit = rs.getString("unit");
				int alarmlevel = rs.getInt("alarmlevel");
				int HHLimite = rs.getInt("HHLimite");
				int LLLimite = rs.getInt("LLLimite");
				int HLimite = rs.getInt("HLimite");
				int LLimite = rs.getInt("LLimite");
				maps.put(typeid,
						new DataInfo(typeid, position, parameters, description,
								unit, alarmlevel, HHLimite, LLLimite, HLimite,
								LLimite));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("数据库连接失败");
		}
		closeAll();
		return maps;
	}

	/**
	 * 查询infoTable和Map表  
	 */
	public HashMap<String, DataInfo> tableInfo(String typeData,HashMap<String,String> hashMap) {
		String sql  = "select * from InfoTable" + " ORDER BY typeid ASC";
		System.out.println("查询infoTable表："+sql);
		HashMap<String, DataInfo> maps = new HashMap<String, DataInfo>();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next() ==true ) {
				String typeid = rs.getString("typeid");
				String position = rs.getString("position");
				String parameters = rs.getString("parameters");
				String pos = hashMap.get(rs.getString("parameters"));
				/*String pos = rs.getString("description");*/
				maps.put(typeid,new DataInfo(typeid, position, parameters, pos));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("数据库连接失败");
		}
		closeAll();
		return maps;
	}
	
	/**
	 * 查询map表值
	 * @param parameters
	 * @return
	 */

	public HashMap<String,String> mapInfo(String parameters) {
		
		String sql  = "select * from map_" + parameters+ " ORDER BY ID ASC";
		System.out.println("查询map表："+sql);
		HashMap<String, String> maps = new HashMap<>();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String ID = rs.getString("ID");
				String state = rs.getString("PARAMETERS");
				/*System.out.println(state);*/
				maps.put(ID,state);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("数据库连接失败");
		}
		closeAll();
		return maps;
	}
	
	
	
	
	
	
	/**
	 * 获取所有数据的代号list
	 * */
	public HashMap<String, Integer> queAlltype(){
		String sql = "select typeid from InfoTable";
		System.out.println(sql);
		HashMap<String, Integer> StringMap = new HashMap<String, Integer>();
		int idx = 0;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				StringMap.put(rs.getString("typeid"),idx);
				idx = idx+1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("数据库连接失败");
		}
		closeAll();
		return StringMap;
	}
	
	/**
	 * 查询所有故障样本
	 */
	public ArrayList<FaultUtils> queFault() {
		String sql = "select * from FaultInfoTable" + " ORDER BY StartTime ASC";
		System.out.println(sql);
		ArrayList<FaultUtils> faults = new ArrayList<>();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int faultID = rs.getInt("FaultID");
				String system = rs.getString("System");
				String faultName = rs.getString("faultName");
				String faultReason = rs.getString("faultReason");
				long starttime = rs.getLong("StartTime");
				long endtime = rs.getLong("EndTime");
				String workConditon = rs.getString("WorkCondition");
				String parameters = rs.getString("Parameters");
				faults.add(new FaultUtils(faultID, system, faultName, faultReason,
								starttime, endtime, workConditon, parameters));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("数据库连接失败");
		}
		closeAll();
		return faults;
	}

	/**
	 * 查询特定系统下的故障样本
	 */
	public ArrayList<FaultUtils> queFault(String system, Long startTime,
			Long endTime) {
		String sql = "select * from FaultInfoTable where System='" + system
				+ "' AND StartTime between " + startTime + " and " + endTime
				+ " and EndTime<" + endTime + " ORDER BY StartTime ASC";
		System.out.println("fuck" + sql);
		ArrayList<FaultUtils> faults = new ArrayList<>();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int faultID = rs.getInt("FaultID");
				String faultName = rs.getString("faultName");
				String faultReason = rs.getString("faultReason");
				long starttime = rs.getLong("StartTime");
				long endtime = rs.getLong("EndTime");
				String workConditon = rs.getString("WorkCondition");
				String parameters = rs.getString("Parameters");
				faults.add(
						new FaultUtils(faultID, system, faultName, faultReason,
								starttime, endtime, workConditon, parameters));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("数据库连接失败");
		}
		closeAll();

		return faults;
	}

	public ArrayList<FaultUtils> queFault(String system) {
		String sql = "select * from FaultInfoTable where System='" + system
				+ " ORDER BY StartTime ASC";
		System.out.println("fuck" + sql);
		ArrayList<FaultUtils> faults = new ArrayList<>();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int faultID = rs.getInt("FaultID");
				String faultName = rs.getString("faultName");
				String faultReason = rs.getString("faultReason");
				long starttime = rs.getLong("StartTime");
				long endtime = rs.getLong("EndTime");
				String workConditon = rs.getString("WorkCondition");
				String parameters = rs.getString("Parameters");
				faults.add(
						new FaultUtils(faultID, system, faultName, faultReason,
								starttime, endtime, workConditon, parameters));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("数据库连接失败");
		}
		closeAll();

		return faults;
	}

	/**
	 * 生成查询的sql语句
	 */
	public ArrayList<String> getSQL(String table, int id, long starttime,
			long endtime) {
		if (starttime > endtime) {
			long tmp = starttime;
			starttime = endtime;
			endtime = tmp;
		}

		ArrayList<String> sqls = new ArrayList<String>();
		// long型转日期
		String startStr = TimeUtils.LongtoString(starttime);
		String startYear = startStr.substring(0, 4);
		String startMounth = startStr.substring(5, 7);

		String endStr = TimeUtils.LongtoString(endtime);
		String endYear = endStr.substring(0, 4);
		String endMounth = endStr.substring(5, 7);

		if (startYear.equals(endYear) && startMounth.equals(endMounth)) {
			String sql = "select ID, time,value from " + table + "_" + startYear
					+ startMounth + " where id=" + id + " AND time<" + endtime
					+ " AND time>" + starttime + " ORDER BY time ASC";
			sqls.add(sql);
		} else {
			while (!(startYear.equals(endYear)
					&& startMounth.equals(endMounth))) {
				// 先从开始的月开始查询
				String sql = "select ID,time,value from " + table + "_" + startYear
						+ startMounth + " where id=" + id + " AND time<"
						+ endtime + " AND time>" + starttime
						+ " ORDER BY time ASC";
				sqls.add(sql);
				Date stratDate = TimeUtils.StringtoDate(startStr);
				stratDate = TimeUtils.AddUnits(stratDate, "month", 1);
				startStr = TimeUtils.DatetoString(stratDate);
				startYear = startStr.substring(0, 4);
				startMounth = startStr.substring(5, 7);
			}
		}

		return sqls;
	}

	/**
	 * 生成查询的sql语句
	 */
	public ArrayList<String> getSQL(String table, long starttime,
			long endtime) {
		if (starttime > endtime) {
			long tmp = starttime;
			starttime = endtime;
			endtime = tmp;
		}

		ArrayList<String> sqls = new ArrayList<String>();
		// long型转日期
		String startStr = TimeUtils.LongtoString(starttime);
		String startYear = startStr.substring(0, 4);
		String startMounth = startStr.substring(5, 7);

		String endStr = TimeUtils.LongtoString(endtime);
		String endYear = endStr.substring(0, 4);
		String endMounth = endStr.substring(5, 7);

		if (startYear.equals(endYear) && startMounth.equals(endMounth)) {
			String sql = "select ID,time,value from " + table + "_" + startYear
					+ startMounth + " where time<" + endtime + " AND time>"
					+ starttime + " ORDER BY time ASC";
			sqls.add(sql);
		} else {
			while (!(startYear.equals(endYear)
					&& startMounth.equals(endMounth))) {
				// 先从开始的月开始查询
				String sql = "select ID,time,value from " + table + "_" + startYear
						+ startMounth + " where time<" + endtime + " AND time>"
						+ starttime + " ORDER BY time ASC";
				sqls.add(sql);
				Date stratDate = TimeUtils.StringtoDate(startStr);
				stratDate = TimeUtils.AddUnits(stratDate, "month", 1);
				startStr = TimeUtils.DatetoString(stratDate);
				startYear = startStr.substring(0, 4);
				startMounth = startStr.substring(5, 7);
			}
		}

		return sqls;
	}

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

	public Statement getStmt() {
		return stmt;
	}

	public void setStmt(Statement stmt) {
		this.stmt = stmt;
	}

	public ResultSet getRs() {
		return rs;
	}

	public void setRs(ResultSet rs) {
		this.rs = rs;
	}

}
