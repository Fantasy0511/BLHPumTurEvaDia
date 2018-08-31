package bll.predict;

/**
 * 对数据库中读到的数据进行格式化,便于TendencyPredict直接调用
 * 
 * @author dragon
 * 
 */
public class PredictInput {
	private String[] time;
	private double[] data;
	private double[] Hlimite;

	

	public PredictInput(String[] time, double[] data, double[] hlimite) {
		super();
		this.time = time;
		this.data = data;
		Hlimite = hlimite;
	}

	public PredictInput(String[] time, double[] data) {
		super();
		this.time = time;
		this.data = data;
	}

	public double[] getHlimite() {
		return Hlimite;
	}

	public String[] getTime() {
		return time;
	}

	public double[] getData() {
		return data;
	}
}
