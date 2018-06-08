package service.assess.Ballvalve.four;

import bll.BoolAssess;

public class Oilsystem4 {

	//4号球阀油系统性能状态
public double Oilsystem4(long time){
		
		//压力油罐油压低报警
		BoolAssess bool1186=new BoolAssess();
		int U1=bool1186.BooleanAssess(1186,time);
		
	//球阀1号油泵故障
		BoolAssess bool1211=new BoolAssess();
		int U2=bool1211.BooleanAssess(1211,time);
	//	球阀2号油泵故障
		BoolAssess bool1216=new BoolAssess();
		int U3=bool1216.BooleanAssess(1216,time);
		double a=(U1+U2+U3)/3;
		return a;
}
}
