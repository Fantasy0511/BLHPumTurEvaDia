package blh.action.asscss.second;

import java.util.Arrays;
import java.util.List;

import org.apache.struts2.convention.annotation.Result;

import blh.action.asscss.AssessView;
import blh.action.support.AbstractActionSupport;
import service.assess.pumptur.two.output.PumpAssResult;
import service.assess.pumptur.two.output.PumpAssSum;
import tool.easyui.Table;
import tool.highcharts.BarData;
import util.TimeUtils;

@Result(type = "json")
public class PumAssessAction extends AbstractActionSupport {

	private static final long serialVersionUID = 1L;
	private AssessView assessView;
	private PumpAssResult pumpAssResult;

	@Override
	public String execute() throws Exception {
		String timeString = getFirstInput();
		System.out.println(timeString);
		Long time = TimeUtils.StringtoLong(timeString + " 00:00:00");
		PumpAssSum pumpAssSum = new PumpAssSum();
		pumpAssResult = pumpAssSum.getPumpAssSum(time);
		
		//前端的“详细评估信息”里面的内容——对象：bottomDetail
		String[] names = { "导叶开度状态得分", "主轴密封状态得分", "水泵水轮机振动状态得分",
				"水泵水轮机温度状态得分" };
		double[] values = { pumpAssResult.getGuideVane(),
				pumpAssResult.getMainShaftSeal(), pumpAssResult.getSwingAss(),
				pumpAssResult.getTemperatureAss() };
		Table bottomDetail = new Table(new String[] { "name", "value" });
		for (int i = 0; i < names.length; i++) {
			bottomDetail.withRow(names[i], values[i]);
		}

		//前端的“柱状图”里面的内容——对象middleBar
		List<String> barName = Arrays.asList("主轴密封状态得分", "水泵水轮机振动状态得分", "历史性能",
				"水泵水轮机温度状态得分");
		List<Double> barValue = Arrays.asList(
				(double) pumpAssResult.getMainShaftSeal(),
				(double) pumpAssResult.getSwingAss(),
				(double) pumpAssResult.getHistory(),
				(double) pumpAssResult.getTemperatureAss());
		BarData middleBar = BarData.create("水泵水轮机系统评估结果", "", "性能状态", "得分",
				barName, barValue);
		
		//前端的“仪表盘”里面的内容——对象：topRemark（优秀/合格/严重）
		double pumSum = pumpAssResult.getScore();
		String topRemark = (pumSum > 60) ? ((pumSum >= 80) ? "优秀" : "合格")
				: "严重";
		
		//返回总的评估对象“assessView”
		assessView = new AssessView(pumSum, topRemark,
				pumpAssResult.getMainShaftSeal() + "",
				pumpAssResult.getSwingAss() + "",
				pumpAssResult.getHistory() + "", bottomDetail, middleBar);
		return super.execute();
	}

	public AssessView getAssessView() {
		return assessView;
	}

	public PumpAssResult getPumpAssResult() {
		return pumpAssResult;
	}

}