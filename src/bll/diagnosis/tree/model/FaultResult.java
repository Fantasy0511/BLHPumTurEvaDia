package bll.diagnosis.tree.model;

import java.math.BigDecimal;

public class FaultResult extends Fault implements Comparable<FaultResult> {

	public FaultResult() {
		super();
	}

	Double probability;
	String conditionName;

	private static double ControlDigit(double input) {
		double result;
		BigDecimal b = new BigDecimal(input);

		result = b.setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue();

		return result;

	}

	public Double getProbability() {
		this.probability = ControlDigit(this.probability);
		return probability;
	}

	public void setProbability(Double probability) {
		this.probability = ControlDigit(probability);
	}

	public String getConditionName() {
		return conditionName;
	}

	public void setConditionName(String conditionName) {
		this.conditionName = conditionName;
	}

	@Override
	public int compareTo(FaultResult input) {
		return this.getProbability().compareTo(input.getProbability());
	}

	@Override
	public String toString() {
		return "FaultResult [probability=" + probability + ", conditionName="
				+ conditionName + "]";
	}

}
