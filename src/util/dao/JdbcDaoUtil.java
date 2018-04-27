package util.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import util.LangUtil;

public class JdbcDaoUtil extends JdbcDaoSupport {
	private static String CONFIG_DRIVER_CLASS_NAME;
	private static String CONFIG_URL;
	private static String CONFIG_USER_NAME;
	private static String CONFIG_PASSWORD;
	private static DataSource dataSource = null;
	{
		LangUtil.config("db_config", this);
	}

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
