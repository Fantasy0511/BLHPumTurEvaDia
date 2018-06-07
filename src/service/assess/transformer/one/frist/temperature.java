package service.assess.transformer.one.frist;

import bll.FloatAssessment;

public class temperature {
//主变压器温度
public double temperatureA(long time){
		
		//主变油温
		FloatAssessment float1087=new FloatAssessment();
		int U1=float1087.FloatAssess(1087,time, 150, 0);
		//高压侧绕组温度
		FloatAssessment float1090=new FloatAssessment();
		int U2=float1090.FloatAssess(1090,time, 150, 0);
		//冷却器出口水温
		FloatAssessment float1092=new FloatAssessment();
		int U3=float1092.FloatAssess(1092,time, 80, 0);
		double a=(U1+U2+U3)/3;
		return a;
		// System.out.println(a);
	}
}
