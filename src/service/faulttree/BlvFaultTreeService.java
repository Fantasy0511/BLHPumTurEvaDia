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
public class BlvFaultTreeService {
	List<FaultResult> result = new ArrayList<>();
	private String  system="blv";
	public List<FaultResult> findfault(String date,String untiNo) {
		FaultTreeMain faulttree = new FaultTreeMain();
		result = faulttree.FaultTreeDiagnosis(system,1, "1", untiNo, date);
		System.out.println(result);
		return result;
	}
}
