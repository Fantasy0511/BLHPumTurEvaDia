package bll.LinearReg;

import java.util.Vector;

public class dataLine {
	
	private Vector<Double> x;
	private Vector<Double> y;
	
	public dataLine(Vector<Double> x, Vector<Double> y) {
		super();
		this.x = x;
		this.y = y;
	}
	public Vector<Double> getX() {
		return x;
	}
	public Vector<Double> getY() {
		return y;
	}
	
	
	
	
	
}
