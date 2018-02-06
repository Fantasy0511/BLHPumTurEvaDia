package service.assess.Governor.one.FaultSignal;

import java.util.ArrayList;
import java.util.List;

//调速故障信号得分//真的不想改了、、、、、
public class SignalSum {
	/**
	 * U1 调速器故障次数 U2 油泵故障次数 U3 超速报警次数
	 */
	public List<Number> getSignalSum(long time) {
		List<Number> singleList = new ArrayList<>();
		GeneratorTrip GT = new GeneratorTrip();
		int U1 = GT.GeneratorTrip(time);
		OilTank OT = new OilTank();
		int U2 = OT.getOilTank(time);
		OverspeedAlarm OA = new OverspeedAlarm();
		int U3 = OA.OverspeedAlarm(time);
		double score = 0.15 * U1 + 0.45 * U2 + 0.4 * U3;
		singleList.add(U1);
		singleList.add(U2);
		singleList.add(U3);
		singleList.add(score);
		return singleList;
	}

	public static void main(String[] args) {
		SignalSum a = new SignalSum();
		System.out.println(a.getSignalSum(1441400000));
	}

}
