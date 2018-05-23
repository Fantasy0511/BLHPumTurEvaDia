package service.assess.transformer.one;

public class TransferAssResult {
	private double transTemper;
	private double transHistory;
	private double transFault;
	private double transAssSum;
	
	public TransferAssResult(double transTemper, double transHistory, double transFault, double transAssSum) {
		super();
		this.transTemper = transTemper;
		this.transHistory = transHistory;
		this.transFault = transFault;
		this.transAssSum = transAssSum;
	}
	public double getTransTemper() {
		return transTemper;
	}
	public double getTransHistory() {
		return transHistory;
	}
	public double getTransFault() {
		return transFault;
	}
	public double getTransAssSum() {
		return transAssSum;
	}
	public void setTransTemper(double transTemper) {
		this.transTemper = transTemper;
	}
	public void setTransHistory(double transHistory) {
		this.transHistory = transHistory;
	}
	public void setTransFault(double transFault) {
		this.transFault = transFault;
	}
	public void setTransAssSum(double transAssSum) {
		this.transAssSum = transAssSum;
	}

}
