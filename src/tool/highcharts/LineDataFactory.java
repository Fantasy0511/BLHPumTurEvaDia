package tool.highcharts;

import java.util.ArrayList;
import java.util.List;

import tool.highcharts.LineData.NameAndData;
import tool.highcharts.LineDataPoint;
import util.LangUtil;

/**
 * 折线图数据的构造工厂。<br/>
 * 使用工厂避免外部代码直接访问原始的构造函数，从而隐藏原始代码的构造细节。<br/>
 * 封装和隐藏：封装是屏蔽细节，只留下调用接口，方便调用；隐藏是屏蔽实现（如屏蔽数据结构），也留下调用接口，方便重构。
 * 
 * @author hx
 *
 */
public class LineDataFactory {
	public static LineData create(String title, String xName, String yName,
			List<LineDataPoint> dataPointList) {
		List<Double[]> dataList = new ArrayList<Double[]>();
		for (LineDataPoint dp : dataPointList) {
			dataList.add(new Double[] { dp.getX(), dp.getY() });
		}
		double[][] d = LangUtil.toDoubleArray2D(dataList
				.toArray(new Double[dataList.size()][]));
		return create(title, xName, yName, d);
	}

	public static LineData create(String title, String xName, String yName,
			double[][] data) {
		return create(title, xName, yName, new double[][][] { data });
	}

	public static LineData create(String title, String xName, String yName,
			double[][]... data) {
		NameAndData[] dataArray = new NameAndData[data.length];
		for (int i = 0; i < data.length; ++i) {
			dataArray[i] = new NameAndData(data[i]);
		}
		return new LineData(title, xName, yName, dataArray);
	}

	public static LineData create(String title, String xName, String yName,
			NameAndData... data) {
		return new LineData(title, xName, yName, data);
	}

	public static LineData create(String title, String xName, String yName,
			double interval, double[] data) {
		double t = 0;
		double[][] d = new double[data.length][2];
		for (int i = 0; i < data.length; ++i) {
			d[i][0] = t;
			d[i][1] = data[i];
			t += interval;
		}
		return create(title, xName, yName, d);
	}

	public static LineData createLine(String title, String xName, String yName,
			List<NameAndData> dataList) {
		return create(title, xName, yName,
				dataList.toArray(new NameAndData[dataList.size()]));
	}

}
