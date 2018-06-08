package service.assess.Governor.four;

import bll.BoolAssess;

public class SignalSum4 {

	/*4号机组调速故障信号得分*/
	public double SignalSum4(long time){
		//调速器电气过速报警
		BoolAssess bool1177=new BoolAssess();
		int U1=bool1177.BooleanAssess(1177,time);
		//调速器机械过速报警
		BoolAssess bool1178=new BoolAssess();
		int U2=bool1178.BooleanAssess(1178,time);
		//调速器油箱阻塞
		BoolAssess bool2191=new BoolAssess();
		int U3=bool2191.BooleanAssess(2191,time);
		
		double score=0.15*U3+0.45*U1+0.4*U2;
		return score;
	}
}
