package service.assess.generator.two;

import bll.BoolAssess;

public class malfunction2 {

	//2号发电机故障信号总得分
	

	public double malfunction2(long time){
			
			//转子绝缘报警 
			BoolAssess bool402=new BoolAssess();
			int U1=bool402.BooleanAssess(402,time);
			
		//发电机停止报警
			BoolAssess bool403=new BoolAssess();
			int U2=bool403.BooleanAssess(403,time);
		//	频率保护报警
			BoolAssess bool404=new BoolAssess();
			int U3=bool404.BooleanAssess(404,time);
			double a=(U1+U2+U3)/3;
			return a;
	}
}
