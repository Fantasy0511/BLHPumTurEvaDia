package bll.diagnosis.tree.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bll.diagnosis.tree.GovDBConfig;

/**
 * @author xyh
 * @version 创建时间：2016年6月20日 下午4:40:41 故障树历史诊断结果查询
 */
public class FaultTreeHistoryQuery  {
	// 查询
	public static List<FaultTreeResult> read(String starttime, String endtime) {
		String sql = "SELECT * FROM BLH_FaultTree_Result Where Time BETWEEN '" + starttime + "' AND '" + endtime + "'";
		return search(sql);
	}

	public static List<FaultTreeResult> search(String sql) {
		Connection conn = GovDBConfig.getconnection();
		Statement stmt = null;
		ResultSet rs = null;

		List<FaultTreeResult> list = new ArrayList<FaultTreeResult>();
		try {
			stmt = conn.createStatement();
			System.out.println(sql);
			rs = stmt.executeQuery(sql);

			while (rs.next() == true) {
				FaultTreeResult td = new FaultTreeResult();
				//td.setWcstatus(rs.getString("WC_Status"));
				td.setTime(rs.getString("Time"));
				td.setResult(rs.getString("Result"));
				td.setRecommendation(rs.getString("Recommendation"));
				td.setUnitNo(rs.getInt("UnitNo"));
				list.add(td);

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
}
