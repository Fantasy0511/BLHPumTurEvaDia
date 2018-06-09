package blh.action.asscss.four;

import java.util.Arrays;
import java.util.List;

import org.apache.struts2.convention.annotation.Result;
import blh.action.asscss.AssessView;
import blh.action.support.AbstractActionSupport;
import service.assess.Governor.four.GovAssResultfour;
import service.assess.Governor.four.output4;
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
		
		output4 output = new output4();
		GovAssResultfour govAssResult4 = output.output4(time);
		
		double[] values= {govAssResult4.getHistory(),govAssResult4.getOutput(),govAssResult4.getSignalSum4(),govAssResult4.getState()};
		String[] names = { "油泵油压", "油槽油位", "油槽油温", "压力油油位"};
		Table bottomDetail = new Table(new String[] { "name", "value" });
		for (int i = 0; i < names.length; i++) {
			bottomDetail.withRow(names[i],values[i]);
		}

		List<String> barName = Arrays.asList("油系统性能", "振动信号性能", "历史性能");
		List<Double> barValue = Arrays.asList(
				(double) govAssResult4.getSignalSum4(),
				(double) govAssResult4.getOutput(),
				(double) govAssResult4.getState());
		BarData middleBar = BarData.create("调速系统评估结果", "", "性能状态", "得分",
				barName, barValue);
		double govSum = govAssResult4.getState();
		String topRemark = (govSum > 60) ? ((govSum >= 80) ? "优秀" : "合格")
				: "严重";
		assessView = new AssessView(govAssResult4.getOutput(), topRemark,
				govAssResult4.getHistory()+"",
				govAssResult4.getHistory()+"",
				govAssResult4.getState()+"" , bottomDetail, middleBar);
		return super.execute();
	}

	public AssessView getAssessView() {
		return assessView;
	}

}
