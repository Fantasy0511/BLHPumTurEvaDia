package blh.action.datamine.history;

import java.util.List;

import org.apache.struts2.convention.annotation.Result;

import blh.action.support.AbstractActionSupport;
import service.FaultInfoService;
import util.DataUtils;
import util.TimeUtils;

/**
 * 查看参数曲线
 * 
 * @author wuyue
 *
 */
@Result(type = "json")
public class ViewParameterCurveAction extends AbstractActionSupport {
	private static final long serialVersionUID = 1L;
	// 开始时间，结束时间，前端返回参数，类型
	private String startTime;
	private String endTime;
	private String paramter;
	private String typeid1, typeid2;
	private DataUtils data1;
	private DataUtils data2;
	private String title;
//	private List<String> categories1;
//	private List<String> categories2;

	@Override
	public String execute() throws Exception {

		startTime = TimeUtils.DatetoString(TimeUtils.AddUnits(
				(TimeUtils.StringtoDate(getFirstInput())), "day", -1));
		endTime = getSecondInput();
		paramter = getThirdInput();
		System.out.println(new String(paramter.getBytes("8859_1"), "utf-8"));
		typeid1 = paramter.substring(paramter.indexOf("(") + 1,
				paramter.indexOf(")"));
		typeid2 = paramter.substring(paramter.lastIndexOf("(") + 1,
				paramter.lastIndexOf(")"));
		title = paramter.substring(0, paramter.indexOf("("));
		System.out.println(startTime + "  " + typeid1);
		FaultInfoService service = new FaultInfoService();
		data1 = service.getData(typeid1, startTime, endTime);
		data2 = service.getData(typeid2, startTime, endTime);
		List<Long> time = data1.getTime();
//		categories1.add(TimeUtils.getTimeInteval(startTime, endTime));
		return super.execute();
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

	public DataUtils getData1() {
		return data1;
	}

	public DataUtils getData2() {
		return data2;
	}

	public String getTitle() {
		return title;
	}

}
