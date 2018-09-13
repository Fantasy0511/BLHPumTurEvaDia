package blh.action.asscss.four;

import java.util.Arrays;
import java.util.List;

import org.apache.struts2.convention.annotation.Result;

import blh.action.asscss.AssessView;
import blh.action.asscss.SonAssessView;
import blh.action.support.AbstractActionSupport;
import service.assess.Governor.four.GovAssResultfour;
import service.assess.Governor.four.output4;
import tool.easyui.Table;
import tool.exception.JudgeTime;
import tool.highcharts.BarData;
import tool.highcharts.PieData;
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
	private SonAssessView sonAssessView;
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
		
		output4 output = new output4();
		GovAssResultfour govAssResult4 = output.getOutput4(time);
		
		//前端的“详细评估信息”里面的内容——对象：bottomDetail
		String[] category = {
	            "调速系统性能状态", "", "","","", "调速故障信号", "", ""
				  };
		double[] values= {
				govAssResult4.getState().get(0).doubleValue(),
				govAssResult4.getState().get(1).doubleValue(),
				govAssResult4.getState().get(2).doubleValue(),
				govAssResult4.getState().get(3).doubleValue(),
				govAssResult4.getState().get(5).doubleValue(),
				govAssResult4.getSignalSum4().get(0).doubleValue(),
				govAssResult4.getSignalSum4().get(1).doubleValue(),
				govAssResult4.getSignalSum4().get(2).doubleValue(),
				};
		String[] names = { "油槽油温", "供油管油压", "压力油罐油位", "调速器油箱油位","补气系统压力罐压力",
				"调速器电气过速报警", "调速器机械过速报警","调速器油箱阻塞"};
		
		Table bottomDetail = new Table(new String[] { "category","name", "value" });
		for (int i = 0; i < names.length; i++) {
			bottomDetail.withRow(category[i],names[i],values[i]);
		}

		//前端的“柱状图”里面的内容——对象middleBar
			List<String> barName = Arrays.asList("调速系统性能状态", "调速故障信号", "历史性能");
			List<Double> barValue = Arrays.asList(
					 govAssResult4.getState().get(5).doubleValue(),
					 govAssResult4.getSignalSum4().get(3).doubleValue(),
					(double) govAssResult4.getHistory());
			BarData middleBar = BarData.create("调速系统评估结果", "", "性能状态", "得分",
						barName, barValue);
				
			//前端的“仪表盘”里面的内容——对象：topRemark（优秀/合格/严重）
			double govSum = govAssResult4.getOutput();
			String topRemark = (govSum > 60) ? ((govSum >= 80) ? "优秀" : "合格")
					: "严重";
			
			// 小窗口显示的各个底层指标得分
			// 油系统底层指标得分
			List<String> sonbarName = Arrays.asList("油槽油温", "供油管油压", "压力油罐油位", "调速器油箱油位","补气系统压力罐压力");
			List<Double> sonbarValue = Arrays.asList(
					govAssResult4.getState().get(0).doubleValue(),
					govAssResult4.getState().get(1).doubleValue(),
					govAssResult4.getState().get(2).doubleValue(),
					govAssResult4.getState().get(3).doubleValue(),
					govAssResult4.getState().get(5).doubleValue());
			// govAssResult.getGovOilResult().get(0)是在数组List<Number>里面获取的，里面的每个值拿出来都是number类型的
			// 这时需要获取这个number的double值，而不是给number转成double ，也转不成
			List<Double> sonbarValueRatio = Arrays.asList(0.25,0.25,0.2,0.15,0.15);
			
			BarData govOilBar = BarData.create("调速系统性能状态底层指标得分", "", "性能状态", "得分", sonbarName, sonbarValue);
			PieData govOilPie = PieData.create("调速系统性能状态底层指标比例", sonbarName, sonbarValueRatio, "得分XXX");
			
			// 振动底层指标得分
			List<String> sonbarName1 = Arrays.asList("调速器电气过速报警", "调速器机械过速报警","调速器油箱阻塞");
			List<Double> sonbarValue1 = Arrays.asList(
					govAssResult4.getSignalSum4().get(0).doubleValue(),
					govAssResult4.getSignalSum4().get(1).doubleValue(),
					govAssResult4.getSignalSum4().get(2).doubleValue());
			List<Double> sonbarValueRatio1 = Arrays.asList(0.15,0.45,0.4);
			BarData govSingleBar = BarData.create("调速故障信号底层指标得分", "", "性能状态", "得分", sonbarName1, sonbarValue1);
			PieData govSinglePie = PieData.create("调速故障信号底层指标得分", sonbarName1, sonbarValueRatio1, "得分XXX");

			
			
	// 返回总的评估对象“assessView”
	assessView = new AssessView(
			govAssResult4.getOutput(), topRemark,
			govAssResult4.getState().get(5).doubleValue()+"",
			govAssResult4.getSignalSum4().get(3).doubleValue()+"",
			govAssResult4.getHistory()+"" , bottomDetail, middleBar);
	
	// 返回底层的评估对象“sonAssessView”
	sonAssessView = new SonAssessView(govOilBar, govOilPie,govSingleBar, govSinglePie,null,null);
			
	return super.execute();
	}

	public AssessView getAssessView() {
		return assessView;
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
