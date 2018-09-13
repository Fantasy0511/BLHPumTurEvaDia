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
		Coscal coscal=new Coscal(starttime,endtime);	
		//每个系统发生故障的概率
		HashMap<String, Double> pro_systems = coscal.getSimilarityDegreeOfSystemgs();
		//时间段内发生故障的运行参数（由发生次数多到少排序,只显示前10个）
		ArrayList<ArrayList<String>> faultparameter=coscal.getFaultParameters();
		//时间段内，与当前故障最相近的历史故障，只显示前10个
		HashMap<String, Double> pro_fault = coscal.getFaultSimilarityOfSystemgs();
		faultParaData aData=new faultParaData(faultparameter.get(0), faultparameter.get(1), faultparameter.get(2),faultparameter.get(3),faultparameter.get(4));
		warnResultData warnResult1=new warnResultData( hash2List(pro_systems),aData, hash2List(pro_fault));
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
