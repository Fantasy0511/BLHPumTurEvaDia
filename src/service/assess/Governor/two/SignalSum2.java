package service.assess.Governor.two;

import bll.BoolAssess;


public class SignalSum2 {
	/*2号机组调速故障信号得分*/
	public double SignalSum2(long time){
		//调速器电气过速报警
		BoolAssess bool533=new BoolAssess();
		int U1=bool533.BooleanAssess(533,time);
		//调速器机械过速报警
		BoolAssess bool534=new BoolAssess();
		int U2=bool534.BooleanAssess(534,time);
		//调速器油箱阻塞
		BoolAssess bool535=new BoolAssess();
		int U3=bool535.BooleanAssess(535,time);
		
		double score=0.15*U3+0.45*U1+0.4*U2;
		return score;
	}
}
