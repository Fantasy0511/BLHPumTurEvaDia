package blh.action.asscss;

import java.util.Arrays;
import java.util.List;

import org.apache.struts2.convention.annotation.Result;

import blh.action.support.AbstractActionSupport;
import service.assess.transformer.one.TransferAssResult;
import service.assess.transformer.one.TransferAssSum;
import tool.easyui.Table;
import tool.highcharts.BarData;
import util.TimeUtils;

@Result(type = "json")
public class TransferAssessAction extends AbstractActionSupport {

	private static final long serialVersionUID = 1L;
	private AssessView assessView;
	private TransferAssResult transferAssessResult;

	@Override
	public String execute() throws Exception {
		String timeString = getFirstInput();
		System.out.println("选择时间： " + timeString);
		Long time = TimeUtils.StringtoLong(timeString + " 00:00:00");

		TransferAssSum transferAssSum = new TransferAssSum();
		transferAssessResult = transferAssSum.output(time);

		String[] names = { "主变压器温度", "历史和巡检状态", "主变压器故障信号得分" };
		double[] values = { transferAssessResult.getTransTemper(), transferAssessResult.getTransHistory(),
				transferAssessResult.getTransFault() };

		Table bottomDetail = new Table(new String[] { "name", "value" });
		for (int i = 0; i < names.length; i++) {
			bottomDetail.withRow(names[i], values[i]);
		}

		List<String> barName = Arrays.asList("主变压器温度", "历史和巡检状态", "主变压器故障信号");
		List<Double> barValue = Arrays.asList((double) transferAssessResult.getTransTemper(),
				(double) transferAssessResult.getTransHistory(), (double) transferAssessResult.getTransFault());
		BarData middleBar = BarData.create("主变系统状态评估结果", "", "性能状态", "得分", barName, barValue);
		double transAss = transferAssessResult.getTransAssSum();
		String topRemark = (transAss > 60) ? ((transAss >= 80) ? "优秀" : "合格") : "严重";

		assessView = new AssessView(transAss, topRemark, 
				transferAssessResult.getTransTemper()+"", 
				transferAssessResult.getTransHistory()+"", 
				transferAssessResult.getTransFault()+"", 
				bottomDetail,
				middleBar);

		return super.execute();
	}

	public AssessView getAssessView() {
		return assessView;
	}

	public TransferAssResult getTransferAssessResult() {
		return transferAssessResult;
	}

	public void setAssessView(AssessView assessView) {
		this.assessView = assessView;
	}

	public void setTransferAssessResult(TransferAssResult transferAssessResult) {
		this.transferAssessResult = transferAssessResult;
	}

}
