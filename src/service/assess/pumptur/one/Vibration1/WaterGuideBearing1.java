package service.assess.pumptur.one.Vibration1;

import bll.BoolAssess;
import bll.FloatAssessment;

//水导轴承得分
public class WaterGuideBearing1 {

	public int WaterGuideBearing(long time){
		//水导轴承X轴摆动跳闸 
			
//		BoolAssess bool1091=new BoolAssess();
//		int U1=bool1091.BooleanAssess(1091,time);
		
		//水导轴承Y轴摆动跳闸
//		BoolAssess bool1092=new BoolAssess();
//		int U2=bool1092.BooleanAssess(1092,time);
	
		//水导轴承Z轴摆动跳闸
//		BoolAssess bool1093=new BoolAssess();
//		int U3=bool1093.BooleanAssess(1093,time);
				
				
		//水导轴承X轴摆动速率
		FloatAssessment float328=new FloatAssessment();
		int U4=float328.FloatAssess(328,time, 20, 0);
		//水导轴承Y轴摆动速率
//		FloatAssessment float984=new FloatAssessment();
//		int U5=float984.FloatAssess(984,time, 20, 0);
		//水导轴承Z轴摆动速率
//		FloatAssessment float985=new FloatAssessment();
//		int U6=float985.FloatAssess(985,time, 20, 0);
		
		
		int a=U4;
		return a;
		// System.out.println(a);
	}
}
