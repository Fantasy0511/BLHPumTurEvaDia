package tool.exception;

import java.sql.SQLException;

import util.TimeUtils;

/*
 * 判断输入的时间是否是数据库中有的数据  by jtl
 *   有的话，显示：“查询数据库成功”
 *   没有的话，显示：“数据库中没有该时间”
 * */

public class JudgeTime {
	private String result;

	public String judgeTime(String time) throws ClassNotFoundException, SQLException {
		
		Long endtime = TimeUtils.StringtoLong(time);
		JudgeTimeFromDatabase jt = new JudgeTimeFromDatabase();
		result = jt.queFloat(endtime);

		return result;

	}
}
