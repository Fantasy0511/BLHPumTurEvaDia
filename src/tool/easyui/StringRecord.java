package tool.easyui;

import java.util.Map;

/**
 * 表的一行记录。
 * 
 * @author hx
 * 
 */
public class StringRecord {
	private Record<String, Object> row;

	public StringRecord() {
		super();
		this.row = new Record<String, Object>();
	}

	public StringRecord withProperty(String columnName, Object value) {
		row.withName(columnName).withValue(value.toString()).addProperty();
		return this;
	}

	public StringRecord withProperty(String columnName) {
		row.withName(columnName).withValue("").addProperty();
		return this;
	}

	public Map<String, Object> addEnd() {
		return row.addEnd();
	}

	public final Record<String, Object> getRow() {
		return row;
	}

	public String get(String key) {
		return (String) row.get(key);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Object obj : row.getRow().values()) {
			sb.append(obj + "     ");
		}
		sb.append(Table.NEWLINE);
		return sb.toString();
	}
}
