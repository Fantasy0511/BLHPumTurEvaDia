package service.faultWarning.Result;

import java.util.List;

import service.faultWarning.PieChartData;
import tool.easyui.Table;
/**
 * 封装饼图数据和表格填充数据
 * @author tiandiwei
 *
 */
public class WarnningFinal {
	private Table tableWarn;
	private List<PieChartData> pieWarn;
	
	public WarnningFinal(Table tableWarn, List<PieChartData> pieWarn) {
		super();
		this.tableWarn = tableWarn;
		this.pieWarn = pieWarn;
	}
	public Table getTableWarn() {
		return tableWarn;
	}
	public List<PieChartData> getPieWarn() {
		return pieWarn;
	}
	public void setTableWarn(Table tableWarn) {
		this.tableWarn = tableWarn;
	}
	public void setPieWarn(List<PieChartData> pieWarn) {
		this.pieWarn = pieWarn;
	}
	

	
	
}
