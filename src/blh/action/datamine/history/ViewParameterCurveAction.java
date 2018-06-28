package blh.action.datamine.history;

import java.util.ArrayList;
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
	private Utils data1;
	private Utils data2;
	private String title;
//	private List<String> categories1;
//	private List<String> categories2;
	
	@Override
	public String execute() throws Exception {

		String startTime1 = getFirstInput();
		String endTime1 = getSecondInput();
		paramter = getThirdInput();
		System.out.println(new String(paramter.getBytes("8859_1"), "utf-8"));
		typeid1 = paramter.substring(paramter.indexOf("(") + 1,
				paramter.indexOf(")"));
		if (typeid1.contains("bool")) {
			 startTime=TimeUtils.DatetoString(TimeUtils.AddUnits(
					(TimeUtils.StringtoDate(startTime1)), "day", -30));
			 endTime=TimeUtils.DatetoString(TimeUtils.AddUnits(
						(TimeUtils.StringtoDate(endTime1)), "day", +30));
		}
		else if(typeid1.contains("float")) {
			startTime= TimeUtils.DatetoString(TimeUtils.AddUnits(
					(TimeUtils.StringtoDate(startTime1)), "hours", -6));
			endTime=TimeUtils.DatetoString(TimeUtils.AddUnits(
					(TimeUtils.StringtoDate(endTime1)), "hours", +1));
		}
		typeid2 = paramter.substring(paramter.lastIndexOf("(") + 1,
				paramter.lastIndexOf(")"));
		title = paramter.substring(0, paramter.indexOf("("));
		System.out.println(startTime + "  " + typeid1);
		
		FaultInfoService service = new FaultInfoService();
		DataUtils Data1 = service.getData(typeid1, startTime, endTime);
	/*	DataUtils Data2 = service.getData(typeid2, startTime, endTime);*/
		
		ArrayList<String> timeString=new ArrayList<>();
		for (int i = 0; i < Data1.getTime().size(); i++) {
			String time=TimeUtils.LongtoString(Data1.getTime().get(i));
			timeString.add(time);
		}
		
		data1=new Utils(timeString, Data1.getValue(), Data1.getId(), typeid1);
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
