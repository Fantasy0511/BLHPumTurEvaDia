package service.assess.generator.four;

import bll.BoolAssess;

public class malfunction4 {

	//4号发电机故障信号总得分
	

		public double getMalfunction4(long time){
				
				//转子绝缘报警 
				BoolAssess bool1047=new BoolAssess();
				int U1=bool1047.BooleanAssess(1047,time);
				
			//发电机停止报警
				BoolAssess bool1048=new BoolAssess();
				int U2=bool1048.BooleanAssess(1048,time);
			//	频率保护报警
				BoolAssess bool1049=new BoolAssess();
				int U3=bool1049.BooleanAssess(1049,time);
				double a=(U1+U2+U3)/3;
				return a;
		}
}
