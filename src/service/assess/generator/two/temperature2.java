package service.assess.generator.two;

import bll.BoolAssess;

public class temperature2 {

	//2号机组温度总得分
	

	public double temperature2(long time){
			
		//发电机热风温度 
				BoolAssess bool2308=new BoolAssess();
				int U1=bool2308.BooleanAssess(2308,time);
				
			//发电机冷风温度
				BoolAssess bool2304=new BoolAssess();
				int U2=bool2304.BooleanAssess(2304,time);
			//	空冷器出水温度
				BoolAssess bool2303=new BoolAssess();
				int U3=bool2303.BooleanAssess(2303,time);
				double a=(U1+U2+U3)/3;
				return a;
		}
}
