package service.assess.Ballvalve.one;

import java.util.List;

/**
 * 球阀状态评估结果
 * @author tiandiwei
 *
 */
public class BallAssessResult {
	
	private List<Number> oilSystem;
	private double history;
	private List<Number> performance;
	private double ballSum;
	
	public BallAssessResult(List<Number> oilSystem, double history, List<Number> performance, double ballSum) {
		super();
		this.oilSystem = oilSystem;
		this.history = history;
		this.performance = performance;
		this.ballSum = ballSum;
	}
	public List<Number> getOilSystem() {
		return oilSystem;
	}
	public void setOilSystem(List<Number> oilSystem) {
		this.oilSystem = oilSystem;
	}
	public double getHistory() {
		return history;
	}
	public void setHistory(double history) {
		this.history = history;
	}
	public List<Number> getPerformance() {
		return performance;
	}
	public void setPerformance(List<Number> performance) {
		this.performance = performance;
	}
	public double getBallSum() {
		return ballSum;
	}
	public void setBallSum(double ballSum) {
		this.ballSum = ballSum;
	}
	
	
	

}
