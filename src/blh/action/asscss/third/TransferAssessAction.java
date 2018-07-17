package blh.action.asscss.third;

import java.util.Arrays;
import java.util.List;

import org.apache.struts2.convention.annotation.Result;

import blh.action.asscss.AssessView;
import blh.action.asscss.SonAssessView;
import blh.action.support.AbstractActionSupport;
import service.assess.transformer.TransferAssResult;
import service.assess.transformer.three.output3;
import tool.easyui.Table;
import tool.highcharts.BarData;
import tool.highcharts.PieData;
import util.TimeUtils;

@Result(type = "json")
public class TransferAssessAction extends AbstractActionSupport {

	private static final long serialVersionUID = 1L;
	private AssessView assessView;
	private SonAssessView sonAssessView;

	@Override
	public String execute() throws Exception {
		String timeString = getFirstInput();
		System.out.println("选择时间： " + timeString);
		Long time = TimeUtils.StringtoLong(timeString + " 00:00:00");

		output3 transferAssSum = new output3();
		TransferAssResult transferAssessResult = transferAssSum.output(time);
		
		/**评估主页面数据获取*/
		//评估主页面表格数据
		String[] names = { "主变系统总得分","主变压器温度","主变故障信号","历史和巡检状态",
				"主变油温","高压侧绕组温度","冷却器出口水温","主变重瓦斯跳闸","主变油位高报警",
				"机组电气停机报警"};
		Table bottomDetail = new Table(new String[] { "name", "value" });
		for (int i = 0; i < names.length; i++) {
			bottomDetail.withRow(names[i], transferAssessResult.getFirstIndicator().get(i).doubleValue());
		}
		
		//评估主页面 柱状图
		List<String> barName = Arrays.asList("主变压器温度", "历史和巡检状态", "主变压器故障信号");
		List<Double> barValue = Arrays.asList(transferAssessResult.getFirstIndicator().get(1).doubleValue(),
				transferAssessResult.getFirstIndicator().get(3).doubleValue(),transferAssessResult.getFirstIndicator().get(2).doubleValue());
		//评估主页面 仪表盘
		BarData middleBar = BarData.create("主变系统状态评估结果", "", "性能状态", "得分", barName, barValue);
		double transAss = transferAssessResult.getFirstIndicator().get(0).doubleValue();
		String topRemark = (transAss > 60) ? ((transAss >= 80) ? "优秀" : "合格") : "严重";
		
		//评估主页面数据返回
		assessView = new AssessView(transAss, topRemark, transferAssessResult.getFirstIndicator().get(1).toString(),
				transferAssessResult.getFirstIndicator().get(3).toString(), transferAssessResult.getFirstIndicator().get(2).toString(), bottomDetail, middleBar);

		/**小窗口显示底层指标数据获取*/
		//主变温度底层指标
		List<String> sonBarName1 = Arrays.asList("主变压器油温", "高压侧绕组温度", "冷却器出口水温");
		List<Double> sonbarValue1 = Arrays.asList(		
				transferAssessResult.getTransTemperIndicator().get(0).doubleValue(),
				transferAssessResult.getTransTemperIndicator().get(1).doubleValue(),
				transferAssessResult.getTransTemperIndicator().get(2).doubleValue());
		BarData temperatureBar = BarData.create("温度底层指标得分", "", "性能状态", "得分",sonBarName1, sonbarValue1);
		PieData temperaturePie = PieData.create("主变温度底层指标得分", sonBarName1, sonbarValue1, "得分XXX");
		
		//主变故障指标
		List<String> sonBarName2 = Arrays.asList("主变重瓦斯跳闸", "主变油位高报警", "机组电气停机报警");
		List<Double> sonbarValue2 = Arrays.asList(		
				transferAssessResult.getFaultIndicator().get(0).doubleValue(),
				transferAssessResult.getFaultIndicator().get(1).doubleValue(),
				transferAssessResult.getFaultIndicator().get(2).doubleValue());
		BarData mainShaftSealBar = BarData.create("主轴密封底层指标得分", "", "性能状态", "得分",
				sonBarName2, sonbarValue2);
		PieData mainShaftSealPie = PieData.create("主轴密封底层指标得分", sonBarName2, sonbarValue2, "得分XXX");
		
		sonAssessView = new SonAssessView(mainShaftSealBar,mainShaftSealPie,temperatureBar,temperaturePie);
		
		return super.execute();
	
	}


	public AssessView getAssessView() {
		return assessView;
	}

	public SonAssessView getSonAssessView() {
		return sonAssessView;
	}

	public void setAssessView(AssessView assessView) {
		this.assessView = assessView;
	}

	public void setSonAssessView(SonAssessView sonAssessView) {
		this.sonAssessView = sonAssessView;
	}

	

	

}
