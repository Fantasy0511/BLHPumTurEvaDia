package service.assess.pumptur.one.temperature;

import bll.FloatAssessment;

//水导轴承    油温1 966     温度1 967    温度5  968    温度10 972 
public class WaterBearing1 {
	public int WaterBearing(long time){
	// 水导轴承温度
	FloatAssessment float311=new FloatAssessment();
	int U1=float311.FloatAssess(311,time, 190, 0);
	
//	FloatAssessment float967=new FloatAssessment();
//	int U2=float967.FloatAssess(967,time, 190, 0);
//	
//	FloatAssessment float968=new FloatAssessment();
//	int U3=float968.FloatAssess(968,time, 190, 0);
//	
//	FloatAssessment float972=new FloatAssessment();
//	int U4=float972.FloatAssess(972,time, 190, 0);
//	
	int a=U1;
	return a;
}
}