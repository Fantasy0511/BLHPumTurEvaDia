package dao.assess;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public final class ConnectionManager {
	// 使用单利模式创建数据库连接池
	private static ConnectionManager instance;
	private static ComboPooledDataSource dataSource;

	private ConnectionManager() throws SQLException, PropertyVetoException {
		dataSource = new ComboPooledDataSource();

		dataSource.setUser("user04"); // 用户名
		dataSource.setPassword("lianxu"); // 密码
		dataSource.setJdbcUrl(
				"jdbc:sqlserver://218.197.228.127:1433;DatabaseName=lianxuDB;");// 数据库地址
		dataSource
				.setDriverClass("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		dataSource.setInitialPoolSize(6); // 初始化连接数
		dataSource.setMinPoolSize(1);// 最小连接数
		dataSource.setMaxPoolSize(10);// 最大连接数
		dataSource.setMaxStatements(500);// 最长等待时间
		dataSource.setMaxIdleTime(160);// 最大空闲时间，单位毫秒
	}

	public static final ConnectionManager getInstance() {
		if (instance == null) {
			try {
				instance = new ConnectionManager();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return instance;
	}

	public synchronized final Connection getConnection() {
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}