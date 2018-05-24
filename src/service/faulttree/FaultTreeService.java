package service.faulttree;

import java.util.ArrayList;
import java.util.List;

import bll.diagnosis.tree.model.Fault;
import bll.diagnosis.tree.model.FaultDiagnosis;
import bll.diagnosis.tree.model.FaultResult;
import bll.diagnosis.tree.model.FaultTreeMain;

/**
 * 创建故障树服务返回故障对应的ID值 参考仿真服务
 * 
 * @author wuyue
 */
public class FaultTreeService {
	List<FaultResult> result = new ArrayList<>();
	private static FaultDiagnosis faultDiagnosis;

	public List<FaultResult> findfault() {
		String nowtime = "";
		java.text.Format format = new java.text.SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		nowtime = format.format(new java.util.Date());
		FaultTreeMain faulttree = new FaultTreeMain();
		result = faulttree.FaultTreeDiagnosis(1, "1", "1", nowtime);
		ArrayList<Fault> faults = faultDiagnosis.TSFaultsRead();
		return result;
	}
}
