package service.assess.pumptur.three;

import bll.BoolAssess;

public class GuideVane3 {
	//3号机组水泵水轮机导叶得分
	
	public double getGuideVane3(long time) {
		//剪断销状态信号
		BoolAssess bool775 = new BoolAssess();
		double U1 = bool775.BooleanAssess(775, time);
		// 空载开度
		BoolAssess bool770 = new BoolAssess();
		double U2 = bool770.BooleanAssess(770, time);
		double a=(U1+U2)/2;
		return a;
	}
}
