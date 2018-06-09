package service.assess.transformer.one;

public class TransferAssResult {
	private double Temper1;
	private double History1;
	private double Fault1;
	private double AssSum1;
	public double getTemper1() {
		return Temper1;
	}
	public double getHistory1() {
		return History1;
	}
	public double getFault1() {
		return Fault1;
	}
	public double getAssSum1() {
		return AssSum1;
	}
	public void setTemper1(double temper1) {
		Temper1 = temper1;
	}
	public void setHistory1(double history1) {
		History1 = history1;
	}
	public void setFault1(double fault1) {
		Fault1 = fault1;
	}
	public void setAssSum1(double assSum1) {
		AssSum1 = assSum1;
	}
	
	public TransferAssResult(double temper1, double history1, double fault1, double assSum1) {
		super();
		Temper1 = temper1;
		History1 = history1;
		Fault1 = fault1;
		AssSum1 = assSum1;
	}
	

}
