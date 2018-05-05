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

	@Override
	public String execute() throws Exception {
		int unitNo = Integer.parseInt(getFirstInput());
		String item = getSecondInput();
		String beginTime = getThirdInput();
		String stepStr = getInput(3);
		Long time = TimeUtils.StringtoLong(beginTime + " 00:00:00");
		String tableName = "float" + "_" + beginTime.split("-")[0]
				+ beginTime.split("-")[1];
		System.out.println(beginTime + "  " + time + " " + tableName);
		int step = 1;
		if (stepStr.equals("singleStep")) {
			step = 1;
		} else if (stepStr.equals("multiStep")) {
			step = 3;
		} else {
			throw new IllegalArgumentException("no such step");
		}
		service = new PredictService(tableName, time, unitNo, item, step);
		return super.execute();
	}

	public Table getTableComparison() {
		return service.getData();
	}

	public LineData getChartComparison() {
		return service.getComparison();
	}
}
