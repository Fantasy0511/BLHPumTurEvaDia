package tool.highcharts;

import java.util.ArrayList;
import java.util.List;

/**
 * 饼图和柱状图的单项数据。
 * 
 * @author 刘涵
 *
 */
public class CategoryDataPoint {
	private String name;
	private double num;

	public CategoryDataPoint(String name, double num) {
		super();
		this.name = name;
		this.num = num;
	}

	public static List<CategoryDataPoint> create(List<String> nameList,
			List<Double> numberList) {
		List<CategoryDataPoint> data = new ArrayList<CategoryDataPoint>();
		for (int i = 0; i < nameList.size(); ++i) {
			data.add(new CategoryDataPoint(nameList.get(i), numberList.get(i)));
		}
		return data;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getNum() {
		return num;
	}

	public void setNum(double num) {
		this.num = num;
	}
}