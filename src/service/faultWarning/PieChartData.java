package service.faultWarning;


public class PieChartData {
	private String  faultName;
	private Double faultChance;
	
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
	public PieChartData(String faultName, Double faultChance) {
		super();
		this.faultName = faultName;
		this.faultChance = faultChance;
	}
	
	
	
	

	

}
