package blh.action.faultwarning;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import blh.action.datamine.history.SystemConvert;
import blh.action.support.AbstractActionSupport;
import service.FaultInfoService;
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
	private List<FaultUtils> data;

	@Override
	public String execute() throws Exception {
		system = getFirstInput();
		startTime = TimeUtils.StringtoLong(getSecondInput() + " 00:00:00");
		endTime = TimeUtils.StringtoLong(getThirdInput() + " 00:00:00");
		FaultInfoService faultInfoService = new FaultInfoService();
		data = faultInfoService.getFaultInfos(
				SystemConvert.valueOf(system).getSystem(), startTime, endTime);
		return SUCCESS;
	}

	public List<FaultUtils> getData() {
		return data;
	}

}