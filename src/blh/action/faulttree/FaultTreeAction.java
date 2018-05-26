package blh.action.faulttree;

import java.util.List;

import org.apache.struts2.convention.annotation.Result;

import blh.action.support.AbstractActionSupport;
import bll.diagnosis.tree.model.FaultResult;
import service.faulttree.FaultTreeService;

/**
 * 前端调用时间和故障id 返回故障id和故障描述
 * 
 * @author tiandiwei
 *
 */
@Result(type = "json")
public class FaultTreeAction extends AbstractActionSupport {
	private static final long serialVersionUID = 1L;
	private List<FaultResult> results;

	@Override
	public String execute() throws Exception {
		String time = getFirstInput() + " 00:00:00";
		results = new FaultTreeService().findfault(time);
		return super.execute();
	}

	public List<FaultResult> getResults() {
		return results;
	}

	public void setResults(List<FaultResult> results) {
		this.results = results;
	}

}
