/*package bll.diagnosis.tree.dao;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import bll.diagnosis.tree.GovDBConfig;
import util.LangUtil;

public class CollectDataRead {
	/*public static List<JCData> readFromCollector(int unitID, String dateTime){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;		
		List<JCData> list = new ArrayList<JCData>();
		
		//sql查询语句
		String sql = "SELECT TOP 1 COL_START_TIME, COL_STOP_TIME, COL_SAMPLE_INTERVAL, COL_DATA1, COL_DATA3, COL_DATA5, COL_UNIT_NO, COL_CONDITION "
				+ "FROM [HPDBase].[dbo].[HP_COLLECTOR] WHERE COL_UNIT_NO=" + 3 + " AND COL_STOP_TIME<'"+ dateTime + "' order by COL_STOP_TIME desc";
		try {
			conn = GovDBConfig.getconnection();
			stmt = conn.createStatement();
			System.out.println(sql);
			rs = stmt.executeQuery(sql);
			while(rs.next() == true){
				JCData jcd = new JCData();
				jcd.setSampleinterval((double)rs.getFloat("COL_SAMPLE_INTERVAL"));
				jcd.setWcStatus(rs.getString("COL_CONDITION"));
				jcd.setWc_time(rs.getString("COL_START_TIME"));
	 	
				byte[] binary_Power= rs.getBytes("COL_DATA5");
				double[] power = LangUtil.fromDoubleBytes(binary_Power);
//				double [] power = new double[(int)binary_Power.length/2];
//				DataInputStream input_Data1 = new DataInputStream(new ByteArrayInputStream(binary_Power));
//				for (int i = 0; i < power.length; i++) {
//					try {
//						power[i] = input_Data1.readShort();
//					} catch (IOException e) {
//						e.printStackTrace();
//					}
//				}
				jcd.setPower(power);
				
				byte[] binary_freq= rs.getBytes("COL_DATA1");
				double[] freq = LangUtil.fromDoubleBytes(binary_freq);
//				double [] freq = new double[(int)binary_freq.length/2];
//				DataInputStream input_Data2 = new DataInputStream(new ByteArrayInputStream(binary_freq));
//				for (int i = 0; i < freq.length; i++) {
//					try {
//						freq[i] = input_Data2.readShort();
//					} catch (IOException e) {
//						e.printStackTrace();
//					}
//				}
				jcd.setFre_unit(freq);
				
				byte[] binary_y= rs.getBytes("COL_DATA3");
				double[] y = LangUtil.fromDoubleBytes(binary_y);
//				double [] y = new double[(int)binary_y.length/2];
//				DataInputStream input_Data5 = new DataInputStream(new ByteArrayInputStream(binary_y));
//				for (int i = 0; i < y.length; i++) {
//					try {
//						y[i] = input_Data5.readShort();
//					} catch (IOException e) {
//						e.printStackTrace();
//					}
//				}
				jcd.setXc_guidevane(y);
				list.add(jcd);
			}
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return list;
		}
		return list;
	}
}*/
