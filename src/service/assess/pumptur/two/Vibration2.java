package service.assess.pumptur.two;

import bll.BoolAssess;
import bll.FloatAssessment;

public class Vibration2 {
	//2号机组水泵水轮机振动得分
	
	public double Vibration2(long time){
		
        //主轴X轴摆动跳闸 

		BoolAssess bool441=new BoolAssess();
		int U1=bool441.BooleanAssess(441,time);
		
		//主轴Y轴摆动跳闸 
		BoolAssess bool442=new BoolAssess();
		int U2=bool442.BooleanAssess(442,time);
		
		//主轴X轴位移
		FloatAssessment float545=new FloatAssessment();
		int U3=float545.FloatAssess(545,time, 800, 0);
		//主轴Y轴位移
		FloatAssessment float546=new FloatAssessment();
		int U4=float546.FloatAssess(546,time, 800, 0);
		
		//水导轴承X轴摆动跳闸 
		
		BoolAssess bool438=new BoolAssess();
		int U5=bool438.BooleanAssess(438,time);
		
		//水导轴承Y轴摆动跳闸
		BoolAssess bool439=new BoolAssess();
		int U6=bool439.BooleanAssess(439,time);
	
		//水导轴承Z轴摆动跳闸
		BoolAssess bool440=new BoolAssess();
		int U7=bool440.BooleanAssess(440,time);
				
				
		//水导轴承X轴摆动速率
		FloatAssessment float547=new FloatAssessment();
		int U8=float547.FloatAssess(547,time, 20, 0);
		//水导轴承Y轴摆动速率
		FloatAssessment float548=new FloatAssessment();
		int U9=float548.FloatAssess(548,time, 20, 0);
		//水导轴承Z轴摆动速率
		FloatAssessment float549=new FloatAssessment();
		int U10=float549.FloatAssess(549,time, 20, 0);
		
		double score=(U1+U2+U3+U4+U5+U6+U7+U8+U9+U10)/10;
		return score;
		
}
}
