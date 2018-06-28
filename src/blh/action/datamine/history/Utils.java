package blh.action.datamine.history;

import java.util.ArrayList;

public class Utils {
	private ArrayList<String> time;
	private ArrayList<Double> value;
	private int id;
	private String type;
	public Utils(ArrayList<String> time, ArrayList<Double> value, int id, String type) {
		super();
		this.time = time;
		this.value = value;
		this.id = id;
		this.type = type;
	}
	public ArrayList<String> getTime() {
		return time;
	}
	public ArrayList<Double> getValue() {
		return value;
	}
	public int getId() {
		return id;
	}
	public String getType() {
		return type;
	}
	public void setTime(ArrayList<String> time) {
		this.time = time;
	}
	public void setValue(ArrayList<Double> value) {
		this.value = value;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}
