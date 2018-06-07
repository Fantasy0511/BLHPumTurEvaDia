package service.assess.Governor.one.state;

import bll.BoolAssess;
import bll.FloatAssessment;

//调速器油箱油位
public class OilTankOilLevel {

public int OilTankOilLevel(long time){
		
	BoolAssess bool215=new BoolAssess();
	int U1=bool215.BooleanAssess(215,time);
	
	BoolAssess bool216=new BoolAssess();
	int U2=bool216.BooleanAssess(216,time);
	int score=(U1+U2)/2;
    return score;
}}
