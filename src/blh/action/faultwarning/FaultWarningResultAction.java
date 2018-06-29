package blh.action.faultwarning;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import blh.action.datamine.history.SystemConvert;
import blh.action.support.AbstractActionSupport;
import service.FaultInfoService;
import tool.easyui.Table;
import util.FaultUtils;
import util.TimeUtils;

/**
 * 子系统故障历史查询，以及故障预警结果展示
 * 
 * @author tiandiwei
 *
 */
@Result(type = "json")
@Action("/faultwarning/fault-warning-result")
public class FaultWarningResultAction extends AbstractActionSupport {

	private static final long serialVersionUID = 1L;
	private String system;
	private Long startTime;
	private Long endTime;
	private Table bottomDetail;

	@Override
	public String execute() throws Exception {
		system = SystemConvert.valueOf(getFirstInput()).getSystem();
		System.out.println(system);
		startTime = TimeUtils.StringtoLong(getSecondInput() + " 00:00:00");
		endTime = TimeUtils.StringtoLong(getThirdInput() + " 00:00:00");
		FaultInfoService faultInfoService = new FaultInfoService();
		List<FaultUtils> data = faultInfoService.getFaultInfos(system, startTime, endTime);
		
		bottomDetail=new Table(new String[] {"system","startTimeString","endTimeString","paramters"});
		for (int i = 0; i < data.size(); i++) {
			bottomDetail.withRow(data.get(i).getSystem(),data.get(i).getStartTimeString(),data.get(i).getEndTimeString(),data.get(i).getParamters());
			
		}
		return SUCCESS;
	}

	public Table getBottomDetail() {
		return bottomDetail;
	}

	public void setBottomDetail(Table bottomDetail) {
		this.bottomDetail = bottomDetail;
	}

	
}
