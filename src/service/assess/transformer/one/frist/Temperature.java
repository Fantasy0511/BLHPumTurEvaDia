package service.assess.transformer.one.frist;

import bll.FloatAssessment;

public class Temperature {
	// 主变压器温度
	public double getTemperatures(long time) {

		// 主变油温
		FloatAssessment floatAssessment = new FloatAssessment();
		int U1 = floatAssessment.FloatAssess(1087, time, 150, 0);
		// 高压侧绕组温度
		int U2 = floatAssessment.FloatAssess(1090, time, 150, 0);
		// 冷却器出口水温
		int U3 = floatAssessment.FloatAssess(1092, time, 80, 0);
		double a = (U1 + U2 + U3) / 3;
		return a;
	}
}
