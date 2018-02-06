package dao.nn;

/**
 * 在FaultInfoTable种查找需要信息
 * 
 * @author wuyue
 *
 */
public class FaultInfo {
	private Long startTime;
	private long endTime;
	private String parameters;

	public FaultInfo() {
		super();
	}

	public FaultInfo(Long startTime, long endTime, String parameters) {
		super();
		this.startTime = startTime;
		this.endTime = endTime;
		this.parameters = parameters;
	}

	public Long getStartTime() {
		return startTime;
	}

	public void setStartTime(Long startTime) {
		this.startTime = startTime;
	}

	public long getEndTime() {
		return endTime;
	}

	public void setEndTime(long endTime) {
		this.endTime = endTime;
	}

	public String getParameters() {
		return parameters;
	}

	public void setParameters(String parameters) {
		this.parameters = parameters;
	}

}
