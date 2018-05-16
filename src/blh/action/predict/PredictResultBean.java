package blh.action.predict;

/**
 * @author wuyue
 * 
 */
public class PredictResultBean {
	private String time;
	private double actual;
	private double predict;

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public double getActual() {
		return actual;
	}

	public void setActual(double actual) {
		this.actual = actual;
	}

	public double getPredict() {
		return predict;
	}

	public void setPredict(double predict) {
		this.predict = predict;
	}

	public PredictResultBean(String time, double actual, double predict) {
		super();
		this.time = time;
		this.actual = actual;
		this.predict = predict;
	}

}
