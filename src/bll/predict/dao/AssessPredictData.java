package bll.predict.dao;

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

/**
 * 该类用于预测时的数据读取
 * 
 * @author dragon
 * 
 */
public class AssessPredictData {
	/**
	 * 读取评估历史数据，用于预测的输入
	 * 
	 * @param unitNo
	 *            机组号
	 * @param objStr
	 *            含三种可能的字符串："TotalState","WCState","OilPumpEfficiency"
	 * @return
	 */
	public static PredictInput read(String tableName, int unitNo,
			String objStr) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<String> times = new ArrayList<String>();
		List<Double> datas = new ArrayList<Double>();
		String sql = "SELECT top 50 * from " + tableName + " where pos ='"
				+ objStr + "';";
		try {
			conn = GovDBConfig.getconnection();
			stmt = conn.createStatement();
			System.out.println(sql);
			rs = stmt.executeQuery(sql);
			while (rs.next() == true) {
				times.add(TimeUtils
						.LongtoString(Long.parseLong(rs.getString("time"))));
				datas.add(Double.parseDouble(rs.getString("value")));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			GovDBConfig.closeConnection(rs, stmt, conn);
		}
		PredictInput inputData = new PredictInput(StringList2Array(times),
				doubleList2Array(datas));
		return inputData;
	}

	private static String[] StringList2Array(List<String> data) {
		String[] re = new String[data.size()];
		for (int i = 0; i < re.length; i++)
			re[i] = data.get(i);
		return re;
	}

	private static double[] doubleList2Array(List<Double> data) {
		double[] re = new double[data.size()];
		for (int i = 0; i < re.length; i++)
			re[i] = data.get(i);
		return re;
	}

	public static void main(String[] args) {
		PredictInput input = read("float_201701", 1, "LG1G");
		TestUtil.print(input.getTime());
		TestUtil.print(input.getData());
	}
}
