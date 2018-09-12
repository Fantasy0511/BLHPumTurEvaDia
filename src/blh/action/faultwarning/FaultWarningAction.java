package blh.action.faultwarning;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.struts2.convention.annotation.Result;

import blh.action.support.AbstractActionSupport;
import service.faultWarning.PieChartData;
import service.faultWarning.warnResultData;
import service.faultWarning.Result.WarningResultService;
import service.faultWarning.Result.WarnningFinal;
import service.faultWarning.Result.WarnningResult;
import tool.easyui.Table;
import tool.highcharts.BarData;
import util.TimeUtils;

/**
 * 故障预警查询
 * 
 * @author tiandiwei
 *
 */
@Result(type = "json")
public class FaultWarningAction extends AbstractActionSupport {

	private static final long serialVersionUID = 1L;
	private String starttime;
	private String endtime;
	private String system="";
	private warnResultData results;
	private WarnningFinal resultFinal;

	@Override
	public String execute() throws Exception {

		starttime = getFirstInput() + " 00:00:00";
		Long starttime1 = TimeUtils.StringtoLong(starttime);
		Long endtime1 = starttime1 + 3600*24;
		endtime = TimeUtils.LongtoString(endtime1);
		system=getSecondInput();

		System.out.println("开始时间：" + starttime + "  ;  " + "结束时间： " + endtime);

		// 调用service方法
		System.out.println("系统选择：" + system);
		WarningResultService warningResultService = new WarningResultService();
		results = warningResultService.systemWarn(starttime, endtime); //五个总系统故障概率
		
		WarnningResult Pro_systems = results.getPro_systems();// 柱状图显示
		List<String>   faultparameter =results.getFaultparameter();// 故障参数
		WarnningResult Pro_fault = results.getPro_fault(); //历史相似故障概率
		

		Table bottomDetail = new Table(new String[] { "faultName", "detail" });
		for (int i = 0; i < Pro_fault.getFaultRate().size(); i++) {
			Double double1 =Pro_fault.getFaultRate().get(i);
			NumberFormat num = NumberFormat.getPercentInstance();//将double转百分数
			String rates = num.format(double1);
			bottomDetail.withRow(Pro_fault.getFaultName().get(i), rates);
		}
		
		Table ParameterTable = new Table(new String[] { "faultName"});
		for (int i = 0; i <faultparameter.size(); i++) {
			String aString =faultparameter.get(i);
			ParameterTable.withRow(aString);
		}
		
		
		// 柱状图数据
		BarData middleBar = BarData.create("", "", "子系统详细故障预警", "故障概率",Pro_systems.getFaultName(), Pro_systems.getFaultRate());

		resultFinal = new WarnningFinal(bottomDetail,ParameterTable,middleBar);// 储存表格数据和柱状图数据

		return super.execute();
	}

	public WarnningFinal getResultFinal() {
		return resultFinal;
	}

	public void setResultFinal(WarnningFinal resultFinal) {
		this.resultFinal = resultFinal;
	}

}
