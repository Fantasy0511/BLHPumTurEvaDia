package bll.diagnosis.tree.dao;

import java.beans.PropertyVetoException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import util.ConfigReadUtil;

public final class ConnectionManager {
	// 使用单利模式创建数据库连接池
	private static ConnectionManager instance;
	private static ComboPooledDataSource dataSource;

	private ConnectionManager() throws SQLException, PropertyVetoException, FileNotFoundException, IOException {
		Properties properties = ConfigReadUtil.config("db_config");
		dataSource = new ComboPooledDataSource();

		dataSource.setUser(properties.getProperty("USER_NAME")); // 用户名
		dataSource.setPassword(properties.getProperty("PASSWORD")); // 密码
		dataSource.setJdbcUrl(properties.getProperty("URL"));// 数据库地址
		dataSource.setDriverClass(properties.getProperty("DRIVER_CLASS_NAME"));
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