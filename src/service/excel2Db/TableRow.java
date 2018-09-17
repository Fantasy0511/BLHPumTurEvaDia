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
	private String FaultID;
	private String System;
	private String FaultName;
	private String FaultReason;
	private String StartTime;
	private String EndTime;
	private String WorkCondition;
	private String Parameters;
	private String faultLevel;
	
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
		if (list.size() == 8) {
			this.FaultID = list.get(0);
			this.System = list.get(1);
			this.FaultName = list.get(2);
			this.FaultReason = list.get(3);
			this.StartTime = list.get(4);
			this.EndTime = list.get(5);
			this.WorkCondition = list.get(6);
			this.Parameters = list.get(7);
			this.faultLevel = list.get(8);
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

	public TableRow(String faultID, String system, String faultName, String faultReason, String startTime,
			String endTime, String workCondition, String parameters, String faultLevel) {
		super();
		FaultID = faultID;
		System = system;
		FaultName = faultName;
		FaultReason = faultReason;
		StartTime = startTime;
		EndTime = endTime;
		WorkCondition = workCondition;
		Parameters = parameters;
		this.faultLevel = faultLevel;
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

	public String getFaultID() {
		return FaultID;
	}

	public String getSystem() {
		return System;
	}

	public String getFaultName() {
		return FaultName;
	}

	public String getFaultReason() {
		return FaultReason;
	}

	public String getStartTime() {
		return StartTime;
	}

	public String getEndTime() {
		return EndTime;
	}

	public String getWorkCondition() {
		return WorkCondition;
	}

	public String getParameters() {
		return Parameters;
	}

	public String getFaultLevel() {
		return faultLevel;
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

	public void setFaultID(String faultID) {
		FaultID = faultID;
	}

	public void setSystem(String system) {
		System = system;
	}

	public void setFaultName(String faultName) {
		FaultName = faultName;
	}

	public void setFaultReason(String faultReason) {
		FaultReason = faultReason;
	}

	public void setStartTime(String startTime) {
		StartTime = startTime;
	}

	public void setEndTime(String endTime) {
		EndTime = endTime;
	}

	public void setWorkCondition(String workCondition) {
		WorkCondition = workCondition;
	}

	public void setParameters(String parameters) {
		Parameters = parameters;
	}

	public void setFaultLevel(String faultLevel) {
		this.faultLevel = faultLevel;
	}
	
	
	


}
