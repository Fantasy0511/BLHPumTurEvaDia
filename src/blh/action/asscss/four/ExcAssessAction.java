package blh.action.asscss.four;

import java.util.Arrays;
import java.util.List;

import org.apache.struts2.convention.annotation.Result;

import blh.action.asscss.AssessView;
import blh.action.asscss.SonAssessView;
import blh.action.support.AbstractActionSupport;
import service.assess.generator.excAssResult;
import service.assess.generator.four.output.GenerAssSum;
import tool.easyui.Table;
import tool.highcharts.BarData;
import tool.highcharts.PieData;
import util.TimeUtils;

@Result(type = "json")
public class ExcAssessAction extends AbstractActionSupport {

	private static final long serialVersionUID = 1L;
	private AssessView assessView;
	private SonAssessView sonAssessView;

	@Override
	public String execute() throws Exception {
		String timeString = getFirstInput();
		System.out.println(timeString);
		Long time = TimeUtils.StringtoLong(timeString + " 00:00:00");

		GenerAssSum generAssSum = new GenerAssSum();
		excAssResult excAssResult = generAssSum.getGenerAssSum(time);

		/** 评估主页面数据获取 */
		// 详细评估信息
		String[] category = {
	            "励磁故障信号", "", "","机组监测电气量", "", "发电机故障信号", "", "","励磁发电系统温度", "", "","灭磁开关动作状态", ""
				  };
		String[] names = { "励磁电源故障", "电压/频率跳闸","晶闸管桥风扇故障", 
				"励磁电压", "机组频率", 
				"转子绝缘报警次数", "发电机停止报警次数", "频率保护报警", 
				"发电机热风温度", "发电机冷风温度", "空冷器出水温度", 
				"励磁电流","励磁电压" };
		Table bottomDetail = new Table(new String[] {"category", "name", "value" });
		for (int i = 0; i < names.length; i++) {
			bottomDetail.withRow(category[i],names[i], excAssResult.getIndicator().get(i+6).doubleValue());
		}

		// 柱状图数据
		List<String> barName = Arrays.asList("励磁故障状态得分", "机组电气量状态得分", "发电机故障状态得分", "发电励磁系统温度得分", "灭磁开关动作得分");
		List<Double> barValue = Arrays.asList(excAssResult.getIndicator().get(1).doubleValue(),
				excAssResult.getIndicator().get(2).doubleValue(), excAssResult.getIndicator().get(3).doubleValue(),
				excAssResult.getIndicator().get(4).doubleValue(), excAssResult.getIndicator().get(5).doubleValue());
		// 分项评估结果项数据
		BarData middleBar = BarData.create("发电机及励磁系统评估结果", "", "性能状态", "得分", barName, barValue);
		// 饼图数据
		double excSum = excAssResult.getIndicator().get(0).doubleValue();
		String topRemark = (excSum > 60) ? ((excSum >= 80) ? "优秀" : "合格") : "严重";

		// 返回评估结果
		assessView = new AssessView(excSum, topRemark, excAssResult.getIndicator().get(2).toString(),
				excAssResult.getIndicator().get(3).toString(), excAssResult.getIndicator().get(4).toString(),
				bottomDetail, middleBar);

		/**小窗口显示底层指标数据获取*/
		//励磁故障状态
		List<String> sonBarName1 = Arrays.asList("励磁电源故障", "电压/频率跳闸", "晶闸管桥风扇故障");
		List<Double> sonbarValue1 = Arrays.asList(		
				excAssResult.getIndicator().get(6).doubleValue(),
				excAssResult.getIndicator().get(7).doubleValue(),
				excAssResult.getIndicator().get(8).doubleValue());
		BarData sonBar1 = BarData.create("励磁故障信号评估", "", "性能状态", "得分",sonBarName1, sonbarValue1);
		PieData sonPie1 = PieData.create("励磁故障信号评估指标得分", sonBarName1, sonbarValue1, "得分XXX");
		
		//机组电气量状态
		List<String> sonBarName2 = Arrays.asList("励磁电压","机组频率");
		List<Double> sonbarValue2 = Arrays.asList(		
				excAssResult.getIndicator().get(9).doubleValue(),
				excAssResult.getIndicator().get(10).doubleValue());
		BarData sonBar2 = BarData.create("机组监测电气量评估指标", "", "性能状态", "得分",
				sonBarName2, sonbarValue2);
		PieData sonPie2 = PieData.create("机组监测电气量评估指标得分", sonBarName2, sonbarValue2, "得分XXX");
		
		//发电机故障
		List<String> sonBarName3 = Arrays.asList("转子绝缘报警次数", "发电机停止报警次数", "频率保护报警");
		List<Double> sonbarValue3 = Arrays.asList(		
				excAssResult.getIndicator().get(11).doubleValue(),
				excAssResult.getIndicator().get(12).doubleValue(),
				excAssResult.getIndicator().get(13).doubleValue());
		BarData sonBar3 = BarData.create("发电机故障信号信号评估", "", "性能状态", "得分",sonBarName3, sonbarValue3);
		PieData sonPie3 = PieData.create("发电机故障信号评估指标得分", sonBarName3, sonbarValue3, "得分XXX");
		
		//励磁发电系统温度
		List<String> sonBarName4 = Arrays.asList("发电机热风温度","发电机冷风温度","空冷器出水温度");
		List<Double> sonbarValue4 = Arrays.asList(		
				excAssResult.getIndicator().get(14).doubleValue(),
				excAssResult.getIndicator().get(15).doubleValue(),
				excAssResult.getIndicator().get(16).doubleValue());
		BarData sonBar4 = BarData.create("励磁发电系统温度评估指标", "", "性能状态", "得分",
				sonBarName2, sonbarValue2);
		PieData sonPie4 = PieData.create("励磁发电系统温度评估指标得分", sonBarName4, sonbarValue4, "得分XXX");
		
		//灭磁开关动作状态
		List<String> sonBarName5 = Arrays.asList("励磁电流","励磁电压");
		List<Double> sonbarValue5 = Arrays.asList(		
				excAssResult.getIndicator().get(17).doubleValue(),
				excAssResult.getIndicator().get(18).doubleValue());
		BarData sonBar5 = BarData.create("灭磁开关动作状态评估指标", "", "性能状态", "得分",
				sonBarName2, sonbarValue2);
		PieData sonPie5 = PieData.create("灭磁开关动作状态评估指标得分", sonBarName5, sonbarValue5, "得分XXX");
		
		sonAssessView = new SonAssessView(sonBar1,sonPie1,sonBar2,sonPie2,sonBar3,sonPie3,sonBar4,sonPie4,sonBar5,sonPie5);
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
