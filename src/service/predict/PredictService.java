package service.predict;

import java.io.IOException;
import java.util.Vector;

import org.jfree.data.category.DefaultCategoryDataset;

import bll.predict.PredictInput;
import bll.predict.TendencyPredict;
import bll.predict.dao.AssessPredictData;
import net.sf.jasperreports.engine.JasperPrint;
import tool.easyui.Table;
import tool.highcharts.LineData;
import tool.highcharts.LineDataBuilder;

public class PredictService {
	private TendencyPredict predict;
	private JasperPrint jp = null;
	private PredictReport report = new PredictReport();

	public PredictService(String tableName, Long time, int unitNo, String item,
			int step) {
		PredictInput input = AssessPredictData.read(tableName,unitNo, item);
		predict = new TendencyPredict();
		try {
			predict.predictMain(input, step);
		} catch (IOException e) {
			e.printStackTrace();
		}
		report.setUnitNo(unitNo + "#");
		report.setStep(String.valueOf(step));
		report.setObject(item);
	}

	public Table getData() {
		String[] headers = { "time", "original", "predicted" };
		Table table = new Table(headers);
		String[] predictedX = predict.getTransfer().getVTime();
		Vector<Double> predictedY = predict.getFinalResult();
		Vector<Double> originalY = predict.getTransfer().getOriginalY();
		for (int i = 0; i < predictedX.length; ++i) {
			table.withRow(predictedX[i], originalY.get(i), predictedY.get(i));
		}

		report.setResultTable(table);
		return table;
	}

	public LineData getComparison() {
		double[] x = new double[predict.getTransfer().getVy().size()];
		for (int i = 0; i < x.length; ++i) {
			x[i] = i + 1;
		}

		double[] x1 = new double[predict.getAllPredictValues().size()];
		for (int i = 0; i < x1.length; ++i) {
			x1[i] = i + 1;
		}
		Vector<Double> predictedY = predict.getAllPredictValues();

		return LineDataBuilder.createBuilder("", "序号", "百分比")
				.addSeries("实测值", x,
						toDoubleArray(predict.getTransfer().getVy()))
				.addSeries("预测值", x1, toDoubleArray(predictedY)).build();
	}

	private double[] toDoubleArray(Vector<Double> vector) {
		double[] result = new double[vector.size()];
		for (int i = 0; i < vector.size(); ++i) {
			result[i] = vector.get(i);
		}
		return result;
	}

	/**
	 * 1. 检查是否已经进行过预测试验 2. 构造输出到html和pdf文件的方法 3. makeprint方法生成japserprint报表文件
	 * 构建报表
	 */

	private void checkPredictNotNull() {
		if (predict == null) {
			throw new IllegalStateException("no predict right now");
		}
	}

	/**
	 * 生成jfreechart.linechart数据源
	 * 
	 * @return
	 */
	private DefaultCategoryDataset getDataSet() {
		DefaultCategoryDataset defaultcategorydataset = new DefaultCategoryDataset();
		String[] predictedX = predict.getTransfer().getVTime();
		Vector<Double> predictedY = predict.getFinalResult();
		Vector<Double> originalY = predict.getTransfer().getOriginalY();
		for (int i = 0; i < predictedX.length; ++i) {
			defaultcategorydataset.addValue(predictedY.get(i), "预测值", "" + i);
		}
		for (int i = 0; i < predictedX.length; ++i) {
			defaultcategorydataset.addValue(originalY.get(i), "实测值", "" + i);
		}

		return defaultcategorydataset;
	}

}
