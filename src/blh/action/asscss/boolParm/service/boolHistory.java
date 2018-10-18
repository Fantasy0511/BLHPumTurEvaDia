package blh.action.asscss.boolParm.service;

import blh.action.asscss.boolParm.dao.historyBoolDao;
import bll.predict.PredictInput;
import tool.easyui.Table;
import tool.highcharts.LineData;
import tool.highcharts.LineDataBuilder;
import util.TimeUtils;

public class boolHistory{
	private PredictInput input; 
	
	public boolHistory(String tableName, Long time, int unitNo, String item,int step) {
		input =  historyBoolDao.read(tableName,unitNo, item,time);
	}
	
	
	public Table getData() {
		String[] headers = { "time", "value" };
		Table table = new Table(headers);
		String[] predictedX = input.getTime();
		/*实测值*/
		double[] predictedY = input.getData();
		//预测结果对比表
		for (int i = 0; i < predictedX.length; ++i) {
			table.withRow(predictedX[i], predictedY[i]);
		}
		return table;
	}
	
	public LineData getComparison(String item) {
		double[] x=new double[input.getTime().length] ;
		
		for (int i = 0; i < input.getTime().length; ++i) {
			x[i] = TimeUtils.StringtoLong(input.getTime()[i])*1000;
			
		}

		return LineDataBuilder.createBuilder("", "", item)
				.addSeries("实测值", x,input.getData()).build();
	}

	
	
}