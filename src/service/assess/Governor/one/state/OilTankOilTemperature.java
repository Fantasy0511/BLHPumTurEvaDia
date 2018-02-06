package service.assess.Governor.one.state;

import bll.FloatAssessment;

//调速器油槽油温
public class OilTankOilTemperature {
	
public int OilTankOilTemperature(long time){
		
		FloatAssessment float343=new FloatAssessment();
		int U1=float343.FloatAssess(343,time, 100, 0);
		return U1;
	}

}
