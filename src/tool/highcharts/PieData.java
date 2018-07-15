package tool.highcharts;

import java.util.ArrayList;
import java.util.List;

/**
 * 饼图的数据模型。
 * 
 * @author 刘涵
 * @author hx(改造为适合转换成json的格式)
 *
 */
public class PieData {
	private String title;
	private String seriesName;
	private Object[][] data;

	private String type = "pie";

	public PieData(String title, String seriesName, List<CategoryDataPoint> nameDataList) {
		super();
		List<Object[]> dataList = new ArrayList<Object[]>();
		for (CategoryDataPoint nd : nameDataList) {
			dataList.add(new Object[] { nd.getName(), nd.getNum() });
		}
		this.data = dataList.toArray(new Object[dataList.size()][]);
		this.title = title;
		this.seriesName = seriesName;
	}

	public PieData(String title, String seriesName, Object[][] data) {
		super();
		this.title = title;
		this.seriesName = seriesName;
		this.data = data;
	}

	public static PieData create(String title, List<String> name,
			List<Double> weight, String seriesName) {
		return new PieData(title, seriesName, CategoryDataPoint.create(name, weight));
	}

	public Object[][] getData() {
		return data;
	}

	public void setData(Object[][] data) {
		this.data = data;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSeriesName() {
		return seriesName;
	}

	public void setSeriesName(String seriesName) {
		this.seriesName = seriesName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
