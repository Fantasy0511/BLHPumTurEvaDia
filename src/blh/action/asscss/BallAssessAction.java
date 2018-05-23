package blh.action.asscss;

import java.util.Arrays;
import java.util.List;

import org.apache.struts2.convention.annotation.Result;

import blh.action.support.AbstractActionSupport;
import service.assess.Ballvalve.one.BallAssSumOut;
import service.assess.Ballvalve.one.BallAssessResult;
import tool.easyui.Table;
import tool.highcharts.BarData;
import util.TimeUtils;

@Result(type = "json")
public class BallAssessAction extends AbstractActionSupport {
	private static final long serialVersionUID = 1L;
	private AssessView assessView;
	private BallAssessResult ballAssessResult;

	@Override
	public String execute() throws Exception {
		String timeString = getFirstInput();
		System.out.println("选择时间： " + timeString);
		Long time = TimeUtils.StringtoLong(timeString + " 00:00:00");
		BallAssSumOut ballAssSum = new BallAssSumOut();
		ballAssessResult = ballAssSum.getBallAssSum(time);

		String[] names = { "球阀油系统性能状态", "历史和巡检状态", "球阀性能状态" };
		double[] values = { ballAssessResult.getOilSystem(), ballAssessResult.getHistory(),
				ballAssessResult.getPerformance() };
		Table bottomDetail = new Table(new String[] { "name", "value" });
		for (int i = 0; i < names.length; i++) {
			bottomDetail.withRow(names[i], values[i]);
		}

		List<String> barName = Arrays.asList("球阀油系统性能状态", "历史和巡检状态", "球阀性能状态");
		
		List<Double> barValue = Arrays.asList((double) ballAssessResult.getOilSystem(),
				(double) ballAssessResult.getHistory(), (double)ballAssessResult.getPerformance());
		
		BarData middleBar = BarData.create("球阀系统状态评估结果", "", "性能状态", "得分",
				barName, barValue);
		//饼图数据
		double barAssSum =ballAssessResult.getBallSum();
		String topRemark = (barAssSum > 60) ? ((barAssSum >= 80) ? "优秀" : "合格")
				: "严重";
		
		assessView=new AssessView(barAssSum, topRemark, 
				ballAssessResult.getOilSystem() + "",
				ballAssessResult.getPerformance() + "", 
				ballAssessResult.getHistory() + "", 
				bottomDetail, 
				middleBar);

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
		
}
