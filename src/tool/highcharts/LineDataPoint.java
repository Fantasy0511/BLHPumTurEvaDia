package tool.highcharts;

/**
 * 折线图中的单个点。
 * 
 * @author 聂勇文
 *
 */
public class LineDataPoint {
	private double x;
	private double y;
	
	
	public LineDataPoint(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	
}
