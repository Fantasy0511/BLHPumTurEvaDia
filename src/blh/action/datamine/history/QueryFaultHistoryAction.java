package blh.action.datamine.history;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import blh.action.support.AbstractActionSupport;
import service.FaultInfoService;
import util.FaultUtils;

/**
 * 各子系统故障历史查询
 * 
 * @author wuyue
 *
 */
@Result(type = "json")
@Action("/datamine/history/query-fault-history")  
public class QueryFaultHistoryAction extends AbstractActionSupport {

	private static final long serialVersionUID = 1L;
	private String system;
	private List<FaultUtils> data;

	@Override
	public String execute() throws Exception {
		system = SystemConvert.valueOf(getFirstInput()).getSystem();
		System.out.println(system);
		FaultInfoService faultInfoService = new FaultInfoService();
		data = faultInfoService.getFaultInfos(system);
		return super.execute();
	}

	public List<FaultUtils> getData() {
		return data;
	}

}
