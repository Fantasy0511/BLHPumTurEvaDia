package service.assess.generator.one.frist;

import bll.BoolAssess;
//励磁故障信号总得分
public class electricity {
	public double electricity(long time){
		
		//励磁电源故障 
		BoolAssess bool1285=new BoolAssess();
		int U1=bool1285.BooleanAssess(1285,time);
		
	//电压/频率跳闸
		BoolAssess bool283=new BoolAssess();
		int U2=bool283.BooleanAssess(283,time);
	//	晶闸管桥风扇故障
		BoolAssess bool279=new BoolAssess();
		int U3=bool279.BooleanAssess(279,time);
		double a=(U1+U2+U3)/3;
		return a;
}
}
