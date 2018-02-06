package service.assess.Governor.one.state;


import bll.FloatAssessment;
//调速器供油管油压
public class OilPressure {

	public int OilPressure(long time){
		
		FloatAssessment float344=new FloatAssessment();
		int U1=float344.FloatAssess(344,time, 300, 0);
		return U1;
	}
}
