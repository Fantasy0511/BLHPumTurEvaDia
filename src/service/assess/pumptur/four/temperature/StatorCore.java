package service.assess.pumptur.four.temperature;

import bll.FloatAssessment;
//定子铁芯得分
public class StatorCore {
	
	public int StatorCore(long time){
		FloatAssessment float923=new FloatAssessment();
		int U1=float923.FloatAssess(923,time, 190, 0);
		
		
		FloatAssessment float917=new FloatAssessment();
		int U2=float917.FloatAssess(917,time, 190, 0);
		
		FloatAssessment float915=new FloatAssessment();
		int U3=float915.FloatAssess(915,time, 190, 0);
		
		int a=(U1+U2+U3)/3;
		return a;
	}
}
