package service.assess.generator.three;

import bll.BoolAssess;

public class temperature3 {

	//3号机组温度总得分
	

	public double temperature3(long time){
			
		//发电机热风温度 
				BoolAssess bool2408=new BoolAssess();
				int U1=bool2408.BooleanAssess(2408,time);
				
			//发电机冷风温度
				BoolAssess bool2404=new BoolAssess();
				int U2=bool2404.BooleanAssess(2404,time);
			//	空冷器出水温度
				BoolAssess bool2403=new BoolAssess();
				int U3=bool2403.BooleanAssess(2403,time);
				double a=(U1+U2+U3)/3;
				return a;
		}
}
