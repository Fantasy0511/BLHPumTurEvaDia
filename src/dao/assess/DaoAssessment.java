package dao.assess;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import util.DataUtils;
import util.TimeUtils;

public class DaoAssessment {
	private Connection conn = null;
	private Statement stmt = null;
	private ResultSet rs = null;

	//
	// private void getConnection() throws ClassNotFoundException{//建立数据库连接
	// String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	// //加载JDBC驱动
	// String url =
	// "jdbc:sqlserver://218.197.228.63:1433;DatabaseName=lianxuDB;";
	// try {
	// // 连接数据库
	// Class.forName(driverName); //后加的一句
	// conn = DriverManager.getConnection(url, "sa", "123456");
	// } catch (SQLException e) {
	// e.printStackTrace();
	// System.out.println("数据库连接失败");
	// }
	// }

	/*
	 * 使用c3p0数据库连接池 建立数据库连接 减少数据库连接开销
	 */
	private void getConnection() throws ClassNotFoundException {
		conn = ConnectionManager.getInstance().getConnection();
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

	// 查询boolean型数据
	public DataUtils queBool(String table, int id, long endtime) {
		try {
			getConnection();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		long starttime = endtime - 604800;
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

	// 查询float型数据
	public DataUtils queFloat(String table, int id, long endtime) {
		try {
			getConnection();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		long starttime = endtime - 300;
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
			String sql = "select * from " + table + "_" + startYear
					+ startMounth + " where id=" + id + " AND time<" + endtime
					+ " AND time>" + starttime + " ORDER BY time ASC";
			System.out.println(sql);
			sqls.add(sql);

		} else {
			while (!(startYear.equals(endYear)
					&& startMounth.equals(endMounth))) {
				// 先从开始的月开始查询
				String sql = "select * from " + table + "_" + startYear
						+ startMounth + " where id=" + id + " AND time<"
						+ endtime + " AND time>" + starttime
						+ " ORDER BY time ASC";
				System.out.println(sql);
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
