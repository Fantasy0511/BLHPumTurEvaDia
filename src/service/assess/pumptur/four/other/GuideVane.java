package service.assess.pumptur.four.other;

import bll.BoolAssess;
import bll.FloatAssessment;

//导叶得分
public class GuideVane {

	public int GuideVane(long time) {

		// 空载开度
		BoolAssess bool1078 = new BoolAssess();
		int U1 = bool1078.BooleanAssess(1078, time);

		// 剪断销状态
		BoolAssess bool1083 = new BoolAssess();
		int U2 = bool1083.BooleanAssess(1083, time);
		// 导叶开度
		FloatAssessment float957 = new FloatAssessment();
		int U3 = float957.FloatAssess(957, time, 190, 0);
		System.out.println(U1);
		System.out.println(U2);
		System.out.println(U3);
		int a = (int) (0.25 * U1 + 0.4 * U2 + 0.35 * U3);
		return a;
	}

	public static void main(String[] args) {

		GuideVane a = new GuideVane();
		System.out.println(a.GuideVane(1441400000));
	}
}
