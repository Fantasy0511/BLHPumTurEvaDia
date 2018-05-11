package blh.action.faultwarning;

import java.util.List;

import org.apache.struts2.convention.annotation.Result;

/**
 *  故障预警图绘制的Action类
 * @author tiandiwei
 *
 */
import blh.action.support.AbstractActionSupport;
import service.faultWarning.PieChartData;
import service.faultWarning.WarnViewService;
import util.TimeUtils;

/**
 * 绘制故障预警饼图Action类
 * 
 * @author tiandiwei
 *
 */

@Result(type = "json")
public class ViewWarningAction extends AbstractActionSupport {
	private static final long serialVersionUID = 1L;
	// 开始时间，结束时间，前端返回 starttime/endTime/paramter
	private String startTime;
	private String endTime;
	private String paramter;
	private String typeid;
	private List<PieChartData> pieChartDatas;

	/*
	 * //注入业务层的类 WarnViewService private WarnViewService WarnViewService;
	 */

	// 继承AbstractActionSupport类，重写execute()方法
	@Override
	public String execute() throws Exception {
		startTime = TimeUtils.DatetoString(TimeUtils
				.AddUnits(TimeUtils.StringtoDate(getFirstInput()), "day", -1));
		endTime = getSecondInput();
		paramter = getThirdInput();
		typeid = paramter.substring(paramter.indexOf("(") + 1,
				paramter.indexOf(")"));
		WarnViewService chartService = new WarnViewService();
		pieChartDatas = chartService.getData(typeid, startTime, endTime);
		System.out.println(pieChartDatas.size());
		return super.execute();
	}

	public List<PieChartData> getPieChartDatas() {
		return pieChartDatas;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public void setParamter(String paramter) {
		this.paramter = paramter;
	}

	public void setTypeid(String typeid) {
		this.typeid = typeid;
	}

}
