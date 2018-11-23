package service.assess.Ballvalve.one;

import java.text.DecimalFormat;
import java.util.List;

public class BallAssSumOut {

		// 球阀系统总得分
		public BallAssessResult getBallAssSum(long time) {
			DecimalFormat df=new DecimalFormat("#.0");
			//球阀油系统性能状态
			Oilsystem guideVane = new Oilsystem();
			List<Number> U1 = guideVane.getOilsystem(time);

			//历史和巡检状态
			histroy history = new histroy();
			double U2 = history.histroy(time);
			
			//球阀性能状态
			performance mainShaftSeal = new performance();
			List<Number> U3 = mainShaftSeal.getPerformance(time);
			
			//球阀系统总得分
			double U6 = 0.55 * (double) U1.get(U1.size() - 1) + 0.1* U2 + 0.35 * (double) U3.get(U3.size() - 1) ;
			U6 =Double.parseDouble(df.format(U6));
			
			BallAssessResult ballAssessResult=new BallAssessResult(U1, U2, U3, U6); 
			return ballAssessResult;
}
}