package blh.action.faultwarning;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import blh.action.support.AbstractActionSupport;
import service.FaultInfoService;
import tool.easyui.Table;
import util.FaultUtils;
import util.TimeUtils;

/**
 * 故障预警查询
 * 
 * @author tiandiwei
 *
 */
@Action("/faultWarning/fault-warning")
@Result(type = "json")
public class FaultWarningAction extends AbstractActionSupport {

	private static final long serialVersionUID = 1L;
	private String system;
	private long beginDate;
	private long endDate;
	private Table historyTable;

	@Override
	public String execute() throws Exception {
		system = getFirstInput();
		System.out.println(system);
		beginDate = TimeUtils.StringtoLong(getSecondInput() + "00:00:00");
		endDate = TimeUtils.StringtoLong(getThirdInput() + "00:00:00");
		System.out.println(system + "," + beginDate);
		FaultInfoService faultInfoService = new FaultInfoService();
		List<FaultUtils> data = faultInfoService.getFaultInfos(system,
				beginDate, endDate);
		String[] headers = { "故障名称", "关联参数" };
		historyTable = new Table(headers);
		for (FaultUtils fUtils : data) {
			historyTable.withRow(fUtils);
		}

		return super.execute();
	}

	public Table getHistoryTable() {
		return historyTable;
	}

}
