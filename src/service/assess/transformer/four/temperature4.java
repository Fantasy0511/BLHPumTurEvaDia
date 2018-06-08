package service.assess.transformer.four;

import bll.FloatAssessment;

public class temperature4 {

	//4号机组主变压器温度
	public double temperature4(long time){
			
			//主变油温
			FloatAssessment float1115=new FloatAssessment();
			int U1=float1115.FloatAssess(1115,time, 150, 20);
			//高压侧绕组温度
			FloatAssessment float1118=new FloatAssessment();
			int U2=float1118.FloatAssess(1118,time, 150, 20);
			//冷却器出口水温
			FloatAssessment float1120=new FloatAssessment();
			int U3=float1120.FloatAssess(1120,time, 80, 20);
			double a=(U1+U2+U3)/3;
			return a;
			// System.out.println(a);
		}
}
