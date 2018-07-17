package service.assess.Governor.three;

import java.util.List;

public class GovAssResultThree {
/**
 * 调速器三号机组状态评估
 *
 */
	private List<Number> SignalSum3;
	private List<Number> state3;
	private double history3;
	private double output3;
	public GovAssResultThree(List<Number> signalSum3, List<Number> state3, double history3, double output3) {
		super();
		SignalSum3 = signalSum3;
		this.state3 = state3;
		this.history3 = history3;
		this.output3 = output3;
	}
	public List<Number> getSignalSum3() {
		return SignalSum3;
	}
	public void setSignalSum3(List<Number> signalSum3) {
		SignalSum3 = signalSum3;
	}
	public List<Number> getState3() {
		return state3;
	}
	public void setState3(List<Number> state3) {
		this.state3 = state3;
	}
	public double getHistory3() {
		return history3;
	}
	public void setHistory3(double history3) {
		this.history3 = history3;
	}
	public double getOutput3() {
		return output3;
	}
	public void setOutput3(double output3) {
		this.output3 = output3;
	}
	
	

}
