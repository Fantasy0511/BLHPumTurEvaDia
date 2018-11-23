package service.assess.Governor.one.FaultSignal;

import java.util.ArrayList;
import java.util.List;

import bll.BoolAssess;

//调速器过速报警
public class OverspeedAlarm {

	public List<Number> OverspeedAlarm(long time){
		
		BoolAssess OverspeedAlarm=new BoolAssess();
		int U1=OverspeedAlarm.BooleanAssess(212,time);
		int U2=OverspeedAlarm.BooleanAssess(213,time);
	    
		List<Number> aList=new ArrayList<>();
	    aList.add(U1);
	    aList.add(U2);
		
	    return aList;
}
}