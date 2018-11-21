package service.assess.pumptur.one.temperature;

import bll.FloatAssessment;
//定子线圈得分
public class StatorCoil1 {


	public int StatorCoil(long time){
		//定子线圈U相温度
//		FloatAssessment float886=new FloatAssessment();
//		int U1=float886.FloatAssess(886,time, 140, -19);
		
		//定子线圈V相
		FloatAssessment float245=new FloatAssessment();
		int U2=float245.FloatAssess(245,time, 140, -19);
		//定子线圈W相
//		FloatAssessment float910=new FloatAssessment();
//		int U3=float910.FloatAssess(910,time, 140, -19);
		
		int a=U2;
		return a;
	}
}
