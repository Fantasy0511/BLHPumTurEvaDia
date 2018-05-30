package service.assess.transformer.one.thrid;

import bll.BoolAssess;

public class Malfunction {
	// 主变故障信号
	public double getMalfunction(long time) {

		// 主变重瓦斯跳闸
		BoolAssess boolAssess = new BoolAssess();
		int U1 = boolAssess.BooleanAssess(1410, time);
		// 主变油位高报警
		int U2 = boolAssess.BooleanAssess(1415, time);
		// 机组电气停机报警
		int U3 = boolAssess.BooleanAssess(1412, time);
		double a = (U1 + U2 + U3) / 3;
		return a;
	}
}