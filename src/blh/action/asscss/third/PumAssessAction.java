package blh.action.asscss.third;

import java.util.Arrays;
import java.util.List;

import org.apache.struts2.convention.annotation.Result;

import blh.action.asscss.AssessView;
import blh.action.asscss.SonAssessView;
import blh.action.support.AbstractActionSupport;
import service.assess.pumptur.three.output.PumpAssResult;
import service.assess.pumptur.three.output.PumpAssSum;
import tool.easyui.Table;
import tool.exception.JudgeTime;
import tool.highcharts.BarData;
import tool.highcharts.PieData;
import util.TimeUtils;

@Result(type = "json")
public class PumAssessAction extends AbstractActionSupport {

	private static final long serialVersionUID = 1L;
	private AssessView assessView;
	private SonAssessView sonAssessView;
	private PumpAssResult pumpAssResult;
	private String judgeResult;
	
	@Override
	public String execute() throws Exception {
		String timeString = getFirstInput();
		String time2 = getFirstInput().toString() + " 00:00:00";
		System.out.println(timeString);
		Long time = TimeUtils.StringtoLong(timeString + " 00:00:00");

		// 判断输入的时间是否能在数据库中找到相应表格
		JudgeTime jt = new JudgeTime();
		judgeResult = jt.judgeTime(time2);				
		
		PumpAssSum pumpAssSum = new PumpAssSum();
		pumpAssResult = pumpAssSum.getPumpAssSum(time);
		
		// 前端的“详细评估信息”里面的内容——对象：bottomDetail
				String[] category = {
			            "主轴密封状态", "", "","", "振动状态", "", "","","","","","","","","温度状态", "", "","","","","",""
						  };
				String[] names = { 
						"供水流量", "供水温度", "过滤器前压力", "过滤器后压力",
						"主轴X轴摆动跳闸 ","主轴Y轴摆动跳闸 ","主轴X轴位移","主轴Y轴位移","水导轴承X轴摆动跳闸 ","水导轴承Y轴摆动跳闸",
						"水导轴承Z轴摆动跳闸","水导轴承X轴摆动速率","水导轴承Y轴摆动速率","水导轴承Z轴摆动速率",
						"上导冷却水出水温度", "上导轴瓦温度", "上导油槽温度","下导冷却水出水温度","下导轴瓦温度","下导油槽温度"};
				double[] values = { 
						(double) pumpAssResult.getWaterFlow(),
						(double) pumpAssResult.getWaterTemperature(), 
						(double) pumpAssResult.getBeforeStress(),
						(double) pumpAssResult.getAfterStress(),
						
						 pumpAssResult.getSwingAss().get(0).doubleValue(),
						 pumpAssResult.getSwingAss().get(1).doubleValue(),
					     pumpAssResult.getSwingAss().get(2).doubleValue(),
						 pumpAssResult.getSwingAss().get(3).doubleValue(),
						 pumpAssResult.getSwingAss().get(4).doubleValue(),
						 pumpAssResult.getSwingAss().get(5).doubleValue(),
						 pumpAssResult.getSwingAss().get(6).doubleValue(),
						 pumpAssResult.getSwingAss().get(7).doubleValue(),
					     pumpAssResult.getSwingAss().get(8).doubleValue(),
						 pumpAssResult.getSwingAss().get(9).doubleValue(),
						 
						(double) pumpAssResult.getUpperWater(),
						(double) pumpAssResult.getUpperBearing(),
						(double) pumpAssResult.getUpperOil(),
						(double) pumpAssResult.getLowerWater(),
						(double) pumpAssResult.getLowerBearing(),
						(double) pumpAssResult.getLowerOil()
						};
				Table bottomDetail = new Table(new String[] {"category","name", "value" });
				for (int i = 0; i < names.length; i++) {
					bottomDetail.withRow(category[i],names[i], values[i]);
				}

		//前端的“柱状图”里面的内容——对象middleBar
		List<String> barName = Arrays.asList("主轴密封状态得分", "水泵水轮机振动状态得分", "历史性能",
				"水泵水轮机温度状态得分");
		List<Double> barValue = Arrays.asList(
				(double) pumpAssResult.getMainShaftSeal(),
				(double) pumpAssResult.getSwingAss().get(10),
				(double) pumpAssResult.getHistory(),
				(double) pumpAssResult.getTemperatureAss());
		BarData middleBar = BarData.create("水泵水轮机系统评估结果", "", "性能状态", "得分",
				barName, barValue);
		
		//前端的“仪表盘”里面的内容——对象：topRemark（优秀/合格/严重）
		double pumSum = pumpAssResult.getScore();
		String topRemark = (pumSum > 60) ? ((pumSum >= 80) ? "优秀" : "合格")
				: "严重";
		
		// 小窗口显示的各个水泵水轮机底层指标得分
		  // 主轴密封底层指标得分
		    // 前端的“小窗口柱状图”里面的内容——对象sonMiddleBar
		List<String> sonbarName = Arrays.asList("供水流量得分", "供水温度得分", "过滤器前压力", "过滤器后压力");
		List<Double> sonbarValue = Arrays.asList(
				(double) pumpAssResult.getWaterFlow(),
				(double) pumpAssResult.getWaterTemperature(), 
				(double) pumpAssResult.getBeforeStress(),
				(double) pumpAssResult.getAfterStress());
		List<Double> sonbarValueRatio = Arrays.asList(0.25,0.25,0.25,0.25);
		BarData mainShaftSealBar = BarData.create("主轴密封底层指标得分", "", "性能状态", "得分", sonbarName, sonbarValue);
		PieData mainShaftSealPie = PieData.create("主轴密封底层指标得分", sonbarName, sonbarValueRatio, "得分XXX");
		 // 振动底层指标得分
		List<String> sonbarName1 = Arrays.asList("主轴X轴摆动跳闸 ","主轴Y轴摆动跳闸 ","主轴X轴位移","主轴Y轴位移","水导轴承X轴摆动跳闸 ","水导轴承Y轴摆动跳闸",
				"水导轴承Z轴摆动跳闸","水导轴承X轴摆动速率","水导轴承Y轴摆动速率","水导轴承Z轴摆动速率");
		List<Double> sonbarValue1 = Arrays.asList(
				 pumpAssResult.getSwingAss().get(0).doubleValue(),
				 pumpAssResult.getSwingAss().get(1).doubleValue(),
			     pumpAssResult.getSwingAss().get(2).doubleValue(),
				 pumpAssResult.getSwingAss().get(3).doubleValue(),
				 pumpAssResult.getSwingAss().get(4).doubleValue(),
				 pumpAssResult.getSwingAss().get(5).doubleValue(),
				 pumpAssResult.getSwingAss().get(6).doubleValue(),
				 pumpAssResult.getSwingAss().get(7).doubleValue(),
			     pumpAssResult.getSwingAss().get(8).doubleValue(),
				 pumpAssResult.getSwingAss().get(9).doubleValue());
		List<Double> sonbarValueRatio1 = Arrays.asList(0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1);
		BarData SingleBar = BarData.create("振动底层指标得分", "", "性能状态", "得分", sonbarName1, sonbarValue1);
		PieData SinglePie = PieData.create("振动底层指标得分", sonbarName1, sonbarValueRatio1, "得分XXX");

		//温度底层指标得分
		List<String> sonbarName2 = Arrays.asList("上导冷却水出水温度", "上导轴瓦温度", "上导油槽温度",
					"下导冷却水出水温度","下导轴瓦温度","下导油槽温度");
		List<Double> sonbarValue2 = Arrays.asList(
				(double) pumpAssResult.getUpperWater(),
				(double) pumpAssResult.getUpperBearing(),
				(double) pumpAssResult.getUpperOil(),
				(double) pumpAssResult.getLowerWater(),
				(double) pumpAssResult.getLowerBearing(),
				(double) pumpAssResult.getLowerOil());
		List<Double> sonbarValueRatio2 = Arrays.asList(0.16,0.16,0.16,0.16,0.16,0.16);
		BarData temperatureBar = BarData.create("温度底层指标得分", "", "性能状态", "得分",
					sonbarName2, sonbarValue2);
		PieData temperaturePie = PieData.create("温度底层指标得分", sonbarName2, sonbarValueRatio2, "得分XXX");
		
		
		// 返回总的评估对象“assessView”
		assessView = new AssessView(pumSum, topRemark, pumpAssResult.getMainShaftSeal() + "",
				pumpAssResult.getSwingAss().get(10) + "", pumpAssResult.getHistory() + "",
				pumpAssResult.getTemperatureAss() + "",
				bottomDetail, middleBar);
		

		//返回底层的评估对象“sonAssessView”
				sonAssessView = new SonAssessView(mainShaftSealBar,mainShaftSealPie,SingleBar,SinglePie,temperatureBar,temperaturePie); 
				return super.execute();
	}

	public AssessView getAssessView() {
		return assessView;
	}

	public PumpAssResult getPumpAssResult() {
		return pumpAssResult;
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
