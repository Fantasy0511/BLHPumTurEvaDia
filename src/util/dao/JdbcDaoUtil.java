package util.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class JdbcDaoUtil extends JdbcDaoSupport {
	private static String CONFIG_DRIVER_CLASS_NAME = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static String CONFIG_URL = "jdbc:sqlserver://218.197.228.63:1433;DatabaseName=lianxuDB;";
	private static String CONFIG_USER_NAME = "user04";
	private static String CONFIG_PASSWORD = "lianxu";
	private static DataSource dataSource = null;

	public JdbcDaoUtil() {
		if (dataSource == null) {
			try {
				Class.forName(CONFIG_DRIVER_CLASS_NAME);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			DataSource dataSource = new DriverManagerDataSource(CONFIG_URL,
					CONFIG_USER_NAME, CONFIG_PASSWORD);
			setDataSource(dataSource);
			getJdbcTemplate().setQueryTimeout(9);
		}
	}
	
	protected <T> T queryBean(String sql, Class<T> clazz, Object... objects) {
		return getJdbcTemplate().queryForObject(sql,
				BeanPropertyRowMapper.newInstance(clazz), objects);
	}

}
