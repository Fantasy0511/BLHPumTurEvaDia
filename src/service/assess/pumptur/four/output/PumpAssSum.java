package service.assess.pumptur.four.output;

import service.assess.pumptur.four.Vibration.SwingAss;
import service.assess.pumptur.four.other.GuideVane;
import service.assess.pumptur.four.other.History;
import service.assess.pumptur.four.other.MainShaftSeal;
import service.assess.pumptur.four.temperature.TemperatureAss;

public class PumpAssSum {
	public PumpAssResult getPumpAssSum(long time) {
		// 水轮机导叶打分
		GuideVane guideVane = new GuideVane();
		double U1 = guideVane.GuideVane(time);
		// 历史打分
		History history = new History();
		double U2 = history.History(time);
		// 主轴密封
		MainShaftSeal mainShaftSeal = new MainShaftSeal();
		double U3 = mainShaftSeal.MainShaftSeal(time);
		// 振动打分
		SwingAss swingAss = new SwingAss();
		double U4 = swingAss.getSwingAssResult(time);
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