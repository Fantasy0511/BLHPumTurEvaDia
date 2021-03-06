package blh.action.asscss.boolParm.dao;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import util.TestUtil;
import util.TimeUtils;
import util.dao.JdbcDaoUtil;
import bll.predict.PredictInput;
import bll.predict.dao.AssessPredictData;
import bll.predict.dao.GovDBConfig;

/**
 * 该类用于预测时的数据读取
 * 
 * @author dragon
 * 
 */
public class historyBoolDao {
	/**
	 * 读取评估历史数据，用于预测的输入
	 * 
	 * @param unitNo
	 *            机组号
	 * @param objStr
	 *            含三种可能的字符串："TotalState","WCState","OilPumpEfficiency"
	 * @return
	 */
	public static  PredictInput read(String tableName, int unitNo,
			String objStr,Long time) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<String> times = new ArrayList<String>();
		List<Double> datas = new ArrayList<Double>();
		
		/*查询数据库 预测时间和值*/
		String sql1 = "SELECT time,value  from " + tableName + " where ID ='"
				+ objStr + "' AND [time]<"+time+" AND [time]>"+(time-604800)+" ORDER BY time;";
		System.out.println(sql1);
		try {
			conn = GovDBConfig.getconnection();
			stmt = conn.createStatement();
			System.out.println(sql1);
			rs = stmt.executeQuery(sql1);
			while (rs.next() == true ) {
				times.add(TimeUtils.LongtoString(Long.parseLong(rs.getString("time"))));
				datas.add(Double.parseDouble(rs.getString("value")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			GovDBConfig.closeConnection(rs, stmt, conn);
		}
		/*查询数据库获取time和value*/
		PredictInput inputData = new PredictInput(StringList2Array(times),doubleList2Array(datas));
		return inputData;
	}
	
	
	/*list<String> time  转String[]*/
	private static String[] StringList2Array(List<String> data) {
		String[] re = new String[data.size()];
		for (int i = 0; i < re.length; i++)
			re[i] = data.get(i);
		return re;
	}
	/*list<Double>  value  转double[]*/
	private static double[] doubleList2Array(List<Double> data) {
		double[] re = new double[data.size()];
		for (int i = 0; i < re.length; i++)
			re[i] = data.get(i);
		return re;
	}

}
