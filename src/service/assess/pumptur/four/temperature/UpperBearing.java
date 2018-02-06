package service.assess.pumptur.four.temperature;

import bll.FloatAssessment;
//上导轴承温度得分
public class UpperBearing {
public int UpperBearing(long time){
	
	FloatAssessment float826=new FloatAssessment();
	int U1=float826.FloatAssess(826,time, 190, 0);
	
	
	FloatAssessment float831=new FloatAssessment();
	int U2=float831.FloatAssess(831,time, 190, 0);
	
	FloatAssessment float837=new FloatAssessment();
	int U3=float837.FloatAssess(837,time, 190, 0);
	
	int a=(U1+U2+U3)/3;
	return a;
}
}
