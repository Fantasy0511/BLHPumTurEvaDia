package blh.action.faultwarning;

import java.util.ArrayList;
import java.util.List;
import org.apache.struts2.convention.annotation.Result;
import blh.action.support.AbstractActionSupport;
import service.faultWarning.PieChartData;
import service.faultWarning.Result.WarningResultService;
import service.faultWarning.Result.WarnningFinal;
import service.faultWarning.Result.WarnningResult;
import tool.easyui.Table;

/**
 * 故障预警查询
 * 
 * @author tiandiwei
 *
 */
@Result(type = "json")
public class FaultWarningAction extends AbstractActionSupport {

	private static final long serialVersionUID = 1L;
	private String starttime;
	private String endtime;
	private WarnningResult  results;
	private WarnningFinal resultFinal;
	private List<PieChartData> piedata;
	
	@Override
	public String execute() throws Exception {
		
		starttime = getFirstInput() + " 00:00:00";
		endtime = getSecondInput() + " 00:00:00";
		System.out.println("开始时间："+ starttime + "  ;  "+"结束时间： "+ endtime);
		
		WarningResultService warningResultService=new WarningResultService();
		results=warningResultService.faultWarnResult(starttime, endtime);
		
		List<String> system=results.getSystem();
		List<String> faultName=results.getFaultName();
		List<Double> detail=results.getWarnResult();
		
		
		Table bottomDetail=new Table(new String[] {"system","faultName","detail"});
		piedata=new ArrayList<>();
		for (int i = 0; i < detail.size(); i++) {
			bottomDetail.withRow(system.get(i),faultName.get(i),detail.get(i));
			
		}
		for (int i = 0; i < detail.size(); i++) {
			PieChartData pieChartData=new PieChartData(faultName.get(i), detail.get(i));//饼图数据
			piedata.add(pieChartData);
		}
		resultFinal=new WarnningFinal(bottomDetail, piedata);
		
		return super.execute();
	}
	
	public WarnningFinal getResultFinal() {
		return resultFinal;
	}
	public void setResultFinal(WarnningFinal resultFinal) {
		this.resultFinal = resultFinal;
	}



	
	

}
