package service.excel2Db;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;

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
		creatNewTableByName(tableName);
		
		String sql = "insert into " + tableName
				+ "(ID,pos,state,time,value) values(?,?,?,?,?);";
		getJdbcTemplate().batchUpdate(sql, new BatchPreparedStatementSetter() {

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
	}

	/**
	 * 根据文件名新建表
	 */
	public void creatNewTableByName(String tableName) {
		String sql = "if not exists(select * from sysobjects where id = object_id('"
				+ tableName + "')) " + "begin create table " + tableName
				+ " (ID varchar(50) not null,pos varchar(150),state varchar(150),time varchar(150),value varchar(150));end";
		System.out.println(sql);
		getJdbcTemplate().update(sql);
	}
}
