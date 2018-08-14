package blh.action.datamine.history;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Result;

import blh.action.support.AbstractActionSupport;
import service.FaultInfoService;
import util.DataUtils;
import util.HistoryTableUtils;
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
	private String typeid1;
	private Utils data1;
	private String title;
	// private List<String> categories1;
	// private List<String> categories2;

	@Override
	public String execute() throws Exception {

		String startTime1 = getFirstInput();
		String endTime1 = getSecondInput();
		paramter = getThirdInput();
		System.out.println(new String(paramter.getBytes("ISO-8859-1"), "utf-8"));
		
		/*
		 * paramter形如“2号主变.主变冷却器.2号冷却器.故障(bool1466)”
		 * 通过字符串操作获取“(bool1466)”,
		 */
		typeid1 = paramter.substring(paramter.indexOf("(") + 1, paramter.indexOf(")"));
		
		if (typeid1.contains("bool")) {
			startTime = TimeUtils.DatetoString(TimeUtils.AddUnits((TimeUtils.StringtoDate(startTime1)), "day", -30));
			endTime = TimeUtils.DatetoString(TimeUtils.AddUnits((TimeUtils.StringtoDate(endTime1)), "day", +30));
		} else if (typeid1.contains("float")) {
			startTime = TimeUtils.DatetoString(TimeUtils.AddUnits((TimeUtils.StringtoDate(startTime1)), "hours", -6));
			endTime = TimeUtils.DatetoString(TimeUtils.AddUnits((TimeUtils.StringtoDate(endTime1)), "hours", +1));
		}
		
		title = paramter.substring(0, paramter.indexOf("("));
		System.out.println(startTime + "  " + typeid1);

		FaultInfoService service = new FaultInfoService();
		HistoryTableUtils Data1 = service.getUnitInfor(typeid1, startTime, endTime);

		ArrayList<String> timeString = new ArrayList<>();
		for (int i = 0; i < Data1.getDataUtils().getTime().size(); i++) {
			String time = TimeUtils.LongtoString(Data1.getDataUtils().getTime().get(i));
			timeString.add(time);
		}

		data1 = new Utils(timeString, Data1.getDataUtils().getValue(), Data1.getDataUtils().getId(), typeid1,
				Data1.getDescription(), Data1.getUnit());
		System.out.println(typeid1);
		return super.execute();
	}

	public String getTypeid1() {
		return typeid1;
	}

	public String getTitle() {
		return title;
	}

	public void setTypeid1(String typeid1) {
		this.typeid1 = typeid1;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Utils getData1() {
		return data1;
	}

	public void setData1(Utils data1) {
		this.data1 = data1;
	}

}
