package service.assess.generator.two;

import bll.FloatAssessment;

public class monitor2 {

	//2号机组机组监测电气量总得分


	public double getMonitor2(long time){
			
	
			//励磁电压
			FloatAssessment float365=new FloatAssessment();
			int U2=float365.FloatAssess(365,time, 600, 150);
			//机组频率
			FloatAssessment float508=new FloatAssessment();
			int U3=float508.FloatAssess(508,time, 0, 60);
			double a=(U2+U3)/2;
			return a;
			// System.out.println(a);
		}
}
