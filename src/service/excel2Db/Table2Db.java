package service.excel2Db;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

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

		if (tableName.contains("bool") || tableName.contains("double")) {
			creatNewStateTableByName(tableName);
			String sql = "insert into " + tableName
					+ "(ID,pos,state,time,value) values(?,?,?,?,?);";
			getJdbcTemplate().batchUpdate(sql,
					new BatchPreparedStatementSetter() {

						@Override
						public void setValues(PreparedStatement ps, int i)
								throws SQLException {
							List<TableRow> list = table.getTableRows();
							ps.setString(1, list.get(i).getId());
							ps.setString(2, list.get(i).getPos());
							ps.setString(3, list.get(i).getState());
							ps.setString(4, list.get(i).getTime());
							ps.setString(5, list.get(i).getValue());
						}

						@Override
						public int getBatchSize() {
							return table.getTableRows().size();
						}
					});
		} else if (tableName.contains("float")) {
			creatNewFloatTableByName(tableName);
			String sql = "insert into " + tableName
					+ "(ID,pos,time,value) values(?,?,?,?);";
			getJdbcTemplate().batchUpdate(sql,
					new BatchPreparedStatementSetter() {

						@Override
						public void setValues(PreparedStatement ps, int i)
								throws SQLException {
							List<TableRow> list = table.getTableRows();
							ps.setString(1, list.get(i).getId());
							ps.setString(2, list.get(i).getPos());
							ps.setString(3, list.get(i).getTime());
							ps.setString(4, list.get(i).getValue());
						}

						@Override
						public int getBatchSize() {
							return table.getTableRows().size();
						}
					});
		}

	}

	/**
	 * 根据文件名新建表
	 */
	public void creatNewStateTableByName(String tableName) {
		String sql = "if not exists(select * from sysobjects where id = object_id('"
				+ tableName + "')) " + "begin create table " + tableName
				+ " (ID varchar(50) not null,pos varchar(150),state varchar(150),time varchar(150),value varchar(150));end";
		System.out.println(sql);
		getJdbcTemplate().update(sql);
	}

	public void creatNewFloatTableByName(String tableName) {
		String sql = "if not exists(select * from sysobjects where id = object_id('"
				+ tableName + "')) " + "begin create table " + tableName
				+ " (ID varchar(50) not null,pos varchar(150),time varchar(150),value varchar(150));end";
		System.out.println(sql);
		getJdbcTemplate().update(sql);
	}

	/**
	 * 存储上传文件信息保存到数据库表 upload_file_record
	 */

	public void saveFileToRecordTable(String filePath) {
		String tableName = filePath.substring(filePath.lastIndexOf("\\") + 1,
				filePath.lastIndexOf("."));
		String date = String.valueOf(TimeUtils.DatetoLong(new Date()));
		String insertRecordSql = "insert into upload_file_record(fileName,recordTime) values('"
				+ tableName + "','" + date + "')";
		System.out.println(insertRecordSql);
		getJdbcTemplate().execute(insertRecordSql);
	}

}
