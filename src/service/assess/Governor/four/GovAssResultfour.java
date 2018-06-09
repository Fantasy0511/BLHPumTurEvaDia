package service.assess.Governor.four;

public class GovAssResultfour {
/**
 * 调速器四号机组状态评估
 *
 */
	private double SignalSum4;
	private double state;
	private double history;
	private double output;
	
	public GovAssResultfour(double signalSum4, double state, double history, double output) {
		super();
		SignalSum4 = signalSum4;
		this.state = state;
		this.history = history;
		this.output = output;
	}
	public double getSignalSum4() {
		return SignalSum4;
	}
	public double getState() {
		return state;
	}
	public double getHistory() {
		return history;
	}
	public double getOutput() {
		return output;
	}
	public void setSignalSum4(double signalSum4) {
		SignalSum4 = signalSum4;
	}
	public void setState(double state) {
		this.state = state;
	}
	public void setHistory(double history) {
		this.history = history;
	}
	public void setOutput(double output) {
		this.output = output;
	}
	
	

}
