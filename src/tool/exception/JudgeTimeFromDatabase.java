package tool.exception;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import bll.diagnosis.tree.dao.ConnectionManager;
import util.TimeUtils;

public class JudgeTimeFromDatabase {
	private Connection conn = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	private String message;

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

	// 查询一下时间是否是数据库中的表的时间      使用bool型数据查
	public String queFloat(long endtime) throws ClassNotFoundException, SQLException {
		try {
			getConnection();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		String endStr = TimeUtils.LongtoString(endtime);
		String endYear = endStr.substring(0, 4);
		String endMounth = endStr.substring(5, 7);

		String sql = "select id from " + "bool" + "_" + endYear + endMounth;

		try {
			stmt = conn.createStatement();
			// 执行数据库查询语句

			rs = stmt.executeQuery(sql);
			message = "查询数据库成功";
			System.out.println("**********");
			System.out.println("结果是:" + message);
			System.out.println("**********");

		} catch (SQLException e) {
			e.printStackTrace();
			message = "数据库中没有该时间";
			System.out.println("**********");
			System.out.println("结果是:" + message);
			System.out.println("**********");
		}
		closeAll();
		return message;

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
