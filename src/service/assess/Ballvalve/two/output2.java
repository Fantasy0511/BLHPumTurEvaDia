package service.assess.Ballvalve.two;

import service.assess.Ballvalve.one.BallAssessResult;

public class output2 {


	// 2号球阀系统总得分
	public BallAssessResult output2(long time) {
		//球阀油系统性能状态
		Oilsystem2 guideVane = new Oilsystem2();
		double U1 = guideVane.Oilsystem2(time);
		//历史和巡检状态
		histroy2 history = new histroy2();
		double U2 = history.histroy2(time);
		//球阀性能状态
		performance2 mainShaftSeal = new performance2();
		double U3 = mainShaftSeal.performance2(time);
		//球阀系统总得分
		
		double U4 = 0.55 * U1 + 0.1* U2 + 0.35 * U3 ;
		BallAssessResult ballAssessResult=new BallAssessResult(U1, U2, U3, U4);
		return ballAssessResult;
}
}
