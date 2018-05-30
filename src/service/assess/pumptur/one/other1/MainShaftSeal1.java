package service.assess.pumptur.one.other1;

import bll.BoolAssess;
import bll.FloatAssessment;

//主轴密封得分
public class MainShaftSeal1 {

	
	public int MainShaftSeal(long time){
		//供水流量
		FloatAssessment float958=new FloatAssessment();
		int U1=float958.FloatAssess(958,time, 452, 0);
		//供水温度
		FloatAssessment float962=new FloatAssessment();
		int U2=float962.FloatAssess(962,time, 190, 0);
		//过滤器前压力
		FloatAssessment float959=new FloatAssessment();
		int U3=float959.FloatAssess(959,time, 190, 0);
		//过滤器后压力
		FloatAssessment float960=new FloatAssessment();
		int U4=float960.FloatAssess(960,time, 190, 0);
		
		BoolAssess bool1086=new BoolAssess();
		int U5=bool1086.BooleanAssess(1086,time);
		
		BoolAssess bool1087=new BoolAssess();
		int U6=bool1087.BooleanAssess(1087,time);
		
		BoolAssess bool1088=new BoolAssess();
		int U7=bool1088.BooleanAssess(1088,time);
		
		int a=(U1+U2+U3+U4+U5+U6+U7)/7;
		return a;
	}
}
