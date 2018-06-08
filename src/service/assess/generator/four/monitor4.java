package service.assess.generator.four;

import bll.FloatAssessment;

public class monitor4 {

	//4号机组机组监测电气量总得分


	public double monitor4(long time){
			
		
			//励磁电压
			FloatAssessment float802=new FloatAssessment();
			int U2=float802.FloatAssess(802,time, 600, 150);
			//机组频率
			FloatAssessment float943=new FloatAssessment();
			int U3=float943.FloatAssess(943,time, 0, 60);
			double a=(U2+U3)/2;
			return a;
			// System.out.println(a);
		}
}
