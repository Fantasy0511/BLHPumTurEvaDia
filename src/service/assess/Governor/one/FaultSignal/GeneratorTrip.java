package service.assess.Governor.one.FaultSignal;

//机组保护跳机

import bll.BoolAssess;

public class GeneratorTrip {
	public int GeneratorTrip(long time){
	BoolAssess bool197=new BoolAssess();
	int U1=bool197.BooleanAssess(197,time);
	
	BoolAssess bool198=new BoolAssess();
	int U2=bool198.BooleanAssess(198,time);
	
	BoolAssess bool199=new BoolAssess();
	int U3=bool199.BooleanAssess(199,time);
	int score=(U1+U2+U3)/3;
	
    return score;
	
}
}