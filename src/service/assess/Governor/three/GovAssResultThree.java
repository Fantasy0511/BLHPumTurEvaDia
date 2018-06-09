package service.assess.Governor.three;

public class GovAssResultThree {
/**
 * 调速器三号机组状态评估
 *
 */
	private double SignalSum3;
	private double state3;
	private double history3;
	private double output3;
	public double getSignalSum3() {
		return SignalSum3;
	}
	public double getState3() {
		return state3;
	}
	public double getHistory3() {
		return history3;
	}
	public double getOutput3() {
		return output3;
	}
	public void setSignalSum3(double signalSum3) {
		SignalSum3 = signalSum3;
	}
	public void setState3(double state3) {
		this.state3 = state3;
	}
	public void setHistory3(double history3) {
		this.history3 = history3;
	}
	public void setOutput3(double output3) {
		this.output3 = output3;
	}
	
	public GovAssResultThree(double signalSum3, double state3, double history3, double output3) {
		super();
		SignalSum3 = signalSum3;
		this.state3 = state3;
		this.history3 = history3;
		this.output3 = output3;
	}
	
	

}
