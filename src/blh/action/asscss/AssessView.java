package blh.action.asscss;

import tool.easyui.Table;
import tool.highcharts.BarData;

public class AssessView {
	private double topScore;    // 仪表盘总分
	private String topRemark;   // 等级（优秀、、、、）

	private String oilRemark;       // 第一项结果得分
	private String conditionRemark;  // 第二项结果得分
	private String historyRemark;    // 第三项结果得分
	private String temperatureRemark;    // 第四项结果得分
	private String fifthRemark;    // 第五项结果得分
	
	private Table bottomDetail;       // 详细信息表
	private BarData middleBar;        // 柱状图
    // 三项
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
	
	
	 // 四项
	public AssessView(double topScore, String topRemark, String oilRemark, String conditionRemark, String historyRemark,
			String temperatureRemark, Table bottomDetail, BarData middleBar) {
		super();
		this.topScore = topScore;
		this.topRemark = topRemark;
		this.oilRemark = oilRemark;
		this.conditionRemark = conditionRemark;
		this.historyRemark = historyRemark;
		this.temperatureRemark = temperatureRemark;
		this.bottomDetail = bottomDetail;
		this.middleBar = middleBar;
	}
	 // 五项
	public AssessView(double topScore, String topRemark, String oilRemark, String conditionRemark, String historyRemark,
			String temperatureRemark, String fifthRemark, Table bottomDetail, BarData middleBar) {
		super();
		this.topScore = topScore;
		this.topRemark = topRemark;
		this.oilRemark = oilRemark;
		this.conditionRemark = conditionRemark;
		this.historyRemark = historyRemark;
		this.temperatureRemark = temperatureRemark;
		this.fifthRemark = fifthRemark;
		this.bottomDetail = bottomDetail;
		this.middleBar = middleBar;
	}


	public double getTopScore() {
		return topScore;
	}


	public void setTopScore(double topScore) {
		this.topScore = topScore;
	}


	public String getTopRemark() {
		return topRemark;
	}


	public void setTopRemark(String topRemark) {
		this.topRemark = topRemark;
	}


	public String getOilRemark() {
		return oilRemark;
	}


	public void setOilRemark(String oilRemark) {
		this.oilRemark = oilRemark;
	}


	public String getConditionRemark() {
		return conditionRemark;
	}


	public void setConditionRemark(String conditionRemark) {
		this.conditionRemark = conditionRemark;
	}


	public String getHistoryRemark() {
		return historyRemark;
	}


	public void setHistoryRemark(String historyRemark) {
		this.historyRemark = historyRemark;
	}


	public String getTemperatureRemark() {
		return temperatureRemark;
	}


	public void setTemperatureRemark(String temperatureRemark) {
		this.temperatureRemark = temperatureRemark;
	}


	public String getFifthRemark() {
		return fifthRemark;
	}


	public void setFifthRemark(String fifthRemark) {
		this.fifthRemark = fifthRemark;
	}


	public Table getBottomDetail() {
		return bottomDetail;
	}


	public void setBottomDetail(Table bottomDetail) {
		this.bottomDetail = bottomDetail;
	}


	public BarData getMiddleBar() {
		return middleBar;
	}


	public void setMiddleBar(BarData middleBar) {
		this.middleBar = middleBar;
	}
	

	
	

}
