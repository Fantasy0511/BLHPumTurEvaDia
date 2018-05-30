package service.assess.Governor.one.FaultSignal;

import java.util.ArrayList;
import java.util.List;

import bll.BoolAssess;

//调速故障信号得分//真的不想改了、、、、、
public class SignalSum {

	/**
	 * U1 调速器故障次数 U2 油泵故障次数 U3 超速报警次数
	 */

	private BoolAssess boolAssess;

	public SignalSum() {
		super();
		this.boolAssess = new BoolAssess();
	}

	public List<Number> getSignalSum(long time) {
		List<Number> singleList = new ArrayList<>();
		int U1 = getGeneratorTrip(time);
		int U2 = getOilTank(time);
		int U3 = getoverspeedAlarm(time);
		double score = 0.15 * U1 + 0.45 * U2 + 0.4 * U3;
		singleList.add(U1);
		singleList.add(U2);
		singleList.add(U3);
		singleList.add(score);
		boolAssess.getAs().closeAll();
		return singleList;
	}

	public int getGeneratorTrip(long time) {
		int U1 = boolAssess.BooleanAssess(197, time);

		int U2 = boolAssess.BooleanAssess(198, time);

		int U3 = boolAssess.BooleanAssess(199, time);
		int score = (U1 + U2 + U3) / 3;

		return score;

	}

	public int getOilTank(long time) {
		int U1 = boolAssess.BooleanAssess(214, time);
		return U1;
	}

	public int getoverspeedAlarm(long time) {

		int U1 = boolAssess.BooleanAssess(212, time);
		int U2 = boolAssess.BooleanAssess(213, time);
		int score = (U1 + U2) / 2;
		return score;
	}

}
