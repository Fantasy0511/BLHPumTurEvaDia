package service.assess.pumptur.one.Vibration1;

import bll.BoolAssess;
import bll.FloatAssessment;

public class UpperBracket1 {
	public int UpperBracket(long time){
		//上机架X轴摆动跳闸 
			
//		BoolAssess bool984=new BoolAssess();
//		int U1=bool984.BooleanAssess(984,time);
		
		//上机架Y轴摆动跳闸
//		BoolAssess bool985=new BoolAssess();
//		int U2=bool985.BooleanAssess(985,time);
	
		//上机架Z轴摆动跳闸
//		BoolAssess bool986=new BoolAssess();
//		int U3=bool986.BooleanAssess(986,time);
				
				
		//上机架X轴位移
//		FloatAssessment float937=new FloatAssessment();
//		int U4=float937.FloatAssess(937,time, 20, 0);
		//上机架Y轴位移
//		FloatAssessment float938=new FloatAssessment();
//		int U5=float938.FloatAssess(938,time, 20, 0);
		//上机架Z轴位移
		FloatAssessment float286=new FloatAssessment();
		int U6=float286.FloatAssess(286,time, 20, 0);
		
		int a=U6;
		return a;
		// System.out.println(a);

	}
}
