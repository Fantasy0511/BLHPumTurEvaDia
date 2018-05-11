package service.faultWarning;

public class PieChartData {
	private String faultName;
	private Double faultChance;

	public PieChartData(String string, double d) {
		
	}

	public String getFaultName() {
		return faultName;
	}

	public Double getFaultChance() {
		return faultChance;
	}

	public void setFaultName(String faultName) {
		this.faultName = faultName;
	}

	public void setFaultChance(Double faultChance) {
		this.faultChance = faultChance;
	}

	@Override
	public String toString() {
		return "[" + faultName + ", " + faultChance + "]";
	}
}
