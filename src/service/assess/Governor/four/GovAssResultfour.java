package service.assess.Governor.four;

import java.util.List;

public class GovAssResultfour {
/**
 * 调速器四号机组状态评估
 *
 */
	private List<Number> SignalSum4;
	private List<Number> state;
	private double history;
	private double output;
	public GovAssResultfour(List<Number> signalSum4, List<Number> state, double history, double output) {
		super();
		SignalSum4 = signalSum4;
		this.state = state;
		this.history = history;
		this.output = output;
	}
	public List<Number> getSignalSum4() {
		return SignalSum4;
	}
	public void setSignalSum4(List<Number> signalSum4) {
		SignalSum4 = signalSum4;
	}
	public List<Number> getState() {
		return state;
	}
	public void setState(List<Number> state) {
		this.state = state;
	}
	public double getHistory() {
		return history;
	}
	public void setHistory(double history) {
		this.history = history;
	}
	public double getOutput() {
		return output;
	}
	public void setOutput(double output) {
		this.output = output;
	}
	
	
	

}
