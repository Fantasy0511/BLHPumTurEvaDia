package blh.action.asscss;

import java.util.Arrays;
import java.util.List;

import org.apache.struts2.convention.annotation.Result;

import blh.action.support.AbstractActionSupport;
import service.assess.generator.one.output.GenerAssSum;
import service.assess.generator.one.output.GeneratorAssessResult;
import tool.easyui.Table;
import tool.highcharts.BarData;
import util.TimeUtils;

@Result(type = "json")
public class ExcAssessAction extends AbstractActionSupport {

	private static final long serialVersionUID = 1L;
	private AssessView assessView;
	private GeneratorAssessResult excAssResult;

	@Override
	public String execute() throws Exception {
		String timeString =getFirstInput();
		System.out.println(timeString);
		Long time=TimeUtils.StringtoLong(timeString+" 00:00:00");
		
		GenerAssSum generAssSum=new GenerAssSum();
		excAssResult=generAssSum.getGenerAssSum(time);
		
		String[] names= {"励磁故障信号状态得分","机组监测电气量状态得分","发电机故障信号状态得分",
				"励磁发电系统温度状态得分","灭磁开关动作状态得分"};
		double[] values= {excAssResult.getExcFaultSum(),excAssResult.getExcParameter(),
						excAssResult.getDynamoFault(),excAssResult.getTemperatureAss(),
						excAssResult.getSwitchAction()};
		Table bottomDetail=new Table(new String[] {"name","value"});
		for(int i=0;i<names.length;i++) {
			bottomDetail.withRow(names[i],values[i]);
		}
		
		//柱状图数据
		List<String> barName=Arrays.asList("励磁故障状态得分","机组电气量状态得分","发电机故障状态得分",
					"发电励磁系统温度得分","灭磁开关动作得分","历史性能");
		List<Double> barValue=Arrays.asList(
				(double)excAssResult.getExcFaultSum(),
				(double)excAssResult.getExcParameter(),
				(double)excAssResult.getDynamoFault(),
				(double)excAssResult.getTemperatureAss(),
				(double)excAssResult.getSwitchAction(),
				(double)excAssResult.getScore());
		//分项评估结果项数据
		BarData middleBar = BarData.create("发电机及励磁系统评估结果", "", "性能状态", "得分",
				barName, barValue);
		//饼图数据
		double excSum =excAssResult.getScore();
		String topRemark = (excSum > 60) ? ((excSum >= 80) ? "优秀" : "合格")
				: "严重";
		
		//返回评估结果
		assessView=new AssessView(excAssResult.getScore(), topRemark,
				excAssResult.getExcFaultSum()+"", 
				excAssResult.getExcParameter()+"", 
				excAssResult.getScore()+"", 
				bottomDetail, middleBar);
		
		return super.execute();
	}

	public AssessView getAssessView() {
		return assessView;
	}

	public GeneratorAssessResult getExcAssResult() {
		return excAssResult;
	}

}
