package blh.action.predict;

import org.apache.struts2.convention.annotation.Result;

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
public class PredictAction extends AbstractActionSupport {
	private static final long serialVersionUID = 1L;

	private PredictService service;
	private LineData getChartComparison;
	@Override
	public String execute() throws Exception {
		int unitNo = Integer.parseInt(getFirstInput());
		String item = getSecondInput();
		String beginTime = getThirdInput();
		int stepStr =Integer.parseInt(getInput(3));
		String detail=getFifthInput();
		System.out.println("参数信息："+detail);
		Long time = TimeUtils.StringtoLong(beginTime + " 00:00:00");
		String tableName = "float" + "_" + beginTime.split("-")[0]
				+ beginTime.split("-")[1];
		System.out.println(beginTime + "  " + time + " " + tableName+" "+ stepStr);
		service = new PredictService(tableName, time, unitNo, item, stepStr);
		
		getChartComparison=service.getComparison(detail);
		
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
