/*package bll.diagnosis.tree.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.swing.text.StyleContext.SmallAttributeSet;

import bll.diagnosis.tree.GovDBConfig;
import util.PathUtil;

/**
 * @author xyh Young
 * @version 创建时间：2016年6月20日 下午4:39:11 数据库监测数据查询
 * 监控数据分为开关量和模拟量,其中:
 * 开关量包括： modeSet, modeState, sdzt,  ptHAlarm, ptLAlarm
 * 模拟量包括： kdgd, jlqxc, unitloadset, pt
 */
/*public class UnitDataRead {
	// private List<IdenJCData> JCDataRead(String startTime, String endTime,
	// int unitNo, String wc_type){
	// DataBaseJCInputQuery JCDataInput=new DataBaseJCInputQuery();
	//
	// // @SuppressWarnings("static-access")
	// // List<IdenJCData> jcdata=JCDataInput.read(startTime, endTime, unitNo,
	// wc_type);
	// return jcdata;
	// }
	/*public static List<JKPData> readOilData(int unitID, String timeEnd) {
		Connection conn = null;
		Statement stmt = null;  
		ResultSet rs = null;

		List<JKPData> list = new ArrayList<JKPData>();

		String sql = "SELECT Top 1 fModel,lockState,pressTankP,pressOilPumpC1,SetP,SetGuideVane FROM [HPDBase].[dbo].[HP_JK_COMUNICATION] "
				+ "WHERE Time<'"+ timeEnd + "' order by Time desc";

		try {
			conn = GovDBConfig.getconnection();
			stmt = conn.createStatement();
			System.out.println(sql);
			rs = stmt.executeQuery(sql);
			/*while (rs.next() == true) {
				JKPData jkd = new JKPData();
			//	jkd.setDyfkbj(0); //监控数据库表中缺少，暂时赋值
			//	jkd.setModeset(rs.getInt("fModel"));
			//	jkd.setModestate(rs.getInt("fModel"));
			//	jkd.setSdzt(rs.getInt("lockState"));
				//jkd.setPt((double)rs.getFloat("pressTankP")); 
//				jkd.setPt(rs.getString("PressTankP").split(","));
//				jkd.setPtHAlarm(rs.getInt("pressOilPumpC1"));
//				jkd.setPtLAlarm(rs.getInt("pressOilPumpC1"));
			//	jkd.setPtHAlarm(0);
			//	jkd.setPtLAlarm(0);
            //    jkd.setUnitloadset(rs.getFloat("SetP"));
             //   jkd.setKdgd(rs.getFloat("SetGuideVane"));
            //    jkd.setJlqxc(0.5); //监控数据库中缺少，暂时赋值
				list.add(jkd);
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
	
/*	public static void main(String[] args) {
		// 向数据库中写入数据
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		java.text.Format format = new java.text.SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		String nowtime = format.format(new java.util.Date());
		String sql = "insert into [HPDBase].[dbo].[HP_JK_Data] (Time, PressTankH, OilPumpC) values ('"+nowtime+"',1,2)";		
		try {
			Properties p = new Properties();
			InputStream stream = null;
			try {
//				D:\Java\workspace\HPPumTurReg\WebContent/config/db_config.properties
				stream = new FileInputStream(PathUtil.getWebRealBasePath()+"/config/db_config.properties");
				p.load(stream);
			} catch (IOException e) {
				throw new IllegalStateException(e);
			}

			String sDBDriver = p.getProperty("DRIVER_CLASS_NAME");
			String url = p.getProperty("URL");
			String user = p.getProperty("USER_NAME");
			String pwd = p.getProperty("PASSWORD");

			
			conn = GovDBConfig.getconnection(url,user, pwd);
			stmt = conn.createStatement();
			System.out.println(sql);
			stmt.addBatch(sql);
			stmt.executeBatch();
			
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace(); 
		}
	}
	
}
*/