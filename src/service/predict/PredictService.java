package service.predict;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.jfree.data.category.DefaultCategoryDataset;

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

	public PredictService(String tableName, Long time, int unitNo, String item,
			int step) {
		input = AssessPredictData.read(tableName,unitNo, item);
		
		
		predict = new TendencyPredict();
		try {
			predict.predictMain(input, step);
			
			//线性回归预测
			Vector<Double> xline=new Vector<>();
			for(int i=0;i<predict.getFinalResult().size();i++) {
				/*xline.add((double) TimeUtils.StringtoLong(input.getTime()[i]));*/
				xline.add((double) i);
			}
			dataLine aLine=new dataLine(xline,predict.getTransfer().getOriginalY());
			lineRegMain aLineRegMain=new lineRegMain();
			resultLine=aLineRegMain.calculatedSum(aLine,step);
			
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
			x[i] = i + 1;
			
		}

		double[] x1 = new double[predict.getAllPredictValues().size()];
		for (int i = 0; i < x1.length; ++i) {
			x1[i] = i + 1;
			hlimit.add(input.getHlimite()[0]);
		}
		
		Vector<Double> predictedY = predict.getAllPredictValues();

		return LineDataBuilder.createBuilder("", "序号", item)
				.addSeries("实测值", x,
						toDoubleArray(predict.getTransfer().getVy()))
				.addSeries("阈值", x1,listtoDouble(hlimit))
				.addSeries("线性回归预测", x1,toDoubleArray(resultLine.getY()))
				.addSeries("ARMA预测", x1, toDoubleArray(predictedY)).build();
	}

	private double[] toDoubleArray(Vector<Double> vector) {
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
