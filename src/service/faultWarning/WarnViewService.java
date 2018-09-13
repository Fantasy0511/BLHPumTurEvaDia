package service.faultWarning;

import dao.LineDataDao;
import bll.predict.PredictInput;
import tool.highcharts.LineData;
import tool.highcharts.LineDataBuilder;

public class WarnViewService {
private PredictInput input; 
	
	public WarnViewService(String tableName, Long time, String ID) {
		input =  LineDataDao.read(tableName, ID,time);
	}
	
	
	public LineData getComparison(String name) {
		double[] x=new double[input.getTime().length] ;
		
		for (int i = 0; i < input.getTime().length; ++i) {
			x[i] = i + 1;
			
		}

		return LineDataBuilder.createBuilder("", "", name)
				.addSeries("实测值", x,input.getData()).build();
	}
}
