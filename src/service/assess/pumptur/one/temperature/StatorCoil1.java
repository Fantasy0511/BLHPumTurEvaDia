package service.assess.pumptur.one.temperature;

import bll.FloatAssessment;
//定子线圈得分
public class StatorCoil1 {


	public int StatorCoil(long time){
		//U相
		FloatAssessment float886=new FloatAssessment();
		int U1=float886.FloatAssess(886,time, 140, -19);
		
		//V相
		FloatAssessment float898=new FloatAssessment();
		int U2=float898.FloatAssess(898,time, 140, -19);
		//W相
		FloatAssessment float910=new FloatAssessment();
		int U3=float910.FloatAssess(910,time, 140, -19);
		
		int a=(U1+U2+U3)/3;
		return a;
	}
}
