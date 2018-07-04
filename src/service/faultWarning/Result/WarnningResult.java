package service.faultWarning.Result;


import java.util.List;

/**
 * 故障预警结果数据类型封装
 * @author tiandiwei
 *
 */
public class WarnningResult {
	
	
	private List<String>  faultName; //故障名称
	private List<Double> faultRate;//故障概率
	
	public WarnningResult(List<String> faultName, List<Double> faultRate) {
		super();
		this.faultName = faultName;
		this.faultRate = faultRate;
	}
	public List<String> getFaultName() {
		return faultName;
	}
	public List<Double> getFaultRate() {
		return faultRate;
	}
	public void setFaultName(List<String> faultName) {
		this.faultName = faultName;
	}
	public void setFaultRate(List<Double> faultRate) {
		this.faultRate = faultRate;
	}
	
	
	
}
