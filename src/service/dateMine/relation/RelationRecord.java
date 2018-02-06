package service.dateMine.relation;

/**
 * 为关联分析页面准备的表
 * 
 * @author wuyue 随着项目代码的变多，目录结构越来越乱
 */
public class RelationRecord {
	private String deviceType;
	private String deviceState;

	public RelationRecord(String deviceType, String deviceState) {
		super();
		this.deviceType = deviceType;
		this.deviceState = deviceState;
	}

	public RelationRecord() {
		super();
	}

	public String getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	public String getDeviceState() {
		return deviceState;
	}

	public void setDeviceState(String deviceState) {
		this.deviceState = deviceState;
	}

}
