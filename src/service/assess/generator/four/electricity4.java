package service.assess.generator.four;

import bll.BoolAssess;

public class electricity4 {
	//4号机组励磁故障信号总得分

	public double electricity4(long time){
		
		//励磁电源故障 
		BoolAssess bool1251=new BoolAssess();
		int U1=bool1251.BooleanAssess(1251,time);
		
	//电压/频率跳闸
		BoolAssess bool1249=new BoolAssess();
		int U2=bool1249.BooleanAssess(1249,time);
	//	晶闸管桥风扇故障
		BoolAssess bool1245=new BoolAssess();
		int U3=bool1245.BooleanAssess(1245,time);
		double a=(U1+U2+U3)/3;
		return a;
}
}
