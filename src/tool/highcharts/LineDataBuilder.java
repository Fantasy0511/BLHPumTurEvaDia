package tool.highcharts;

import java.util.ArrayList;
import java.util.List;

import tool.highcharts.LineData.NameAndData;
import tool.highcharts.LineDataPoint;

/**
 * LineData的构建者模式。
 * 
 * @author hx
 * 
 */
public class LineDataBuilder {
	private String title;
	private String xName;
	private String yName;
	private List<NameAndData> dataList;

	private LineDataBuilder(String title, String xName, String yName) {
		super();
		this.title = title;
		this.xName = xName;
		this.yName = yName;
		this.dataList = new ArrayList<NameAndData>();
	}

	public static LineDataBuilder createBuilder(String title, String xName, String yName) {
		return new LineDataBuilder(title, xName, yName);
	}

	public LineDataBuilder addSeries(double[][] series) {
		dataList.add(new NameAndData(series));
		return this;
	}

	public LineDataBuilder addSeries(String seriesName, double[][] data) {
		dataList.add(new NameAndData(seriesName, data));
		return this;
	}

	public LineDataBuilder addSeries(String seriesName, double interval, double[] data) {
		double startTime = 0;
		double[][] d = new double[data.length][2];
		for (int i = 0; i < data.length; ++i) {
			d[i][0] = startTime;
			d[i][1] = data[i];
			startTime += interval;
		}
		addSeries(seriesName, d);
		return this;
	}

	public LineDataBuilder addSeries(String seriesName, double[] time, double[] value) {
		double[][] d = new double[time.length][2];
		for (int i = 0; i < d.length; ++i) {
			d[i][0] = time[i];
			d[i][1] = value[i];
		}
		addSeries(seriesName, d);
		return this;
	}

	public LineDataBuilder addSeries(List<LineDataPoint> pointList) {
		double[][] data = new double[pointList.size()][2];
		for (int i = 0; i < pointList.size(); ++i) {
			data[i][0] = pointList.get(i).getX();
			data[i][1] = pointList.get(i).getY();
		}
		addSeries(data);
		return this;
	}

	public LineData build() {
		return LineDataFactory.createLine(title, xName, yName, dataList);
	}
}