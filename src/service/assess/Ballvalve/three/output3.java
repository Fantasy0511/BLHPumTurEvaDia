package service.assess.Ballvalve.three;

import java.text.DecimalFormat;
import java.util.List;

import service.assess.Ballvalve.one.BallAssessResult;

public class output3 {

	// 3号球阀系统总得分
	public BallAssessResult getOutput3(long time) {
		DecimalFormat df = new DecimalFormat("#.0");
		// 球阀油系统性能状态
		Oilsystem3 guideVane = new Oilsystem3();		
		List<Number> U1 = guideVane.getOilsystem3(time);
		
		// 历史和巡检状态
		histroy3 history = new histroy3();
		double U2 = history.histroy3(time);
		
		// 球阀性能状态
		performance3 mainShaftSeal = new performance3();
		List<Number> U3 = mainShaftSeal.getPerformance3(time);
		
		// 球阀系统总得分
		double U4 = 0.55 * (double) U1.get(U1.size() - 1) + 0.1* U2 + 0.35 * (double) U3.get(U3.size() - 1) ;
		U4 =Double.parseDouble(df.format(U4));
		
		BallAssessResult ballAssessResult = new BallAssessResult(U1, U2, U3, U4);
		return ballAssessResult;
	}
}
