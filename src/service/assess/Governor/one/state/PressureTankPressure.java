package service.assess.Governor.one.state;

import bll.BoolAssess;

public class PressureTankPressure {

	public int PressureTankPressure(long time){
		
		BoolAssess bool207=new BoolAssess();
		int U1=bool207.BooleanAssess(207,time);
		
		BoolAssess bool208=new BoolAssess();
		int U2=bool208.BooleanAssess(208,time);
		int score=(U1+U2)/2;
	    return score;
	}
}
