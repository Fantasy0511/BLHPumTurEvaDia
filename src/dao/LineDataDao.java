package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bll.predict.PredictInput;
import bll.predict.dao.GovDBConfig;
import util.TimeUtils;

public class LineDataDao {
	public static  PredictInput read(String tableName,String ID,Long time) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<String> times = new ArrayList<String>();
		List<Double> datas = new ArrayList<Double>();
		long endTime=time+86400;		
		/*查询数据库 预测时间和值*/
		String sql1 = "SELECT TOP 5000 time,value  from " + tableName + " where ID ='"
				+ ID + "' AND [time]>"+time+"AND [time] <"+ endTime+" ORDER BY time;";
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
