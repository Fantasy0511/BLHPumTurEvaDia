package service.assess.Governor.one.FaultSignal;

import bll.BoolAssess;

//调速器过速报警
public class OverspeedAlarm {

	public int OverspeedAlarm(long time){
		
		BoolAssess bool212=new BoolAssess();
		int U1=bool212.BooleanAssess(212,time);
		
		BoolAssess bool213=new BoolAssess();
		int U2=bool213.BooleanAssess(213,time);
		int score=(U1+U2)/2;
	    return score;
}
}