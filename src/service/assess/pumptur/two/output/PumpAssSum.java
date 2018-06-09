package service.assess.pumptur.two.output;

import service.assess.pumptur.two.GuideVane2;
import service.assess.pumptur.two.MainShaftSeal2;
import service.assess.pumptur.two.Vibration2;
import service.assess.pumptur.two.histroy2;
import service.assess.pumptur.two.temperature2;

public class PumpAssSum {
	public PumpAssResult getPumpAssSum(long time) {
		// 2号机组导叶得分
		GuideVane2 guideVane = new GuideVane2();
		double U1 = guideVane.getGuideVane2(time);
		// 2号机历史和巡检状态
		histroy2 history = new histroy2();
		double U2 = history.gethistroy2(time);
		// 2号机组主轴密封得分
		MainShaftSeal2 mainShaftSeal = new MainShaftSeal2();
		double U3 = mainShaftSeal.getMainShaftSeal2(time);
		// 2号水轮机振动打分
		Vibration2 swingAss = new Vibration2();
		double U4 = swingAss.getVibration2(time);
		// 2号机组水泵水轮机温度总得分
		temperature2 temperatureAss = new temperature2();
		double U5 = temperatureAss.gettemperature2(time);
		// 正常来说权重比例应该是由判断矩阵算出来的
		double U6 = 0.263 * U1 + 0.419 * U2 + 0.160 * U3 + 0.097 * U4 + 0.062 * U5;// 打分比例可能存在问题jtl 6.9
		PumpAssResult pumpAssResult = new PumpAssResult(U1, U2, U3, U4, U5, U6);
		return pumpAssResult;
	}

}