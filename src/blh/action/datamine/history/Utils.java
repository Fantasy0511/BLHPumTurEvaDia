package blh.action.datamine.history;

import java.util.ArrayList;

/**
 * 历史查询返回前端数据
 * @author tiandiwei
 *
 */

public class Utils {
	private ArrayList<String> time;
	private ArrayList<Double> value;
	private int id;
	private String type;
	private String decription;
	private String unit;
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
	public String getDecription() {
		return decription;
	}
	public String getUnit() {
		return unit;
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
	public void setDecription(String decription) {
		this.decription = decription;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public Utils(ArrayList<String> time, ArrayList<Double> value, int id, String type, String decription, String unit) {
		super();
		this.time = time;
		this.value = value;
		this.id = id;
		this.type = type;
		this.decription = decription;
		this.unit = unit;
	}
	
	
}
