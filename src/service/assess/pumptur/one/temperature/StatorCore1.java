package service.assess.pumptur.one.temperature;

import bll.FloatAssessment;
//定子铁芯得分
public class StatorCore1 {
	
	public int StatorCore(long time){
		//定子铁芯温度
		FloatAssessment float270=new FloatAssessment();
		int U1=float270.FloatAssess(270,time, 190, 0);
		
		
//		FloatAssessment float917=new FloatAssessment();
//		int U2=float917.FloatAssess(917,time, 190, 0);
//		
//		FloatAssessment float915=new FloatAssessment();
//		int U3=float915.FloatAssess(915,time, 190, 0);
		
		int a=U1;
		return a;
	}
}
