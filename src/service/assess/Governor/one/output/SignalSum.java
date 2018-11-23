package service.assess.Governor.one.output;

import service.assess.Governor.one.FaultSignal.GeneratorTrip;
import service.assess.Governor.one.FaultSignal.OilTank;
import service.assess.Governor.one.FaultSignal.OverspeedAlarm;

//调速故障信号得分
public class SignalSum {

	public double SignalSum(long time) {
		// 调速器电气过速报警
		/*
		 * GeneratorTrip GT = new GeneratorTrip(); int U1 = GT.GeneratorTrip(time);
		 */

		// 调速器机械过速报警
		OverspeedAlarm OA = new OverspeedAlarm();
		int U1 = (int) OA.OverspeedAlarm(time).get(0);
		int U2 = (int) OA.OverspeedAlarm(time).get(1);

		// 调速器油箱阻塞
		OilTank OT = new OilTank();
		int U3 = OT.getOilTank(time);
		double score = 0.15 * U1 + 0.45 * U2 + 0.4 * U3;
		return score;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SignalSum a = new SignalSum();
		System.out.println(a.SignalSum(1441400000));
	}

}
