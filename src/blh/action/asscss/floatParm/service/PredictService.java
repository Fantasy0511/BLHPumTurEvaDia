package blh.action.asscss.floatParm.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.jfree.data.category.DefaultCategoryDataset;

import algorithms.cos.LinearRegression;
import bll.LinearReg.dataLine;
import bll.LinearReg.lineRegMain;
import bll.predict.PredictInput;
import bll.predict.TendencyPredict;
import blh.action.asscss.floatParm.dao.*;
import net.sf.jasperreports.engine.JasperPrint;
import service.predict.PredictReport;
import tool.easyui.Table;
import tool.highcharts.LineData;
import tool.highcharts.LineDataBuilder;
import util.TimeUtils;

public class PredictService {
	private TendencyPredict predict;
	private PredictInput input;
	private List<Double> hlimit;
	private dataLine resultLine;
	private JasperPrint jp = null;
	private PredictReport report = new PredictReport();
	public String  alarmDetail1;

	public PredictService(String tableName, Long time, int unitNo, String item,
			int step) {
		input = AssessPredictData.read(tableName,unitNo, item,time);
		
		
		predict = new TendencyPredict();
		try {
			predict.predictMain(input, step);
			LinearRegression lRegression = new LinearRegression(unitNo,"float", Integer.parseInt(item), TimeUtils.LongtoString(time-86400),TimeUtils.LongtoString(time));
			alarmDetail1=lRegression.alter;
			System.out.println("   "+alarmDetail1);
			resultLine=lRegression.fit();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		report.setUnitNo(unitNo + "#");
		report.setStep(String.valueOf(step));
		report.setObject(item);
	}

	public Table getData() {
		String[] headers = { "time", "original", "linePre","predicted" };
		Table table = new Table(headers);
		String[] predictedX = predict.getTransfer().getVTime();
		
		/*预测值*/
		Vector<Double> predictedY = predict.getFinalResult();
		/*实测值*/
		
		Vector<Double> originalY = predict.getTransfer().getOriginalY();
		
		//预测结果对比表
		for (int i = 0; i < predictedX.length; ++i) {
			table.withRow(predictedX[i], originalY.get(i),resultLine.getY().get(i), predictedY.get(i));
		}

		report.setResultTable(table);
		return table;
	}

	public LineData getComparison(String item) {
		double[] x = new double[predict.getTransfer().getVy().size()];
		hlimit=new ArrayList<>();
		for (int i = 0; i < x.length; ++i) {
			x[i] = resultLine.getX().get(i)*1000;
			
		}

		/*double[] x1 = new double[predict.getAllPredictValues().size()];
		for (int i = 0; i < x1.length; ++i) {
			x1[i] = resultLine.getX().get(i)*1000;
		}*/
		
		Vector<Double> predictedY = predict.getAllPredictValues();

		return LineDataBuilder.createBuilder("", "", item)
				.addSeries("实测值", x,
						toDoubleArray(predict.getTransfer().getVy()))
				.addSeries("线性回归预测", x,toDoubleArray(resultLine.getY()))
				.addSeries("ARMA预测", x, toDoubleArray(predictedY)).build();
	}

	private double[] toDoubleArray(Vector<Double> vector) {
		double[] result = new double[vector.size()];
		for (int i = 0; i < vector.size(); ++i) {
			result[i] = vector.get(i);
		}
		return result;
	}
	

}
