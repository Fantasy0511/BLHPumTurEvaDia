package blh.action.asscss;

import java.util.Arrays;
import java.util.List;

import org.apache.struts2.convention.annotation.Result;

import blh.action.support.AbstractActionSupport;
import service.assess.Governor.one.output.GovAssResult;
import service.assess.Governor.one.output.Output;
import service.assess.pumptur.four.output.PumpAssResult;
import service.assess.pumptur.four.output.PumpAssSum;
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
		Output output = new Output();
		PumpAssSum pumpAssSum = new PumpAssSum();
		GovAssResult govAssResult = output.getGovAssessResult(time);
		PumpAssResult pumpAssResult = pumpAssSum.getPumpAssSum(time);
		String[] names = { "油泵油压", "油槽油位", "油槽油温", "压力油油位", "压油槽油压" };
		Table bottomDetail = new Table(new String[] { "name", "value" });
		for (int i = 0; i < names.length; i++) {
			bottomDetail.withRow(names[i],
					govAssResult.getGovOilResult().get(i));
		}

		List<String> barName = Arrays.asList("油系统性能", "振动信号性能", "历史性能");
		List<Double> barValue = Arrays.asList(
				(double) govAssResult.getGovOilResult().get(5),
				(double) govAssResult.getGovSingleResult().get(3),
				(double) govAssResult.getHistory());
		BarData middleBar = BarData.create("调速系统评估结果", "", "性能状态", "得分",
				barName, barValue);
		double govSum = govAssResult.getGovSum();
		String topRemark = (govSum > 60) ? ((govSum >= 80) ? "优秀" : "合格")
				: "严重";
		assessView = new AssessView(govAssResult.getGovSum(), topRemark,
				govAssResult.getGovOilResult().get(5).toString(),
				govAssResult.getGovSingleResult().get(3).toString(),
				govAssResult.getHistory() + "", bottomDetail, middleBar);
		return super.execute();
	}

	public AssessView getAssessView() {
		return assessView;
	}

}
