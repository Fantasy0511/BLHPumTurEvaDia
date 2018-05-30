package service.assess.Governor.one.state;

import java.util.ArrayList;
import java.util.List;

import bll.BoolAssess;
import bll.FloatAssessment;

//调速油系统性能状态得分
public class StateSum {
	private FloatAssessment floatAssessment;
	private BoolAssess boolAssess;

	public StateSum() {
		super();
		this.floatAssessment = new FloatAssessment();
		this.boolAssess = new BoolAssess();
	}

	/**
	 * 油压、油泵油位、油泵油温、压油泵油位、压油泵油压
	 */
	public List<Number> getStateSum(long time) {
		List<Number> oilStateList = new ArrayList<>();
		// 数据库缓存特性 一次性查完一个表
		int U2 = getOilTankOilLevel(time);
		int U5 = getPressureTankPressure(time);
		int U1 = getOilPressure(time);

		int U3 = getOilTankOilTemperature(time);

		int U4 = getPressureOilLevel(time);

		double score = (U1 + U2 + U3 + U4 + U5) / 5;
		oilStateList.add(U1);
		oilStateList.add(U2);
		oilStateList.add(U3);
		oilStateList.add(U4);
		oilStateList.add(U5);
		oilStateList.add(score);
		boolAssess.getAs().closeAll();
		floatAssessment.getAssessment().closeAll();
		return oilStateList;
	}

	public int getOilPressure(long time) {

		int U1 = floatAssessment.FloatAssess(344, time, 300, 0);
		return U1;
	}

	public int getOilTankOilLevel(long time) {

		int U1 = boolAssess.BooleanAssess(215, time);

		int U2 = boolAssess.BooleanAssess(216, time);
		int score = (U1 + U2) / 2;
		return score;
	}

	public int getOilTankOilTemperature(long time) {

		int U1 = floatAssessment.FloatAssess(343, time, 100, 0);
		return U1;
	}

	public int getPressureOilLevel(long time) {

		int U1 = floatAssessment.FloatAssess(345, time, 3000, 0);
		return U1;
	}

	public int getPressureTankPressure(long time) {

		int U1 = boolAssess.BooleanAssess(207, time);
		int U2 = boolAssess.BooleanAssess(208, time);
		int score = (U1 + U2) / 2;
		System.out.println(score);
		return score;
	}
}
