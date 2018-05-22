package service.assess.Ballvalve.one;

import service.assess.Ballvalve.one.frist.Oilsystem;
import service.assess.Ballvalve.one.second.histroy;
import service.assess.Ballvalve.one.third.performance;


public class BallAssSumOut {

		// 球阀系统总得分
		public BallAssessResult getBallAssSum(long time) {
			//球阀油系统性能状态
			Oilsystem guideVane = new Oilsystem();
			double U1 = guideVane.Oilsystem(time);
			//历史和巡检状态
			histroy history = new histroy();
			double U2 = history.histroy(time);
			//球阀性能状态
			performance mainShaftSeal = new performance();
			double U3 = mainShaftSeal.performance(time);
			//球阀系统总得分
			
			double U6 = 0.55 * U1 + 0.1* U2 + 0.35 * U3 ;
			BallAssessResult ballAssessResult=new BallAssessResult(U1, U2, U3, U6); 
			return ballAssessResult;
}
}