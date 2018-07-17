package service.assess.transformer;

import java.util.List;
/**
 * 主变一层指标和底层数据封装
 * @author tiandiwei
 *
 */
public class TransferAssResult {
	
	private List<Number>  firstIndicator;  //一层指标获取
	private List<Number>  transTemperIndicator;  //主变温度底层指标
	private List<Number>  faultIndicator;  //故障信号底层指标
	
	
	public TransferAssResult(List<Number> firstIndicator, List<Number> transTemperIndicator,
			List<Number> faultIndicator) {
		super();
		this.firstIndicator = firstIndicator;
		this.transTemperIndicator = transTemperIndicator;
		this.faultIndicator = faultIndicator;
	}
	public List<Number> getFirstIndicator() {
		return firstIndicator;
	}
	public List<Number> getTransTemperIndicator() {
		return transTemperIndicator;
	}
	public List<Number> getFaultIndicator() {
		return faultIndicator;
	}
	public void setFirstIndicator(List<Number> firstIndicator) {
		this.firstIndicator = firstIndicator;
	}
	public void setTransTemperIndicator(List<Number> transTemperIndicator) {
		this.transTemperIndicator = transTemperIndicator;
	}
	public void setFaultIndicator(List<Number> faultIndicator) {
		this.faultIndicator = faultIndicator;
	}
	
	
	
	

}
