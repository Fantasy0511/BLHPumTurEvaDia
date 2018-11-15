package vo;

public class DefectTableVo {
	
	/*private Integer faultID;
	private String Serial;
	private String FaultLevel;*/
	private String Defect;
	private String Team;
	private String Reason;
	private String Deal;
	private String StartTime ;
	private String EndTime;
	private String Remarks;
	
	
	public DefectTableVo() {
		super();
		
	}
	
	
	public DefectTableVo(String defect, String team, String reason, String deal, String startTime, String endTime,
			String remarks) {
		super();
		Defect = defect;
		Team = team;
		Reason = reason;
		Deal = deal;
		StartTime = startTime;
		EndTime = endTime;
		Remarks = remarks;
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
