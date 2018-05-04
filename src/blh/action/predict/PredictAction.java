package blh.action.predict;


import org.apache.struts2.convention.annotation.Result;

import blh.action.support.AbstractActionSupport;
import service.predict.PredictService;
import tool.easyui.Table;
import tool.highcharts.LineData;

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
		String stepStr = getThirdInput();
		int step = 1;
		if (stepStr.equals("singleStep")) {
			step = 1;
		} else if (stepStr.equals("multiStep")) {
			step = 3;
		} else {
			throw new IllegalArgumentException("no such step");
		}
		service = new PredictService(unitNo, item, step);
		return super.execute();
	}

	public Table getTableComparison() {
		return service.getData();
	}

	public LineData getChartComparison() {
		return service.getComparison();
	}
}
