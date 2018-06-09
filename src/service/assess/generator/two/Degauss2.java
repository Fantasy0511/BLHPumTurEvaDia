package service.assess.generator.two;

import bll.FloatAssessment;

public class Degauss2 {

	//2号机组灭磁开关动作总得分
	

	public double getDegauss2(long time){
			
			//励磁电流
			FloatAssessment float364=new FloatAssessment();
			int U1=float364.FloatAssess(364,time, 3600, 1200);
			//励磁电压
			FloatAssessment float365=new FloatAssessment();
			int U2=float365.FloatAssess(365,time, 600, 1500);
			
			double a=(U1+U2)/2;
			return a;
			// System.out.println(a);

}
}