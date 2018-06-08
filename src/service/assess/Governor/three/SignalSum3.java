package service.assess.Governor.three;

import bll.BoolAssess;

public class SignalSum3 {
	/*3号机组调速故障信号得分*/
	public double SignalSum3(long time){
		//调速器电气过速报警
		BoolAssess bool858=new BoolAssess();
		int U1=bool858.BooleanAssess(858,time);
		//调速器机械过速报警
		BoolAssess bool859=new BoolAssess();
		int U2=bool859.BooleanAssess(859,time);
		//调速器油箱阻塞
		BoolAssess bool860=new BoolAssess();
		int U3=bool860.BooleanAssess(860,time);
		
		double score=0.15*U3+0.45*U1+0.4*U2;
		return score;
	}
}
