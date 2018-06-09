package service.assess.Governor.two;

public class GovAssResultTwo {
/**
 * 调速器四号机组状态评估
 *
 */
	private double SignalSum2;
	private double state2;
	private double history2;
	private double output2;
	public double getSignalSum2() {
		return SignalSum2;
	}
	public double getState2() {
		return state2;
	}
	public double getHistory2() {
		return history2;
	}
	public double getOutput2() {
		return output2;
	}
	public void setSignalSum2(double signalSum2) {
		SignalSum2 = signalSum2;
	}
	public void setState2(double state2) {
		this.state2 = state2;
	}
	public void setHistory2(double history2) {
		this.history2 = history2;
	}
	public void setOutput2(double output2) {
		this.output2 = output2;
	}
	public GovAssResultTwo(double signalSum2, double state2, double history2, double output2) {
		super();
		SignalSum2 = signalSum2;
		this.state2 = state2;
		this.history2 = history2;
		this.output2 = output2;
	}
	
	

}
