package util;

/**
 * 故障样本utils
 */
public class FaultUtils {
	private int faultID;
	private String system;
	private long starttime;
	private long endtime;
	private String faultName;
	private String faultReason;
	private String workConditon;
	private String paramters;
	private String startTimeString; // long型的starttime转换的
	private String endTimeString; // long型的endtime转换的

	public FaultUtils(int faultID, String system, String faultName,
			String faultReanson, long starttime, long endtime,
			String workConditon, String paramters) {
		this.faultID = faultID;
		this.system = system;
		this.starttime = starttime;
		this.endtime = endtime;
		this.faultName = faultName;
		this.faultReason = faultReanson;
		this.workConditon = workConditon;
		this.paramters = paramters;
		this.startTimeString = TimeUtils.LongtoString(starttime);
		this.endTimeString = TimeUtils.LongtoString(endtime);
	}

	public int getFaultID() {
		return faultID;
	}

	public void setFaultID(int faultID) {
		this.faultID = faultID;
	}

	public String getSystem() {
		return system;
	}

	public void setSystem(String system) {
		this.system = system;
	}

	public long getStarttime() {
		return starttime;
	}

	public void setStarttime(long starttime) {
		this.starttime = starttime;
	}

	public long getEndtime() {
		return endtime;
	}

	public void setEndtime(long endtime) {
		this.endtime = endtime;
	}

	public String getFaultName() {
		return faultName;
	}

	public void setFaultName(String faultName) {
		this.faultName = faultName;
	}

	public String getFaultReason() {
		return faultReason;
	}

	public void setFaultReason(String faultReason) {
		this.faultReason = faultReason;
	}

	public String getParamters() {
		return paramters;
	}

	public void setParamters(String paramters) {
		this.paramters = paramters;
	}

	public String getWorkConditon() {
		return workConditon;
	}

	public void setWorkConditon(String workConditon) {
		this.workConditon = workConditon;
	}

	public String getStartTimeString() {
		return startTimeString;
	}

	public void setStartTimeString(String startTimeString) {
		this.startTimeString = startTimeString;
	}

	public String getEndTimeString() {
		return endTimeString;
	}

	public void setEndTimeString(String endTimeString) {
		this.endTimeString = endTimeString;
	}

}
