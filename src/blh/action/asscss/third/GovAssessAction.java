package blh.action.asscss.third;

import java.util.Arrays;
import java.util.List;

import org.apache.struts2.convention.annotation.Result;
import blh.action.asscss.AssessView;
import blh.action.support.AbstractActionSupport;
import service.assess.Governor.four.GovAssResultfour;
import service.assess.Governor.four.output4;
import service.assess.Governor.three.GovAssResultThree;
import service.assess.Governor.three.output3;
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
		
		output3 output = new output3();
		GovAssResultThree govAssResultThree=output.output3(time);
		
		double[] values= {govAssResultThree.getSignalSum3(),govAssResultThree.getOutput3(),govAssResultThree.getState3(),govAssResultThree.getHistory3()};
		String[] names = { "油泵油压", "油槽油位", "油槽油温", "压力油油位"};
		Table bottomDetail = new Table(new String[] { "name", "value" });
		for (int i = 0; i < names.length; i++) {
			bottomDetail.withRow(names[i],values[i]);
		}

		List<String> barName = Arrays.asList("油系统性能", "振动信号性能", "历史性能");
		List<Double> barValue = Arrays.asList(
				(double) govAssResultThree.getSignalSum3(),
				(double) govAssResultThree.getOutput3(),
				(double) govAssResultThree.getState3());
		BarData middleBar = BarData.create("调速系统评估结果", "", "性能状态", "得分",
				barName, barValue);
		double govSum = govAssResultThree.getState3();
		String topRemark = (govSum > 60) ? ((govSum >= 80) ? "优秀" : "合格")
				: "严重";
		assessView = new AssessView(govAssResultThree.getOutput3(), topRemark,
				govAssResultThree.getHistory3()+"",
				govAssResultThree.getState3()+"",
				govAssResultThree.getSignalSum3()+"" , bottomDetail, middleBar);
		return super.execute();
	}

	public AssessView getAssessView() {
		return assessView;
	}

}
