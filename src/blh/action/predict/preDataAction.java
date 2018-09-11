package blh.action.predict;

import org.apache.struts2.convention.annotation.Result;

import algorithms.cos.LinearRegression;
import blh.action.support.AbstractActionSupport;
import service.predict.PredictService;
import tool.easyui.Table;
import tool.highcharts.LineData;
import util.TimeUtils;

/**
 * 预测action。
 * 
 * @author hx
 * 
 */
@Result(type = "json")
public class preDataAction extends AbstractActionSupport {
	private static final long serialVersionUID = 1L;

	private PredictService service;
	private LineData getChartComparison;
	private String  alarmDetail;
	@Override
	public String execute() throws Exception {
		int unitNo = Integer.parseInt(getFirstInput());
		String item = getSecondInput();
		String beginTime = getThirdInput();
		int stepStr =Integer.parseInt(getInput(3));
		
		Long time = TimeUtils.StringtoLong(beginTime + " 00:00:00");
		String tableName = "float" + "_" + beginTime.split("-")[0]
				+ beginTime.split("-")[1];
		System.out.println(beginTime + "  " + time + " " + tableName+" "+ stepStr);
		
		int id= Integer.parseInt(itemConvert.valueOf(item).getitem());
		
		service = new PredictService(tableName, time, unitNo, item, stepStr,id);
		
		getChartComparison=service.getComparison(item);
		
		LinearRegression aLinearRegression=new LinearRegression("float", id, beginTime+" 00:00:00",beginTime+" 23:59:59");
		
		 alarmDetail=aLinearRegression.alter;
		
		
		return super.execute();
	}

	public String getAlarmDetail() {
		return alarmDetail;
	}

	public void setAlarmDetail(String alarmDetail) {
		this.alarmDetail = alarmDetail;
	}

	public Table getTableComparison() {
		return service.getData();
	}

	public LineData getGetChartComparison() {
		return getChartComparison;
	}

	public void setGetChartComparison(LineData getChartComparison) {
		this.getChartComparison = getChartComparison;
	}

	
}
