package service.assess.generator.four;

import bll.FloatAssessment;

public class Degauss4 {

	//4号机组灭磁开关动作总得分
	

		public double Degauss4(long time){
				
				//励磁电流
				FloatAssessment float801=new FloatAssessment();
				int U1=float801.FloatAssess(801,time, 3600, 1200);
				//励磁电压
				FloatAssessment float802=new FloatAssessment();
				int U2=float802.FloatAssess(802,time, 600, 1500);
				
				double a=(U1+U2)/2;
				return a;
				// System.out.println(a);

	}
}
