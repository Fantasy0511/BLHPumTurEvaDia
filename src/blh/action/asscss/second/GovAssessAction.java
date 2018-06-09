package blh.action.asscss.second;

import java.util.Arrays;
import java.util.List;

import org.apache.struts2.convention.annotation.Result;

import blh.action.asscss.AssessView;
import blh.action.support.AbstractActionSupport;
import service.assess.Governor.two.GovAssResultTwo;
import service.assess.Governor.two.output2;
import tool.easyui.Table;
import tool.highcharts.BarData;
import util.TimeUtils;

/**
 * 返回调速系统评估EasyUI视图
 * 
 * @author wuyue
 *
 */
@Result(type = "json")
public class GovAssessAction extends AbstractActionSupport {
	private static final long serialVersionUID = 1L;
	private AssessView assessView;

	@Override
	public String execute() throws Exception {
		String timeString = getFirstInput();
		System.out.println(timeString);
		Long time = TimeUtils.StringtoLong(timeString + " 00:00:00");
		
		output2 output = new output2();
		GovAssResultTwo govAssResult2 = output.output2(time);
		
		double[] values= {govAssResult2.getHistory2(),govAssResult2.getOutput2(),govAssResult2.getSignalSum2(),govAssResult2.getState2()};
		String[] names = { "油泵油压", "油槽油位", "油槽油温", "压力油油位"};
		Table bottomDetail = new Table(new String[] { "name", "value" });
		for (int i = 0; i < names.length; i++) {
			bottomDetail.withRow(names[i],values[i]);
		}

		List<String> barName = Arrays.asList("油系统性能", "振动信号性能", "历史性能");
		List<Double> barValue = Arrays.asList(
				(double) govAssResult2.getSignalSum2(),
				(double) govAssResult2.getOutput2(),
				(double) govAssResult2.getState2());
		BarData middleBar = BarData.create("调速系统评估结果", "", "性能状态", "得分",
				barName, barValue);
		double govSum = govAssResult2.getState2();
		String topRemark = (govSum > 60) ? ((govSum >= 80) ? "优秀" : "合格")
				: "严重";
		assessView = new AssessView(govAssResult2.getOutput2(), topRemark,
				govAssResult2.getHistory2()+"",
				govAssResult2.getHistory2()+"",
				govAssResult2.getState2()+"" , bottomDetail, middleBar);
		return super.execute();
	}

	public AssessView getAssessView() {
		return assessView;
	}

}
