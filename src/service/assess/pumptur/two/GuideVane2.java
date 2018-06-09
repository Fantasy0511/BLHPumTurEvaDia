package service.assess.pumptur.two;

import bll.BoolAssess;

public class GuideVane2 {
	//2号机组水泵水轮机导叶得分
	
	public double getGuideVane2(long time) {
		//剪断销状态信号
				BoolAssess bool450 = new BoolAssess();
				double U1 = bool450.BooleanAssess(450, time);
				// 空载开度
				BoolAssess bool445 = new BoolAssess();
				double U2 = bool445.BooleanAssess(445, time);
				double a=(U1+U2)/2;
				return a;
	}
}
