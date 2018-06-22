package service.faultWarning.Result;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import algorithms.cos.Coscal;
import service.FaultInfoService;
import service.faultWarning.PieChartData;
import util.FaultUtils;

/**
 * 故障预警结果展示
 * @author tiandiwei
 *
 */
public class WarningResultService {
	private List<Double> result;
	private List<String>  system; //子系统
	private List<String> faultName;//故障名称
	
	
	public WarnningResult faultWarnResult(String starttime, String endtime)  {
		Coscal coscal=new Coscal();	
		result=coscal.getSimilarityDegree(starttime, endtime);
		
		FaultInfoService faultInfoService = new FaultInfoService();//获取所有的故障信息
		try {
			List<FaultUtils> data = faultInfoService.getFaultInfos();
			system=new ArrayList<>();
			faultName=new ArrayList<>();
			for (int i = 0; i < data.size(); i++) {
				FaultUtils aFaultUtils=data.get(i);
				system.add(aFaultUtils.getSystem());
				faultName.add(aFaultUtils.getFaultName());
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		WarnningResult warnResult=new WarnningResult( system,  faultName,result);//表格数据
		
		
		
		
		
		return warnResult;
	}
	
	
	
	
	



	//测试类
	public static void main(String[] args) {
		WarningResultService aResultService=new WarningResultService();
		WarnningResult ab = aResultService.faultWarnResult("2014-01-01 00:00:00", "2014-01-02 00:00:00");
		System.out.println(ab);
	
	}
	
	

}
