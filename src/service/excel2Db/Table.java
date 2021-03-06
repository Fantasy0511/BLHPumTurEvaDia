package service.excel2Db;

import java.util.List;

/**
 * 数据库表对应的类
 * 
 * @author wuyue
 *
 */
public class Table {
	private String tableName;
	private String fileTimeValue;
	private List<TableRow> tableRows;

	public Table() {
		super();
	}
	public Table(String tableName, String fileTimeValue, List<TableRow> tableRows) {
		super();
		this.tableName = tableName;
		this.fileTimeValue = fileTimeValue;
		this.tableRows = tableRows;
	}

	public Table(String tableName, List<TableRow> tableRows) {
		super();
		this.tableName = tableName;
		this.tableRows = tableRows;
	}
	
	public String getFileTimeValue() {
		return fileTimeValue;
	}

	public void setFileTimeValue(String fileTimeValue) {
		this.fileTimeValue = fileTimeValue;
	}
	

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public List<TableRow> getTableRows() {
		return tableRows;
	}

	public void setTableRows(List<TableRow> tableRows) {
		this.tableRows = tableRows;
	}

}
