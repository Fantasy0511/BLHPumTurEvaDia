package service.assess.pumptur.four.temperature;

import bll.FloatAssessment;

public class LowerBearing {
	public int LowerBearing(long time){
	FloatAssessment float840=new FloatAssessment();
	int U1=float840.FloatAssess(840,time, 190, 0);
	
	
	FloatAssessment float844=new FloatAssessment();
	int U2=float844.FloatAssess(844,time, 190, 0);
	
	FloatAssessment float851=new FloatAssessment();
	int U3=float851.FloatAssess(851,time, 190, 0);
	
	int a=(U1+U2+U3)/3;
	return a;
}
}
