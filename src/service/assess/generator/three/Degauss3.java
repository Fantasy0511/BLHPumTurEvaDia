package service.assess.generator.three;

import bll.FloatAssessment;

public class Degauss3 {

	//3号机组灭磁开关动作总得分
	

		public double getDegauss3(long time){
				
				//励磁电流
				FloatAssessment float583=new FloatAssessment();
				int U1=float583.FloatAssess(583,time, 3600, 1200);
				//励磁电压
				FloatAssessment float584=new FloatAssessment();
				int U2=float584.FloatAssess(584,time, 600, 150);
				
				double a=(U1+U2)/2;
				return a;
				// System.out.println(a);

	}
}
