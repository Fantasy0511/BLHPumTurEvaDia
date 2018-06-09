package service.assess.pumptur.one.output;

import service.assess.pumptur.one.Vibration1.SwingAss;
import service.assess.pumptur.one.other1.GuideVane1;
import service.assess.pumptur.one.other1.History1;
import service.assess.pumptur.one.other1.MainShaftSeal1;
import service.assess.pumptur.one.temperature.TemperatureAss;

public class PumpAssSum {
	public PumpAssResult getPumpAssSum(long time) {
		// 水轮机导叶打分
		GuideVane1 guideVane = new GuideVane1();
		double U1 = guideVane.GuideVane(time);
		// 历史打分
		History1 history = new History1();
		double U2 = history.History(time);
		// 主轴密封
		MainShaftSeal1 mainShaftSeal = new MainShaftSeal1();
		double U3 = mainShaftSeal.MainShaftSeal(time);
		// 振动打分
		SwingAss swingAss = new SwingAss();
		double U4 = swingAss.getSwingAssResult(time);//标记.int转double
		// 温度打分
		TemperatureAss temperatureAss = new TemperatureAss();
		double U5 = temperatureAss.getTemperatureAss(time);
		// 正常来说权重比例应该是由判断矩阵算出来的
		double U6 = 0.090 * U1 + 0.055 * U2 + 0.110 * U3 + 0.475 * U4
				+ 0.263 * U5;
		PumpAssResult pumpAssResult = new PumpAssResult(U1, U2, U3, U4, U5, U6);
		return pumpAssResult;
	}

}