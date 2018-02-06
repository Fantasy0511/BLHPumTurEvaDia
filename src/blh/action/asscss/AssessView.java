package blh.action.asscss;

import tool.easyui.Table;
import tool.highcharts.BarData;

public class AssessView {
	private double topScore;
	private String topRemark;

	private String oilRemark;// 评价
	private String conditionRemark;
	private String historyRemark;

	private Table bottomDetail;
	private BarData middleBar;

	public AssessView(double topScore, String topRemark, String oilRemark,
			String conditionRemark, String historyRemark, Table bottomDetail,
			BarData middleBar) {
		super();
		this.topScore = topScore;
		this.topRemark = topRemark;
		this.oilRemark = oilRemark;
		this.conditionRemark = conditionRemark;
		this.historyRemark = historyRemark;
		this.bottomDetail = bottomDetail;
		this.middleBar = middleBar;
	}

	public double getTopScore() {
		return topScore;
	}

	public String getTopRemark() {
		return topRemark;
	}

	public String getOilRemark() {
		return oilRemark;
	}

	public String getConditionRemark() {
		return conditionRemark;
	}

	public String getHistoryRemark() {
		return historyRemark;
	}

	public Table getBottomDetail() {
		return bottomDetail;
	}

	public BarData getMiddleBar() {
		return middleBar;
	}

}
