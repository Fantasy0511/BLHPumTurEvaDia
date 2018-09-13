package service.faultWarning;

import java.util.List;

import service.faultWarning.Result.WarnningResult;
import service.faultWarning.Result.faultParaData;

/**
 * 预警结果输出
 * @author tiandiwei
 *
 */
public class warnResultData {
	
	private WarnningResult  pro_systems;
	private faultParaData  faultparameter;
	private WarnningResult  pro_fault;
	public warnResultData(WarnningResult pro_systems, faultParaData faultparameter, WarnningResult pro_fault) {
		super();
		this.pro_systems = pro_systems;
		this.faultparameter = faultparameter;
		this.pro_fault = pro_fault;
	}
	public WarnningResult getPro_systems() {
		return pro_systems;
	}
	public faultParaData getFaultparameter() {
		return faultparameter;
	}
	public WarnningResult getPro_fault() {
		return pro_fault;
	}
	public void setPro_systems(WarnningResult pro_systems) {
		this.pro_systems = pro_systems;
	}
	public void setFaultparameter(faultParaData faultparameter) {
		this.faultparameter = faultparameter;
	}
	public void setPro_fault(WarnningResult pro_fault) {
		this.pro_fault = pro_fault;
	}
	
	
}
