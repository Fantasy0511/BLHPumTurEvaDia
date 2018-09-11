package service.faultWarning.Result;

import tool.easyui.Table;
import tool.highcharts.BarData;
/**
 * 封装柱状图数据和表格填充数据
 * @author tiandiwei
 *
 */
public class WarnningFinal {
	private Table ParameterWarn;
	private Table similarFault;
	private BarData systemBar;
	
	
	public WarnningFinal(Table parameterWarn, Table similarFault, BarData systemBar) {
		super();
		ParameterWarn = parameterWarn;
		this.similarFault = similarFault;
		this.systemBar = systemBar;
	}
	public Table getParameterWarn() {
		return ParameterWarn;
	}
	public Table getSimilarFault() {
		return similarFault;
	}
	public BarData getSystemBar() {
		return systemBar;
	}
	public void setParameterWarn(Table parameterWarn) {
		ParameterWarn = parameterWarn;
	}
	public void setSimilarFault(Table similarFault) {
		this.similarFault = similarFault;
	}
	public void setSystemBar(BarData systemBar) {
		this.systemBar = systemBar;
	}
	
	
	

	
	
}
