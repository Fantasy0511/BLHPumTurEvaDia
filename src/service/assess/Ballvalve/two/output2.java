package service.assess.Ballvalve.two;

import java.text.DecimalFormat;
import java.util.List;

import service.assess.Ballvalve.one.BallAssessResult;

public class output2 {


	// 2号球阀系统总得分
	public BallAssessResult getOutput2(long time) {
		DecimalFormat df=new DecimalFormat("#.0");
		//球阀油系统性能状态
		Oilsystem2 guideVane = new Oilsystem2();
		List<Number> U1 = guideVane.getOilsystem2(time);
		
		//历史和巡检状态
		histroy2 history = new histroy2();
		double U2 = history.histroy2(time);
		
		//球阀性能状态
		performance2 mainShaftSeal = new performance2();
		List<Number> U3 = mainShaftSeal.getPerformance2(time);
		
		//球阀系统总得分
		double U4 = 0.55 * (double) U1.get(U1.size() - 1) + 0.1* U2 + 0.35 * (double) U3.get(U3.size() - 1) ;
		U4 =Double.parseDouble(df.format(U4));
		
		
		BallAssessResult ballAssessResult=new BallAssessResult(U1, U2, U3, U4);
		return ballAssessResult;
}
}
