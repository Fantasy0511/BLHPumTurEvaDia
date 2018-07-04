package service.faultWarning.Result;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import algorithms.cos.Coscal;

/**
 * 故障预警结果展示
 * @author tiandiwei
 *
 */
public class WarningResultService {
	private HashMap<String,Double> result;
	
	public WarnningResult faultWarnResult(String starttime, String endtime)  {
		Coscal coscal=new Coscal();	
		result=coscal.getSimilarityDegreeOfSystemgs(starttime, endtime);
		System.out.println("输出result: "+result);
		
		List<Double> faultRate=new ArrayList<>(); //故障概率
		List<String> faultName=new ArrayList<>(); //故障名称
		for ( HashMap.Entry<String, Double> entry: result.entrySet()) {
			faultName.add(entry.getKey());
			faultRate.add(entry.getValue());
		};
		
		WarnningResult warnResult=new WarnningResult( faultName, faultRate);//表格数据
		
		return warnResult;
	}
	
	//测试类
	public static void main(String[] args) {
		WarningResultService aResultService=new WarningResultService();
		WarnningResult ab = aResultService.faultWarnResult("2014-01-01 00:00:00", "2014-01-02 00:00:00");
		System.out.println(ab);
	
	}
	
	

}
