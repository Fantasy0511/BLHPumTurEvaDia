package dao.nn;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import util.TimeUtils;
import util.dao.JdbcDaoUtil;

/**
 * 为卷积神经网络做数据准备
 * 
 * @author wuyue
 *
 */
public class ReadyForNn extends JdbcDaoUtil {
	/*
	 * 找到故障对应的开始 结束时间 和关联项
	 * 查找数据库中表《FaultInfoTable》
	 */
	public List<String> getParamFromFaultInfoTable(String faultName) {
		String sqlStr = "select * from FaultInfoTable where FaultName=?";
		System.out.println(sqlStr);
		return getJdbcTemplate().query(sqlStr, new Object[] { faultName }, // getJdbcTemplate 调用数据库方法
				new ResultSetExtractor<List<String>>() {
					@Override
					public List<String> extractData(ResultSet rs)
							throws SQLException, DataAccessException {
						List<String> result = new ArrayList<>();
						while (rs.next()) {
							result.add(rs.getLong("Start") + "");
							result.add(rs.getLong("End") + "");
							result.add(rs.getString("Parameters"));
						}
						return result;
					}
				});
	}

	/**
	 * 从 InfoTable中 获取故障发生position和parameters
	 * @param faultName
	 * @return
	 */
	public List<String> getInfoFromInfoTable(String typeid) {

		String sqlStr = "select * from InfoTable where typeid=?";
		System.out.println(sqlStr);
		return getJdbcTemplate().query(sqlStr, new Object[] { typeid },  // getJdbcTemplate 调用数据库方法
				new ResultSetExtractor<List<String>>() {
					@Override
					public List<String> extractData(ResultSet rs)
							throws SQLException, DataAccessException {
						List<String> result = new ArrayList<>();
						while (rs.next()) {
							result.add(rs.getString("position"));
							result.add(rs.getString("description"));
						}
						return result;
					}
				});

	}

	/*
	 * 选择对应的变量从各个历史库中
	 */

	public List<String> getValues(String faultName) {
		List<String> list = getParamFromFaultInfoTable(faultName);  // 从表《FaultInfoTable》中获取故障名称，赋值给list

		String start = TimeUtils.LongtoString(Long.parseLong(list.get(0)));  // 时间类型的相互转换方法，从long型转换成string
		/*
		 * 语法注释
		 * substring() 方法用于提取字符串中介于两个指定下标之间的字符。
		 * stringObject.substring(start,stop) : 返回的字符串，其内容是从 start 处到 stop-1 处的所有字符，其长度为 stop 减 start。
		 */
		String year = start.substring(0, start.indexOf("-"));  // 从例如“2016-07-04 23:15:53”形式的时间中提取年和月
		String month = start.substring(5, 7);
		String fileType = list.get(2).substring(0, 5);  // float型为5，bool型为4，double型为6 (长度)
		String tableName = fileType + "_" + year + month;
		String[] paramList = list.get(2).split(" ");
		String typeId = paramList[0].substring(5);  // float型为5，bool型为4，double型为6 （开始位置）
		String sqlStr = "select * from " + tableName + " where ID= '" + typeId+ "' and time between " + list.get(0) + " and "
				+ list.get(1) + ";";
		System.out.println(sqlStr);
		/*
		 * 输出value值
		 */
		return getJdbcTemplate().query(sqlStr,
				new ResultSetExtractor<List<String>>() {
					@Override
					public List<String> extractData(ResultSet rs)
							throws SQLException, DataAccessException {
						List<String> result = new ArrayList<>();
						while (rs.next()) {
							result.add((String) rs.getObject("value"));
						}
						return result;
					}

				});
	}
}
