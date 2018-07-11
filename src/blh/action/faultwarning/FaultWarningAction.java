package blh.action.faultwarning;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Result;

import blh.action.support.AbstractActionSupport;
import service.faultWarning.PieChartData;
import service.faultWarning.Result.WarningResultService;
import service.faultWarning.Result.WarnningFinal;
import service.faultWarning.Result.WarnningResult;
import tool.easyui.Table;
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
	private WarnningResult results;
	private WarnningFinal resultFinal;

	@Override
	public String execute() throws Exception {

		starttime = getFirstInput() + " 00:00:00";
		Long starttime1 = TimeUtils.StringtoLong(starttime);
		Long endtime1 = starttime1 + 3600;
		endtime = TimeUtils.LongtoString(endtime1);
		system=getSecondInput();

		System.out.println("开始时间：" + starttime + "  ;  " + "结束时间： " + endtime);

		// 调用service方法
		
		if(system.equals("0") ) {
			WarningResultService warningResultService = new WarningResultService();
			results= warningResultService.faultWarnResult(starttime, endtime);
		}else {
			System.out.println("系统选择：" + system);
			WarningResultService warningResultService = new WarningResultService();
			results = warningResultService.faultWarnResult(starttime, endtime,system); //五个总系统故障概率
		}
		
		List<String> faultName = results.getFaultName();// 获取service层的故障名称
		List<Double> detail = results.getFaultRate(); // 获取故障概率

		Table bottomDetail = new Table(new String[] { "faultName", "detail" });
		List<PieChartData> piedata = new ArrayList<>();
		for (int i = 0; i < detail.size(); i++) {
			Double double1 = detail.get(i);
			NumberFormat num = NumberFormat.getPercentInstance();//将double转百分数
			String rates = num.format(double1);
			bottomDetail.withRow(faultName.get(i), rates);
			
			
			PieChartData pieChartData = new PieChartData(faultName.get(i), double1);// 饼图数据
			piedata.add(pieChartData);
		}

		resultFinal = new WarnningFinal(bottomDetail, piedata);// 储存表格数据和饼图数据

		return super.execute();
	}

	public WarnningFinal getResultFinal() {
		return resultFinal;
	}

	public void setResultFinal(WarnningFinal resultFinal) {
		this.resultFinal = resultFinal;
	}

}
