package service.assess.pumptur.one.temperature;

import bll.FloatAssessment;
//上导轴承温度得分
public class UpperBearing1 {
public int UpperBearing(long time){
	// 上导轴承温度
	FloatAssessment float173=new FloatAssessment();
	int U1=float173.FloatAssess(173,time, 190, 0);
	
	
//	FloatAssessment float831=new FloatAssessment();
//	int U2=float831.FloatAssess(831,time, 190, 0);
//	
//	FloatAssessment float837=new FloatAssessment();
//	int U3=float837.FloatAssess(837,time, 190, 0);
	
	int a=U1;
	return a;
}
}
