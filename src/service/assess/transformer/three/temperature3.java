package service.assess.transformer.three;

import bll.FloatAssessment;

public class temperature3 {

	//3号机组主变压器温度
	public double temperature3(long time){
			
			//主变油温
			FloatAssessment float1129=new FloatAssessment();
			int U1=float1129.FloatAssess(1129,time, 150, 20);
			//高压侧绕组温度
			FloatAssessment float1132=new FloatAssessment();
			int U2=float1132.FloatAssess(1132,time, 150, 20);
			//冷却器出口水温
			FloatAssessment float1134=new FloatAssessment();
			int U3=float1134.FloatAssess(1134,time, 80, 20);
			double a=(U1+U2+U3)/3;
			return a;
			// System.out.println(a);
		}
}
