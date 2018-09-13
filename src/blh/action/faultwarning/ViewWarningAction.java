package blh.action.faultwarning;

import org.apache.struts2.convention.annotation.Result;

import blh.action.asscss.boolParm.service.boolHistory;
import blh.action.support.AbstractActionSupport;
import service.faultWarning.WarnViewService;
import tool.highcharts.LineData;
import util.TimeUtils;

/**
 * 绘制参数曲线
 * 
 * @author tiandiwei
 *
 */

@Result(type = "json")
public class ViewWarningAction extends AbstractActionSupport {
	private static final long serialVersionUID = 1L;
	
	private WarnViewService aService;
	private LineData getChartComparison;
	@Override
	public String execute() throws Exception {
		String idString=getFirstInput();
		String startTime=getSecondInput()+" 00:00:00";
		String name=getThirdInput();
		String  id=idString.substring(5);
		
		String tableName = "float" + "_" + startTime.split("-")[0]
				+ startTime.split("-")[1];
		aService=new WarnViewService(tableName, TimeUtils.StringtoLong(startTime),id);
		getChartComparison=aService.getComparison(name);
		
		return super.execute();
	}
	public LineData getGetChartComparison() {
		return getChartComparison;
	}
	public void setGetChartComparison(LineData getChartComparison) {
		this.getChartComparison = getChartComparison;
	}

}
