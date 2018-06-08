package service.assess.Ballvalve.two;

import bll.BoolAssess;

public class Oilsystem2 {
	//2号球阀油系统性能状态
public double Oilsystem2(long time){
		
		//压力油罐油压低报警
		BoolAssess bool544=new BoolAssess();
		int U1=bool544.BooleanAssess(544,time);
		
	//球阀1号油泵故障
		BoolAssess bool568=new BoolAssess();
		int U2=bool568.BooleanAssess(568,time);
	//	球阀2号油泵故障
		BoolAssess bool573=new BoolAssess();
		int U3=bool573.BooleanAssess(573,time);
		double a=(U1+U2+U3)/3;
		return a;
}
	
	
}
