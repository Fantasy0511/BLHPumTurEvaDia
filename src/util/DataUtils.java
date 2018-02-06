package util;

import java.util.ArrayList;

/**
 * 数据存放基本类
 * @author lh
 * */
public class DataUtils {
	private ArrayList<Long> time;
	private ArrayList<Double> value;
	private int id;
	private String type;
	
	public DataUtils(ArrayList<Long> time, ArrayList<Double> value, int id, String type){
		this.setTime(time);
		this.setValue(value);
		this.setId(id);
		this.setType(type);
	}
	public DataUtils(String type,int id){
		this.setTime(new ArrayList<Long>());
		this.setValue(new ArrayList<Double>());
		this.setId(id);
		this.setType(type);
	}
	
	
	public void addTime(Long x){
		this.getTime().add(x);
	}
	
	public void addValue(Double y){
		this.getValue().add(y);
	}
	
	public ArrayList<Long> getTime() {
		return time;
	}

	public void setTime(ArrayList<Long> time) {
		this.time = time;
	}

	public ArrayList<Double> getValue() {
		return value;
	}

	public void setValue(ArrayList<Double> value) {
		this.value = value;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}
