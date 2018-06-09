package service.assess.generator.three;

import bll.FloatAssessment;

public class monitor3 {

	//3号机组机组监测电气量总得分


	public double getMonitor3(long time){
			
		
			//励磁电压
			FloatAssessment float584=new FloatAssessment();
			int U2=float584.FloatAssess(584,time, 600, 150);
			//机组频率
			FloatAssessment float727=new FloatAssessment();
			int U3=float727.FloatAssess(727,time, 0,60);
			double a=(U2+U3)/2;
			return a;
			// System.out.println(a);
		}
}
