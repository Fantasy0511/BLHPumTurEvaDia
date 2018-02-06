package tool.easyui;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;

/**
 * 表数据模型。
 * 
 * @author hx
 * 
 */
public class Table {
	public static final String NEWLINE = System.getProperty("line.separator");

	private List<StringRecord> rows = new ArrayList<StringRecord>();
	private String[] columnHeaders;

	public Table(String[] columnHeaders) {
		this.columnHeaders = columnHeaders;
	}

	public <T> Table(List<T> beans) {
		this(getConventionHeaders(beans));
		withBeanRow(beans);
	}

	private static <T> String[] getConventionHeaders(List<T> beans) {
		T t = beans.get(0);
		BeanPropertySqlParameterSource bpsps = new BeanPropertySqlParameterSource(
				t);
		String[] headers = bpsps.getReadablePropertyNames();
		return ArrayUtils.removeElement(headers, "class");
	}

	public Table withRow(Object... values) {
		if (columnHeaders.length == 0
				|| values.length != columnHeaders.length) {
			throw new IllegalArgumentException(
					"set headers first and make sure pass right record"
							+ "(right number and right order)");
		}
		StringRecord record = new StringRecord();
		for (int i = 0; i < columnHeaders.length; ++i) {
			Object value = values[i];
			if (null == value) {
				value = "";
			}
			record.withProperty(columnHeaders[i], value);
		}
		rows.add(record);
		return this;
	}

	public <T> Table withBeanRow(T bean) {
		BeanPropertySqlParameterSource bpsps = new BeanPropertySqlParameterSource(
				bean);
		Object[] obj = new Object[columnHeaders.length];
		for (int i = 0; i < obj.length; ++i) {
			obj[i] = bpsps.getValue(columnHeaders[i]);
		}
		return withRow(obj);
	}

	public <T> Table withBeanRow(List<T> beans) {
		for (T bean : beans) {
			withBeanRow(bean);
		}
		return this;
	}

	public int getRowsCount() {
		return rows.size();
	}

	public int getColumnsCount() {
		return columnHeaders.length;
	}

	public Object[] getRow(int index) {
		StringRecord sr = rows.get(index);
		int count = getColumnsCount();
		Object[] result = new Object[count];
		for (int i = 0; i < count; ++i) {
			result[i] = sr.get(columnHeaders[i]);
		}
		return result;
	}

	public List<StringRecord> getRows() {
		return rows;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(NEWLINE);
		appendLine(sb, count(columnHeaders, 10));
		for (String header : columnHeaders) {
			sb.append(header + "     ");
		}
		sb.append(NEWLINE);
		appendLine(sb, count(columnHeaders, 10));
		for (StringRecord record : rows) {
			sb.append(record);
		}
		appendLine(sb, count(columnHeaders, 10));
		return sb.toString();
	}

	private int count(String[] str, int extra) {
		int result = 0;
		for (String s : str) {
			result += s.length() + extra;
		}
		return result;
	}

	private void appendLine(StringBuilder sb, int count) {
		for (int i = 0; i < count; ++i) {
			sb.append("-");
		}
		sb.append(NEWLINE);
	}

}
