package tool.highcharts;

import java.util.ArrayList;
import java.util.List;

import util.LangUtil;

/**
 * 饼图数据模型。
 * 
 * @author 刘涵
 * @author hx(修改为适合转换成json数据的格式)
 *
 */
public class BarData {
	private String title;
	private String subtitle;
	private String[] categories;
	private String yLabel;// 标题，副标题，横坐标，纵坐标
	private String seriesName;
	private double[] seriesValue;

	private String type = "bar";

	public BarData() {
		super();
	}

	public BarData(String title, String subtitle, String[] categories,
			String yLabel, String seriesName, double[] seriesValue) {
		super();
		this.title = title;
		this.subtitle = subtitle;
		this.categories = categories;
		this.yLabel = yLabel;
		this.seriesName = seriesName;
		this.seriesValue = seriesValue;
	}

	public static BarData create(String title, String subtitle, String xName,
			String yName, List<CategoryDataPoint> nameDataList) {
		List<String> item = new ArrayList<String>();
		List<Double> value = new ArrayList<Double>();
		for (CategoryDataPoint nd : nameDataList) {
			item.add(nd.getName());
			value.add(nd.getNum());
		}
		return create(title, subtitle, xName, yName, item, value);
	}

	public static BarData create(String title, String subtitle, String xName,
			String yName, List<String> item, List<Double> value) {// 工厂方法
		String seriesName = xName;
		String yLabel = yName;
		String[] categories = item.toArray(new String[item.size()]);
		double[] seriesValue = LangUtil.toPrimitiveDoubleArray(
				value.toArray(new Double[value.size()]));
		return new BarData(title, subtitle, categories, yLabel, seriesName,
				seriesValue);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	public String[] getCategories() {
		return categories;
	}

	public void setCategories(String[] categories) {
		this.categories = categories;
	}

	public String getyLabel() {
		return yLabel;
	}

	public void setyLabel(String yLabel) {
		this.yLabel = yLabel;
	}

	public String getSeriesName() {
		return seriesName;
	}

	public void setSeriesName(String seriesName) {
		this.seriesName = seriesName;
	}

	public double[] getSeriesValue() {
		return seriesValue;
	}

	public void setSeriesValue(double[] seriesValue) {
		this.seriesValue = seriesValue;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
