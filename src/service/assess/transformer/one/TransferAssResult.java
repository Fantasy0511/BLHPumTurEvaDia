package service.assess.transformer.one;

public class TransferAssResult {
	private double Temper;
	private double History;
	private double Fault;
	private double AssSum;
	public double getTemper() {
		return Temper;
	}
	public double getHistory() {
		return History;
	}
	public double getFault() {
		return Fault;
	}
	public double getAssSum() {
		return AssSum;
	}
	public void setTemper(double temper) {
		Temper = temper;
	}
	public void setHistory(double history) {
		History = history;
	}
	public void setFault(double fault) {
		Fault = fault;
	}
	public void setAssSum(double assSum) {
		AssSum = assSum;
	}
	public TransferAssResult(double temper, double history, double fault, double assSum) {
		super();
		Temper = temper;
		History = history;
		Fault = fault;
		AssSum = assSum;
	}
	
	

}
