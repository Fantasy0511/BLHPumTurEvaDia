package service.assess.pumptur.one.temperature;

import bll.FloatAssessment;
//推力轴承得分
public class ThrustBearing1 {

	
	public int ThrustBearing(long time){
		// 推力轴承发电温度
		FloatAssessment float854=new FloatAssessment();
		int U1=float854.FloatAssess(854,time, 190, 0);
		
		
		FloatAssessment float858=new FloatAssessment();
		int U2=float858.FloatAssess(858,time, 190, 0);
		
		FloatAssessment float865=new FloatAssessment();
		int U3=float865.FloatAssess(865,time, 190, 0);
		
		int a=(U1+U2+U3)/3;
		return a;
	}
}
