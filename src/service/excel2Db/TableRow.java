package service.excel2Db;

import java.util.List;

// 表的每一行
public class TableRow {
	private String id;
	private String pos;
	private String state;
	private String time;
	private String value;

	public TableRow() {
		super();
	}

	public TableRow(List<String> list) {
		super();
		if (list.size() == 5) {
			this.id = list.get(0);
			this.pos = list.get(1);
			this.state = list.get(2);
			this.time = list.get(3);
			this.value = list.get(4);
		} else if (list.size() == 4) {
			this.id = list.get(0);
			this.pos = list.get(1);
			this.time = list.get(2);
			this.value = list.get(3);
		}

	}

	public TableRow(String id, String pos, String state, String time, String value) {
		super();
		this.id = id;
		this.pos = pos;
		this.state = state;
		this.time = time;
		this.value = value;
	}

	public TableRow(String id, String pos, String time, String value) {
		super();
		this.id = id;
		this.pos = pos;
		this.time = time;
		this.value = value;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPos() {
		return pos;
	}

	public void setPos(String pos) {
		this.pos = pos;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
