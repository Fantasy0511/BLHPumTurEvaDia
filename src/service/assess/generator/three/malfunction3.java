package service.assess.generator.three;

import bll.BoolAssess;

public class malfunction3 {

	//3号发电机故障信号总得分
	

		public double malfunction3(long time){
				
				//转子绝缘报警 
				BoolAssess bool725=new BoolAssess();
				int U1=bool725.BooleanAssess(725,time);
				
			//发电机停止报警
				BoolAssess bool726=new BoolAssess();
				int U2=bool726.BooleanAssess(726,time);
			//	频率保护报警
				BoolAssess bool727=new BoolAssess();
				int U3=bool727.BooleanAssess(727,time);
				double a=(U1+U2+U3)/3;
				return a;
		}
}
