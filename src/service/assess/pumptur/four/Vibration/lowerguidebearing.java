package service.assess.pumptur.four.Vibration;

import bll.BoolAssess;
import bll.FloatAssessment;
//下导轴承得分
public class lowerguidebearing {
	
	public int lowerguidebearing(long time){
		//下导轴承X轴摆动跳闸 
			
		BoolAssess bool979=new BoolAssess();
		int U1=bool979.BooleanAssess(979,time);
		
		//下导轴承Y轴摆动跳闸 
		BoolAssess bool980=new BoolAssess();
		int U2=bool980.BooleanAssess(980,time);
		
		//下导轴承X轴位移
		FloatAssessment float852=new FloatAssessment();
		int U3=float852.FloatAssess(852,time, 800, 0);
		//下导轴承Y轴位移
		FloatAssessment float853=new FloatAssessment();
		int U4=float853.FloatAssess(853,time, 800, 0);
		
		int a=(U1+U2+U3+U4)/4;
		return a;
		// System.out.println(a);
	}

}
