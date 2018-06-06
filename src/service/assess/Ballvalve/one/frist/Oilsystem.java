package service.assess.Ballvalve.one.frist;

import bll.BoolAssess;
//球阀油系统性能状态
public class Oilsystem {

public double Oilsystem(long time){
		
		//压力油罐油压低报警
		BoolAssess bool223=new BoolAssess();
		int U1=bool223.BooleanAssess(223,time);
		
	//球阀1号油泵故障
		BoolAssess bool245=new BoolAssess();
		int U2=bool245.BooleanAssess(245,time);
	//	球阀2号油泵故障
		BoolAssess bool250=new BoolAssess();
		int U3=bool250.BooleanAssess(250,time);
		double a=(U1+U2+U3)/3;
		
		return a;
}
}
