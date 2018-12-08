package service.excel2Db;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;

import util.TimeUtils;
import util.dao.JdbcDaoUtil;

/**
 * 保存table到数据库 1、新建 2、保存
 * 
 * @author wuyue
 *
 */
public class Table2Db extends JdbcDaoUtil {
	/**
	 * 将table对象实例，存在数据库对应的表中,每个table实例代表一张表
	 */
	public void saveTableToDb(Table table) {
		String tableName = table.getTableName();
		List<TableRow> list = table.getTableRows();
		// 新建bool和double表
		if (tableName.contains("bool") || tableName.contains("double")) {
			creatNewStateTableByName(tableName);
			String sql = "insert into " + tableName + "(ID,pos,state,time,value) values(?,?,?,?,?);";
			getJdbcTemplate().batchUpdate(sql, new BatchPreparedStatementSetter() {
				@Override
				public void setValues(PreparedStatement ps, int i) throws SQLException {
					ps.setString(1, list.get(i).getId());
					ps.setString(2, list.get(i).getPos());
					ps.setString(3, list.get(i).getState());           
					ps.setString(4, list.get(i).getTime());
					ps.setString(5, list.get(i).getValue());
				}
				@Override
				public int getBatchSize() {
					return (int)table.getTableRows().size()/10;
				}
			});
		}
		// 新建float表
		if (tableName.contains("float")) {
			creatNewFloatTableByName(tableName);
			String sql = "insert into " + tableName + "(ID,pos,time,value) values(?,?,?,?);";
			getJdbcTemplate().batchUpdate(sql, new BatchPreparedStatementSetter() {
				@Override
				public void setValues(PreparedStatement ps, int i) throws SQLException {
					ps.setString(1, list.get(i).getId());
					ps.setString(2, list.get(i).getPos());
					ps.setString(3, list.get(i).getTime());
					ps.setString(4, list.get(i).getValue());
				}

				@Override
				public int getBatchSize() {
					return (int)table.getTableRows().size()/1000;
				}

			});
		}

		// 缺陷月度情况表中添加数据
		if (tableName.contains("缺陷月度情况表")) {
			/*creatNewFaultInfoTable(tableName);*/
			String insertSql = "insert into " + tableName + " (Serial,FaultLevel,Defect,Team,Reason,Deal,StartTime,EndTime,Remarks) values"
					+ "(?,?,?,?,?,?,?,?,?);";
			System.out.println(insertSql);
			getJdbcTemplate().batchUpdate(insertSql, new BatchPreparedStatementSetter() {
				@Override
				public void setValues(PreparedStatement ps, int i) throws SQLException {
					List<TableRow> list = table.getTableRows();
					ps.setString(1, list.get(i).getSerial());
					ps.setString(2, list.get(i).getFaultLevel());
					ps.setString(3, list.get(i).getDefect());
					ps.setString(4, list.get(i).getTeam());
					ps.setString(5, list.get(i).getReason());
					ps.setString(6, list.get(i).getDeal());
					/*ps.setString(7, String.valueOf(TimeUtils.StringtoLong2(list.get(i).getStartTime())));*/
					ps.setString(7, list.get(i).getStartTime());
					ps.setString(8, list.get(i).getEndTime());
					ps.setString(9, list.get(i).getRemarks());
				}
				@Override
				public int getBatchSize() {
					return table.getTableRows().size();
				}

			});
		}

	}

	/**
	 * 根据文件名新建表，文件名如果有"bool"或者"double"
	 */
	public void creatNewStateTableByName(String tableName) {
		String sql = "if not exists(select * from sysobjects where id = object_id('" + tableName + "')) "
				+ "begin create table " + tableName
				+ " (ID varchar(50) not null,pos varchar(150),state varchar(150),time varchar(150),value varchar(150));end";
		System.out.println(sql);
		getJdbcTemplate().update(sql);
	}
	
	/**
	 * 根据文件名新建表，文件名如果有"float"
	 */
	public void creatNewFloatTableByName(String tableName) {
		String sql = "if not exists(select * from sysobjects where id = object_id('" + tableName + "')) "
				+ "begin create table " + tableName
				+ " (ID varchar(50) not null,pos varchar(150),time varchar(150),value varchar(150));end";
		System.out.println(sql);
		getJdbcTemplate().update(sql);
	}

	/**
	 * 根据电站阅读缺陷表，新建故障特征表
	 * @param tableName
	 */
	public void creatNewFaultInfoTable(String tableName) {
		String sql = "if not exists(select * from sysobjects where id = object_id('" + tableName + "')) "
				+ "begin create table " + tableName + " (Serial varchar(50) not null , FaultLevel varchar(150),Defect varchar(250),Team varchar(150),"
				+ " Reason varchar(250),Deal varchar(500),StartTime varchar(50),EndTime varchar(50),Remarks varchar(150));end";
		System.out.println(sql);
		getJdbcTemplate().update(sql);
	}
	
	
	/**
	 * 存储上传文件信息保存到数据库表 upload_file_record
	 */

	public String saveFileToRecordTable(String filePath,String fileTimeValue) {
		//String tableName = filePath.substring(filePath.lastIndexOf("\\") + 1, filePath.lastIndexOf("."));
		String tableName=filePath;
		String date = String.valueOf(TimeUtils.DatetoLong(new Date())); // 获取当前时间,录入表中的时候还是long型
		String insertRecordSql = "insert into upload_file_record(fileName,recordTime,fileTimeValue) values('"+tableName+" ','"+ date+" ','"+fileTimeValue+"')";
		System.out.println(insertRecordSql);
		try {
			getJdbcTemplate().execute(insertRecordSql);
			return "0";
		} catch (DataAccessException e) {
			SQLException exception = (SQLException)e.getCause();
		    // 通过exception获取ErrorCode、Message等信息
			System.out.println(exception.getMessage());
			return "1";
		}
		
	}

	/**
	 * 存储上传文件信息保存到数据库表 table_test 用作评估
	 */
	/*
	 * public void saveTable2TestTable(String tableName) { String testTableName =
	 * tableName + "_test"; int[] ids = { 223, 245, 250 }; String sql = ""; for (int
	 * id : ids) { sql = sql + createSqlString(tableName, id); } if
	 * (tableName.contains("bool")) {
	 * 
	 * creatNewStateTableByName(testTableName);
	 * 
	 * System.out.println(sql); getJdbcTemplate().batchUpdate(sql); } else {
	 * creatNewFloatTableByName(testTableName); getJdbcTemplate().batchUpdate(sql);
	 * } }
	 */
	// 拼接数据库语句
	/*
	 * public String createSqlString(String tableName, int id) { String
	 * testTableName = tableName + "_test"; if (tableName.contains("bool")) { return
	 * "insert into " + testTableName + "(ID,pos,state,time,value) select * from " +
	 * tableName + " WHERE ID=" + id + ";"; } else { return "insert into " +
	 * testTableName + "(ID,pos,time,value) select * from " + tableName +
	 * " WHERE ID=" + id + ";"; }
	 * 
	 * }
	 */
}
