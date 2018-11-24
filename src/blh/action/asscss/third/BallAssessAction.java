package blh.action.asscss.third;

import java.util.Arrays;
import java.util.List;

import org.apache.struts2.convention.annotation.Result;

import blh.action.asscss.AssessView;
import blh.action.asscss.SonAssessView;
import blh.action.support.AbstractActionSupport;
import service.assess.Ballvalve.one.BallAssessResult;
import service.assess.Ballvalve.three.output3;
import tool.easyui.Table;
import tool.exception.JudgeTime;
import tool.highcharts.BarData;
import tool.highcharts.PieData;
import util.TimeUtils;
import util.arrEveUtil;

@Result(type = "json")
public class BallAssessAction extends AbstractActionSupport {
	private static final long serialVersionUID = 1L;
	private AssessView assessView;
	private BallAssessResult ballAssessResult;
	private SonAssessView sonAssessView;
	private String judgeResult;
	
	@Override
	public String execute() throws Exception {
		String timeString = getFirstInput();
		String time2 = getFirstInput().toString() + " 00:00:00";
		System.out.println("选择时间： " + timeString);
		Long time = TimeUtils.StringtoLong(timeString + " 00:00:00");

		// 判断输入的时间是否能在数据库中找到相应表格
		JudgeTime jt = new JudgeTime();
		judgeResult = jt.judgeTime(time2);				
		
		output3 ballAssSum = new output3();
		ballAssessResult = ballAssSum.getOutput3(time);

		// 前端的“详细评估信息”里面的内容——对象：bottomDetail
		String[] category = {
	            "油系统性能状态", "", "","球阀性能状态", "", ""
				  };
		String[] names = { "压力油罐油压低报警", "球阀1号油泵故障", "球阀2号油泵故障", "球阀突然关闭报警", "蜗壳压力",
				"水闸压力" };
		double[] values = {
				ballAssessResult.getOilSystem().get(0).doubleValue(),
				ballAssessResult.getOilSystem().get(1).doubleValue(),
				ballAssessResult.getOilSystem().get(2).doubleValue(),

				ballAssessResult.getPerformance().get(0).doubleValue(),
				ballAssessResult.getPerformance().get(1).doubleValue(),
				ballAssessResult.getPerformance().get(2).doubleValue(), };
		Table bottomDetail = new Table(new String[] { "category","name", "value" });
		for (int i = 0; i < names.length; i++) {
			bottomDetail.withRow(category[i],names[i], values[i]);
		}
		bottomDetail.withRow("历史性能状态","历史性能",ballAssessResult.getHistory());
		// 前端的“柱状图”里面的内容——对象middleBar
		List<String> barName = Arrays.asList("球阀油系统性能状态", "历史和巡检状态", "球阀性能状态");

		List<Double> barValue = Arrays.asList(ballAssessResult.getOilSystem().get(3).doubleValue(),
				ballAssessResult.getHistory(), ballAssessResult.getPerformance().get(3).doubleValue());
		BarData middleBar = BarData.create("球阀系统状态评估结果", "", "性能状态", "得分", barName, barValue);

		// 前端的“仪表盘”里面的内容——对象：topRemark（优秀/合格/严重）
		double barAssSum = ballAssessResult.getBallSum();
		String topRemark = (barAssSum > 60) ? ((barAssSum >= 80) ? "优秀" : "合格") : "严重";

		// 小窗口显示的各个底层指标得分
		// 油系统底层指标得分
		List<String> sonbarName = Arrays.asList("压力油罐油压低报警", "球阀1号油泵故障", "球阀2号油泵故障");
		List<Double> sonbarValue = Arrays.asList(ballAssessResult.getOilSystem().get(0).doubleValue(),
				ballAssessResult.getOilSystem().get(1).doubleValue(),
				ballAssessResult.getOilSystem().get(2).doubleValue());
		arrEveUtil aUtil=new arrEveUtil();
		List<Double> sonbarValueRatio = aUtil.list2arrayNumber(sonbarValue);

		// govAssResult.getGovOilResult().get(0)是在数组List<Number>里面获取的，里面的每个值拿出来都是number类型的
		// 这时需要获取这个number的double值，而不是给number转成double ，也转不成

		BarData ballOilBar = BarData.create("油系统性能底层指标得分", "", "性能状态", "得分", sonbarName, sonbarValue);
		PieData ballOilPie = PieData.create("油系统性能底层指标比例", sonbarName, sonbarValueRatio, "得分XXX");

		// 球阀性能底层指标得分
		List<String> sonbarName1 = Arrays.asList("球阀突然关闭报警", "蜗壳压力", "水闸压力");
		List<Double> sonbarValue1 = Arrays.asList(ballAssessResult.getPerformance().get(0).doubleValue(),
				ballAssessResult.getPerformance().get(1).doubleValue(),
				ballAssessResult.getPerformance().get(2).doubleValue());
		
		
		List<Double> sonbarValueRatio1 = aUtil.list2arrayNumber(sonbarValue1);
		BarData performanceBar = BarData.create("球阀性能底层指标得分", "", "性能状态", "得分", sonbarName1, sonbarValue1);
		PieData performancePie = PieData.create("球阀性能底层指标得分", sonbarName1, sonbarValueRatio1, "得分XXX");

		// 返回总的评估对象“assessView”
		assessView = new AssessView(ballAssessResult.getBallSum(), topRemark,
				ballAssessResult.getOilSystem().get(3).doubleValue() + "",
				ballAssessResult.getPerformance().get(3).doubleValue() + "", ballAssessResult.getHistory() + "",
				bottomDetail, middleBar);

		// 返回底层的评估对象“sonAssessView”
		sonAssessView = new SonAssessView(ballOilBar, ballOilPie, performanceBar, performancePie,null,null);

		return super.execute();
	}

	public AssessView getAssessView() {
		return assessView;
	}

	public BallAssessResult getBallAssessResult() {
		return ballAssessResult;
	}

	public void setAssessView(AssessView assessView) {
		this.assessView = assessView;
	}

	public void setBallAssessResult(BallAssessResult ballAssessResult) {
		this.ballAssessResult = ballAssessResult;
	}

	public SonAssessView getSonAssessView() {
		return sonAssessView;
	}

	public void setSonAssessView(SonAssessView sonAssessView) {
		this.sonAssessView = sonAssessView;
	}

	public String getJudgeResult() {
		return judgeResult;
	}

	public void setJudgeResult(String judgeResult) {
		this.judgeResult = judgeResult;
	}

}
