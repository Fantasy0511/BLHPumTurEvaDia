package service.assess.Governor.one.output;

import service.assess.Governor.one.FaultSignal.GeneratorTrip;
import service.assess.Governor.one.FaultSignal.OilTank;
import service.assess.Governor.one.FaultSignal.OverspeedAlarm;

//调速故障信号得分
public class SignalSum {
	
	public double SignalSum(long time){
		GeneratorTrip GT=new GeneratorTrip();
		int U1=GT.GeneratorTrip(time);
	
		OilTank OT =new  OilTank();
		int U2=OT.getOilTank(time);
//		System.out.println(U2);
		OverspeedAlarm OA=new OverspeedAlarm();
		int U3=OA.OverspeedAlarm(time);
//		System.out.println(U3);
		double score=0.15*U1+0.45*U2+0.4*U3;
		return score;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SignalSum a=new SignalSum();
		System.out.println(a.SignalSum(1441400000));
	}

}
