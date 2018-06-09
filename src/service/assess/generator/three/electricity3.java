package service.assess.generator.three;

import bll.BoolAssess;

public class electricity3 {

	//3号机组励磁故障信号总得分

			public double getElectricity3(long time){
				
				//励磁电源故障 
				BoolAssess bool1924=new BoolAssess();
				int U1=bool1924.BooleanAssess(1924,time);
				
			//电压/频率跳闸
				BoolAssess bool923=new BoolAssess();
				int U2=bool923.BooleanAssess(923,time);
			//	晶闸管桥风扇故障
				BoolAssess bool927=new BoolAssess();
				int U3=bool927.BooleanAssess(927,time);
				double a=(U1+U2+U3)/3;
				return a;
		}
}
