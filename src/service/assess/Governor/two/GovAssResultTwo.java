package service.assess.Governor.two;

import java.util.List;

public class GovAssResultTwo {
/**
 * 调速器二号机组状态评估
 *
 */
	private List<Number> SignalSum2;
	private List<Number> state2;
	private double history2;
	private double output2;
	
	public GovAssResultTwo(List<Number> signalSum2, List<Number> state2, double history2, double output2) {
		super();
		SignalSum2 = signalSum2;
		this.state2 = state2;
		this.history2 = history2;
		this.output2 = output2;
	}
	public List<Number> getSignalSum2() {
		return SignalSum2;
	}
	public void setSignalSum2(List<Number> signalSum2) {
		SignalSum2 = signalSum2;
	}
	public List<Number> getState2() {
		return state2;
	}
	public void setState2(List<Number> state2) {
		this.state2 = state2;
	}
	public double getHistory2() {
		return history2;
	}
	public void setHistory2(double history2) {
		this.history2 = history2;
	}
	public double getOutput2() {
		return output2;
	}
	public void setOutput2(double output2) {
		this.output2 = output2;
	}
	
	

}
