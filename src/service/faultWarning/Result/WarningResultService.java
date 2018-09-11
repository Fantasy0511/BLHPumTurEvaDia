package service.faultWarning.Result;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import algorithms.cos.Coscal;
import service.faultWarning.warnResultData;

/**
 * 故障预警结果展示
 * @author tiandiwei
 *
 */
public class WarningResultService {

	//每个子系统的故障概率
	public warnResultData systemWarn(String starttime, String endtime)  {
		Coscal coscal=new Coscal();	
		//每个系统发生故障的概率
		HashMap<String, Double> pro_systems = coscal.getSimilarityDegreeOfSystemgs(starttime, endtime);
		//时间段内发生故障的运行参数（由发生次数多到少排序,只显示前10个）
		ArrayList<String> faultparameter=coscal.getFaultParameters(starttime, endtime);
		//时间段内，与当前故障最相近的历史故障，只显示前10个
		HashMap<String, Double> pro_fault = coscal.getFaultSimilarityOfSystemgs(starttime, endtime);
		warnResultData warnResult1=new warnResultData( hash2List(pro_systems),faultparameter, hash2List(pro_fault));
		return warnResult1;
	}
	
	public WarnningResult hash2List(HashMap<String, Double> hashMap) {
		List<Double> faultRate=new ArrayList<>(); //故障概率
		List<String> faultName=new ArrayList<>(); //故障名称
		for ( HashMap.Entry<String, Double> entry: hashMap.entrySet()) {
			faultName.add(entry.getKey());
			faultRate.add(entry.getValue());
		};
		WarnningResult warnResult1=new WarnningResult( faultName, faultRate);//表格数据
		return warnResult1;
	}

}
