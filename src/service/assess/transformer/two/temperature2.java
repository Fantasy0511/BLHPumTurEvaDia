package service.assess.transformer.two;

import bll.FloatAssessment;

public class temperature2 {

	//2号机组主变压器温度
	public double temperature2(long time){
			
			//主变油温
			FloatAssessment float1101=new FloatAssessment();
			int U1=float1101.FloatAssess(1101,time, 150, 0);
			//高压侧绕组温度
			FloatAssessment float1104=new FloatAssessment();
			int U2=float1104.FloatAssess(1104,time, 150, 0);
			//冷却器出口水温
			FloatAssessment float1106=new FloatAssessment();
			int U3=float1106.FloatAssess(1106,time, 80, 0);
			double a=(U1+U2+U3)/3;
			return a;
			// System.out.println(a);
		}
}
