package bll.predict.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bll.predict.PredictInput;
import util.TestUtil;
import util.TimeUtils;

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
			int id,Long time) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ResultSet rs1 = null;
		List<String> times = new ArrayList<String>();
		List<Double> datas = new ArrayList<Double>();
		List<Double> Hlimite = new ArrayList<Double>();
		/*查询数据库 预测时间和值*/
		String sql1 = "SELECT time,value from " + tableName + " where ID ='"
				+ String.valueOf(id) + "' AND [time]>"+time+" AND [time]<"+(time+86400)+" ORDER BY time;";
		/*查询预测量对应阈值*/
		System.out.println("sql——svm: "+sql1);
		String sql2 ="SELECT  Hlimite  from  InfoTable where typeid ='float"+String.valueOf(id)+"'" ;
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
		
		try {
			conn = GovDBConfig.getconnection();
			stmt = conn.createStatement();
			System.out.println(sql2);
			rs1 = stmt.executeQuery(sql2);
			while (rs1.next() == true ) {
				Hlimite.add(Double.parseDouble(rs1.getString("Hlimite")));
				System.out.println("Hlimite的值："+Hlimite);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			GovDBConfig.closeConnection(rs1, stmt, conn);
		}
		
		/*查询数据库获取time和value以及hlimite*/
		PredictInput inputData = new PredictInput(StringList2Array(times),doubleList2Array(datas),doubleList2Array(Hlimite));
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
