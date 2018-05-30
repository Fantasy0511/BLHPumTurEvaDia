package service.assess.generator.one.fifth;

import bll.FloatAssessment;
//灭磁开关动作总得分
public class Degauss {

public double Degauss(long time){
		
		//励磁电流
		FloatAssessment float145=new FloatAssessment();
		int U1=float145.FloatAssess(145,time, 3600, 0);
		//励磁电压
		FloatAssessment float146=new FloatAssessment();
		int U2=float146.FloatAssess(146,time, 600, 0);
		
		double a=(U1+U2)/2;
		return a;
		// System.out.println(a);
	}
}
