package service.excel2Db;

import java.util.List;

public class FaultInfoTableRow {
	/*(Serial varchar(50) not null,FaultLevel varchar(150),Defect varchar(150),Team varchar(150),"
			+ "Reason varchar(150),Deal varchar(150),StartTime varchar(50),EndTime varchar(50),Remarks varchar(150));end";
	*/
	private String Serial;
	private String FaultLevel;
	private String Defect;
	private String Team;
	private String Reason;
	private String Deal;
	private String StartTime ;
	private String EndTime;
	private String Remarks;
	
	public FaultInfoTableRow(List<String> list) {
		super();
		this.Serial=list.get(0);
		this.FaultLevel=list.get(1);
		this.Defect=list.get(2);
		this.Team=list.get(3);
		this.Reason=list.get(4);
		this.Deal=list.get(5);
		this.StartTime=list.get(6);
		this.EndTime=list.get(7);
		this.Remarks=list.get(8);
		
	}

	public FaultInfoTableRow(String serial, String faultLevel, String defect, String team, String reason, String deal,
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
