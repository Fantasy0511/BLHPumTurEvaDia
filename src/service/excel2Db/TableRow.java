package service.excel2Db;

import java.util.List;
/**
 * 三种表格数据类型 (bool  double)、(float)、(FaultInfoTable)   
 * @author tiandiwei
 *
 */
// 表的每一行
public class TableRow {
	//bool、double、float
	private String id;
	private String pos;
	private String state;
	private String time;
	private String value;
	
	//faultInfoTable
	private String Serial;
	private String FaultLevel;
	private String Defect;
	private String Team;
	private String Reason;
	private String Deal;
	private String StartTime ;
	private String EndTime;
	private String Remarks;
	
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
		}  
		if (list.size() == 4) {
			this.id = list.get(0);
			this.pos = list.get(1);
			this.time = list.get(2);
			this.value = list.get(3);
		}
		if (list.size() == 9) {
			this.Serial = list.get(0);
			this.FaultLevel = list.get(1);
			this.Defect = list.get(2);
			this.Team = list.get(3);
			this.Reason = list.get(4);
			this.Deal = list.get(5);
			this.StartTime = list.get(6);
			this.EndTime = list.get(7);
			this.Remarks = list.get(8);
		}
	}

	//bool和double表
	public TableRow(String id, String pos, String state, String time, String value) {
		super();
		this.id = id;
		this.pos = pos;
		this.state = state;
		this.time = time;
		this.value = value;
	}
	//float表
	public TableRow(String id, String pos, String time, String value) {
		super();
		this.id = id;
		this.pos = pos;
		this.time = time;
		this.value = value;
	}
	//电站设备缺陷表

	public TableRow(String serial, String faultLevel, String defect, String team, String reason, String deal,
			String startTime, String endTime, String remarks) {
		super();
		Serial = serial;
		FaultLevel = faultLevel;
		Defect = defect;
		Team = team;
		Reason = reason;
		Deal = deal;
		StartTime = startTime;
		EndTime = endTime;
		Remarks = remarks;
	}

	public String getId() {
		return id;
	}

	public String getPos() {
		return pos;
	}

	public String getState() {
		return state;
	}

	public String getTime() {
		return time;
	}

	public String getValue() {
		return value;
	}

	public String getSerial() {
		return Serial;
	}

	public String getFaultLevel() {
		return FaultLevel;
	}

	public String getDefect() {
		return Defect;
	}

	public String getTeam() {
		return Team;
	}

	public String getReason() {
		return Reason;
	}

	public String getDeal() {
		return Deal;
	}

	public String getStartTime() {
		return StartTime;
	}

	public String getEndTime() {
		return EndTime;
	}

	public String getRemarks() {
		return Remarks;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setPos(String pos) {
		this.pos = pos;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public void setSerial(String serial) {
		Serial = serial;
	}

	public void setFaultLevel(String faultLevel) {
		FaultLevel = faultLevel;
	}

	public void setDefect(String defect) {
		Defect = defect;
	}

	public void setTeam(String team) {
		Team = team;
	}

	public void setReason(String reason) {
		Reason = reason;
	}

	public void setDeal(String deal) {
		Deal = deal;
	}

	public void setStartTime(String startTime) {
		StartTime = startTime;
	}

	public void setEndTime(String endTime) {
		EndTime = endTime;
	}

	public void setRemarks(String remarks) {
		Remarks = remarks;
	}



}
