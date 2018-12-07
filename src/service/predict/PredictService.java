package service.predict;

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
import bll.predict.dao.AssessPredictData;
import net.sf.jasperreports.engine.JasperPrint;
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
	public String  alarmDetail2;

	public PredictService(String tableName, Long time, int unitNo, String item,
			int step,int id) {
		input = AssessPredictData.read(tableName,unitNo, id,time);
		
		
		predict = new TendencyPredict();
		try {
			predict.predictMain(input, step);
			LinearRegression lRegression = new LinearRegression(unitNo,"float", id, TimeUtils.LongtoString(time), TimeUtils.LongtoString(time+86400));
			alarmDetail2=lRegression.alter;
			resultLine=lRegression.fit(step); //输出线性回归x、y值
			System.out.println("线性预测的x长度是："+resultLine.getX().size()+" y的值是："+resultLine.getY().size());
			
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
		Vector<Double> predictedY = predict.getcompleteResult();
		/*实测值*/
		
		Vector<Double> originalY = predict.getTransfer().getOriginalY();
		System.out.println("时间长度： "+predictedX.length+"  实测值长度："+originalY.size()+" arma预测长度："+predictedY.size()+"  线性预测值Y："+
							resultLine.getY().size()+"   线性预测值X："+resultLine.getX().size());
		//预测结果对比表
		for (int i = 0; i < predictedX.length; ++i) {
			table.withRow(predictedX[i], originalY.get(i),resultLine.getY().get(i), predictedY.get(i));
		}

		report.setResultTable(table);
		return table;
	}

	public LineData getComparison(String item) {
		
		double[] lr_pred_x = new double[resultLine.getX().size()]; //含有预测量的时间横坐标
		for (int i = 0; i < lr_pred_x.length; ++i) {
			lr_pred_x[i] = resultLine.getX().get(i)*1000;
		}
		
		double[] original_x = new double[lr_pred_x.length-predict.getStepOutput().size()];//不含预测时间的横坐标
		double[] only_pred_x = new double[predict.getStepOutput().size()+1];//只含有预测时间的横坐标
		for (int i = 0; i < lr_pred_x.length; ++i) {
			if(i<original_x.length){
				original_x[i] = lr_pred_x[i];
			}
			if(i>=original_x.length-1){
				only_pred_x[i-original_x.length+1] = lr_pred_x[i];
			} 
		}
		
		
		List<Double> predictedY = predict.getStepOutput(); //svm预测结果
		double[] ex_predictedY = new double[only_pred_x.length];//svm预测结果加上最后一个真实值，让曲线自然过渡
		for(int i=0;i<ex_predictedY.length;i++){
			if(i==0){
				ex_predictedY[i] = predict.getInput().getData()[original_x.length-1];
			}
			else{
				ex_predictedY[i] = predictedY.get(i-1);
			}
		}
		/*
		int a=original_x.length;
		int b=pred_x.length;
		int c=toDoubleArray(predict.getTransfer().getVy()).length;
		int d=toDoubleArray(resultLine.getY()).length;
		int e=toDoubleArray(predictedY).length;
		System.out.println(a+" "+b+" "+c+" "+d+" "+e);
		System.out.println("x轴值："+resultLine.getX().size());
		*/
		return LineDataBuilder.createBuilder("", "", item)
				.addSeries("实测值", original_x,
						predict.getInput().getData())
				.addSeries("线性回归预测", lr_pred_x,toDoubleArray(resultLine.getY()))
				.addSeries("ARMA预测", only_pred_x, ex_predictedY).build();
	}

	private double[] toDoubleArray(Vector<Double> vector) {
		double[] result = new double[vector.size()];
		for (int i = 0; i < vector.size(); ++i) {
			result[i] = vector.get(i);
		}
		return result;
	}
	
	private double[] ListtoDoubleArray(List<Double> vector) {
		double[] result = new double[vector.size()];
		for (int i = 0; i < vector.size(); ++i) {
			result[i] = vector.get(i);
		}
		return result;
	}
	
	private double[] listtoDouble(List<Double> lDoubles) {
		double[] result=new double[lDoubles.size()];
		for (int i = 0; i < lDoubles.size(); i++) {
			result[i] = lDoubles.get(i);
			
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
