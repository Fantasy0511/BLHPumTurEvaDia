package service.faultWarning.Result;

import java.util.List;
import util.FaultUtils;
/**
 * 故障预警结果
 * @author tiandiwei
 *
 */
public class WarnningResult {
	
	
	private List<String>  system; //子系统
	private List<String> faultName;//故障名称
	private List<Double> warnResult; //当前故障概率
	
	public List<String> getSystem() {
		return system;
	}
	public List<String> getFaultName() {
		return faultName;
	}
	public List<Double> getWarnResult() {
		return warnResult;
	}
	public void setSystem(List<String> system) {
		this.system = system;
	}
	public void setFaultName(List<String> faultName) {
		this.faultName = faultName;
	}
	public void setWarnResult(List<Double> warnResult) {
		this.warnResult = warnResult;
	}
	
	public WarnningResult(List<String> system, List<String> faultName, List<Double> warnResult) {
		super();
		this.system = system;
		this.faultName = faultName;
		this.warnResult = warnResult;
	}
	
	
}
