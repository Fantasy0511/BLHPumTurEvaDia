package blh.action.faulttree;

import java.util.List;
import org.apache.struts2.convention.annotation.Result;
import blh.action.support.AbstractActionSupport;
import bll.diagnosis.tree.model.FaultResult;
import service.faulttree.FaultTreeService;
import tool.ui.easyui.Table;

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
	private int[] resultNode;
	private String[] columnHeaders = { "faultName", "probality", "describe" };// 故障描述表
	Table faultInfoTable = new Table(columnHeaders);

	@Override
	public String execute() throws Exception {
		String time = getFirstInput() + " 00:00:00";
		System.out.println(time);
		results = new FaultTreeService().findfault(time);
		resultNode = new int[results.size()];
		for (int i = 0; i < results.size(); i++) {
			faultInfoTable.withRow(results.get(i).getName(), results.get(i).getProbability(),
					results.get(i).getRecommendation());
			resultNode[i] = results.get(i).getNode();
		}
		System.out.println("" + resultNode);
		System.out.println("故障列表：" + faultInfoTable);

		return SUCCESS;
	}

	public List<FaultResult> getResults() {
		return results;
	}

	public int[] getResultNode() {
		return resultNode;
	}

	public String[] getColumnHeaders() {
		return columnHeaders;
	}

	public Table getFaultInfoTable() {
		return faultInfoTable;
	}

	public void setResults(List<FaultResult> results) {
		this.results = results;
	}

	public void setResultNode(int[] resultNode) {
		this.resultNode = resultNode;
	}

	public void setColumnHeaders(String[] columnHeaders) {
		this.columnHeaders = columnHeaders;
	}

	public void setFaultInfoTable(Table faultInfoTable) {
		this.faultInfoTable = faultInfoTable;
	}

}
