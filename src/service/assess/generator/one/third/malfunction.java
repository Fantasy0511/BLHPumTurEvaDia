package service.assess.generator.one.third;

import bll.BoolAssess;

//发电机故障信号总得分
public class malfunction {

public double malfunction(long time){
		
		//转子绝缘报警 
		BoolAssess bool85=new BoolAssess();
		int U1=bool85.BooleanAssess(85,time);
		
	//发电机停止报警
		BoolAssess bool86=new BoolAssess();
		int U2=bool86.BooleanAssess(86,time);
	//	频率保护报警
		BoolAssess bool87=new BoolAssess();
		int U3=bool87.BooleanAssess(87,time);
		double a=(U1+U2+U3)/3;
		return a;
}
}
