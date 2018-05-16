package service.assess.generator.one.fourth;

import bll.BoolAssess;
import bll.FloatAssessment;

//温度总得分
public class temperature {

public double temperature(long time){
		
	//发电机热风温度 
			BoolAssess bool2179=new BoolAssess();
			int U1=bool2179.BooleanAssess(2179,time);
			
		//发电机冷风温度
			BoolAssess bool2175=new BoolAssess();
			int U2=bool2175.BooleanAssess(2175,time);
		//	空冷器出水温度
			BoolAssess bool2174=new BoolAssess();
			int U3=bool2174.BooleanAssess(2174,time);
			double a=(U1+U2+U3)/3;
			return a;
	}
}
