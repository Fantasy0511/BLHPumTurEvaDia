package service.assess.Ballvalve.one;
/**
 * 球阀状态评估结果
 * @author tiandiwei
 *
 */
public class BallAssessResult {
	
	private double oilSystem;
	private double history;
	private double performance;
	private double ballSum;
	
	public BallAssessResult(double oilSystem, double history, double performance, double ballSum) {
		super();
		this.oilSystem = oilSystem;
		this.history = history;
		this.performance = performance;
		this.ballSum = ballSum;
	}
	public double getOilSystem() {
		return oilSystem;
	}
	public double getHistory() {
		return history;
	}
	public double getPerformance() {
		return performance;
	}
	public double getBallSum() {
		return ballSum;
	}
	public void setOilSystem(double oilSystem) {
		this.oilSystem = oilSystem;
	}
	public void setHistory(double history) {
		this.history = history;
	}
	public void setPerformance(double performance) {
		this.performance = performance;
	}
	public void setBallSum(double ballSum) {
		this.ballSum = ballSum;
	}
	
	
	

}
