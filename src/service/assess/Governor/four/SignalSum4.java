package service.assess.Governor.four;

import java.util.ArrayList;
import java.util.List;

import bll.BoolAssess;

public class SignalSum4 {

	/*4号机组调速故障信号得分*/
	public List<Number> getSignalSum4(long time){
		List<Number> singleList = new ArrayList<>();
		
		//调速器电气过速报警
		BoolAssess bool1177=new BoolAssess();
		int U1=bool1177.BooleanAssess(1177,time);
		//调速器机械过速报警
		BoolAssess bool1178=new BoolAssess();
		int U2=bool1178.BooleanAssess(1178,time);
		//调速器油箱阻塞
		BoolAssess bool2191=new BoolAssess();
		int U3=bool2191.BooleanAssess(2191,time);
		
		double score=0.2*U3+0.4*U1+0.4*U2;
		singleList.add(U1);
		singleList.add(U2);
		singleList.add(U3);
		singleList.add(score);
		
		return singleList;
	}
}
