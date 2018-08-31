package bll.LinearReg;

public class RegressionBean {
	
	
	/* 误差 */
	private double sse;
	/*系数a0 */
	private double a;
	/*系数a1 */
	private double b;
	
	public double getSse() {
		return sse;
	}
	public double getA() {
		return a;
	}
	public double getB() {
		return b;
	}
	
	public RegressionBean(double sse, double a, double b) {
		super();
		this.sse = sse;
		this.a = a;
		this.b = b;
	}
	
	

	
	
}
