package service.assess.Governor.one.state;

import bll.FloatAssessment;

//压力油罐油位
public class PressureOilLevel {
public int PressureOilLevel(long time){
		
		FloatAssessment float345=new FloatAssessment();
		int U1=float345.FloatAssess(345,time, 3000, 0);
		return U1;
	}
}
