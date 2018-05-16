package bll.predict.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Properties;

import util.PathUtil;
import util.TestUtil;

public class GovDBConfig {
	private static String sDBDriver;
	private static String url;
	private static String user;
	private static String pwd;

	static {
		Properties p = new Properties();
		InputStream stream = null;
		try {
			stream = new FileInputStream(PathUtil.getWebRealBasePath()
					+ "/config/db_config.properties");
			p.load(stream);
		} catch (IOException e) {
			throw new IllegalStateException(e);
		}

		sDBDriver = p.getProperty("DRIVER_CLASS_NAME");
		url = p.getProperty("URL");
		user = p.getProperty("USER_NAME");
		pwd = p.getProperty("PASSWORD");
	}

	public static boolean exeSql(String sql) {
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = GovDBConfig.getconnection();
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			closeConnection(stmt, conn);
		}
		return true;
	}

	public static Connection getconnection() {

		Connection conn = null;

		try {
			Class.forName(sDBDriver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {
			TestUtil.print("here" + url);
			TestUtil.print("here" + user);
			TestUtil.print("here" + pwd);
			conn = DriverManager.getConnection(url, user, pwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	/**
	 * 批量执行sql语句
	 * 
	 * @param list
	 * @return
	 */
	public static boolean exeBatch(List<String> list) {
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = GovDBConfig.getconnection();
			stmt = conn.createStatement();
			int size = list.size();
			for (int i = 0; i < size; i++) {
				stmt.addBatch(list.get(i));
			}
			stmt.executeBatch();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			closeConnection(stmt, conn);
		}
		return true;
	}

	/**
	 * 关闭ResultSet
	 * 
	 * @param rs
	 */
	public static void closeResultSet(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	/**
	 * 关闭Statement
	 * 
	 * @param stmt
	 */
	public static void closeStatement(Statement stmt) {
		if (stmt != null) {
			try {
				stmt.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	/**
	 * 关闭ResultSet、Statement
	 * 
	 * @param rs
	 * @param stmt
	 */
	public static void closeStatement(ResultSet rs, Statement stmt) {
		closeResultSet(rs);
		closeStatement(stmt);
	}

	/**
	 * 关闭PreparedStatement
	 * 
	 * @param pstmt
	 * @throws SQLException
	 */
	public static void fastcloseStmt(PreparedStatement pstmt)
			throws SQLException {
		pstmt.close();
	}

	/**
	 * 关闭ResultSet、PreparedStatement
	 * 
	 * @param rs
	 * @param pstmt
	 * @throws SQLException
	 */
	public static void fastcloseStmt(ResultSet rs, PreparedStatement pstmt)
			throws SQLException {
		rs.close();
		pstmt.close();
	}

	/**
	 * 关闭ResultSet、Statement、Connection
	 * 
	 * @param rs
	 * @param stmt
	 * @param con
	 */
	public static void closeConnection(ResultSet rs, Statement stmt,
			Connection con) {
		closeResultSet(rs);
		closeStatement(stmt);
		closeConnection(con);
	}

	/**
	 * 关闭Statement、Connection
	 * 
	 * @param stmt
	 * @param con
	 */
	public static void closeConnection(Statement stmt, Connection con) {
		closeStatement(stmt);
		closeConnection(con);
	}

	/**
	 * 关闭Connection
	 * 
	 * @param con
	 */
	public static void closeConnection(Connection con) {
		if (con != null) {
			try {
				con.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

}
