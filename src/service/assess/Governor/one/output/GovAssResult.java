package service.assess.Governor.one.output;

import java.util.List;

/**
 * 调速器评估结果
 * 
 * @author wuyue
 *
 */
public class GovAssResult {
	private List<Number> govOilResult;
	private List<Number> govSingleResult;
	public double history;
	public double govSum;

	public GovAssResult(List<Number> govOilResult, List<Number> govSingleResult,
			double history, double govSum) {
		super();
		this.govOilResult = govOilResult;
		this.govSingleResult = govSingleResult;
		this.history = history;
		this.govSum = govSum;
	}

	public GovAssResult() {
		super();
	}

	public List<Number> getGovOilResult() {
		return govOilResult;
	}

	public void setGovOilResult(List<Number> govOilResult) {
		this.govOilResult = govOilResult;
	}

	public List<Number> getGovSingleResult() {
		return govSingleResult;
	}

	public void setGovSingleResult(List<Number> govSingleResult) {
		this.govSingleResult = govSingleResult;
	}

	public double getHistory() {
		return history;
	}

	public void setHistory(double history) {
		this.history = history;
	}

	public double getGovSum() {
		return govSum;
	}

	public void setGovSum(double govSum) {
		this.govSum = govSum;
	}

}
