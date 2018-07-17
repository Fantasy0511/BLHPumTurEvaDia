package service.assess.Governor.one.FaultSignal;

//机组保护跳机

import bll.BoolAssess;

public class GeneratorTrip {
	public int GeneratorTrip(long time){
    //1号机组.调速器.SP小于50%
	BoolAssess bool197=new BoolAssess();
	int U1=bool197.BooleanAssess(197,time);
	
	//1号机组.调速器.SP小于30%
	BoolAssess bool198=new BoolAssess();
	int U2=bool198.BooleanAssess(198,time);

	//1号机组.调速器.SP小于5%
	BoolAssess bool199=new BoolAssess();
	int U3=bool199.BooleanAssess(199,time);
	int score=(U1+U2+U3)/3;
	
    return score;
	
}
}