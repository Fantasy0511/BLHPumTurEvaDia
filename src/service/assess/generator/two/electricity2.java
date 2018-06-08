package service.assess.generator.two;

import bll.BoolAssess;

public class electricity2 {

	//2号机组励磁故障信号总得分

		public double electricity2(long time){
			
			//励磁电源故障 
			BoolAssess bool1608=new BoolAssess();
			int U1=bool1608.BooleanAssess(1608,time);
			
		//电压/频率跳闸
			BoolAssess bool606=new BoolAssess();
			int U2=bool606.BooleanAssess(606,time);
		//	晶闸管桥风扇故障
			BoolAssess bool602=new BoolAssess();
			int U3=bool602.BooleanAssess(602,time);
			double a=(U1+U2+U3)/3;
			return a;
	}
}
