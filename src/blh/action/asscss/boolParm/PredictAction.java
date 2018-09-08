package blh.action.asscss.boolParm;

import org.apache.struts2.convention.annotation.Result;

import blh.action.asscss.boolParm.service.boolHistory;
import blh.action.support.AbstractActionSupport;
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
public class PredictAction extends AbstractActionSupport {
	private static final long serialVersionUID = 1L;

	private boolHistory service;
	private LineData getChartComparison;
	@Override
	public String execute() throws Exception {
		int unitNo = Integer.parseInt(getFirstInput());
		String item = getSecondInput();
		String beginTime = getThirdInput();
		int stepStr =Integer.parseInt(getInput(3));
		Long time = TimeUtils.StringtoLong(beginTime + " 00:00:00");
		String tableName = "bool" + "_" + beginTime.split("-")[0]
				+ beginTime.split("-")[1];
		System.out.println(beginTime + "  " + time + " " + tableName+" "+ stepStr);
		service = new boolHistory(tableName, time, unitNo, item, stepStr);
		
		getChartComparison=service.getComparison(item);
		
		return super.execute();
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
