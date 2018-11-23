package service.assess.pumptur.one.output;

import java.text.DecimalFormat;
import java.util.List;

import service.assess.pumptur.one.Vibration1.SwingAss;
import service.assess.pumptur.one.other1.GuideVane1;
import service.assess.pumptur.one.other1.History1;
import service.assess.pumptur.one.other1.MainShaftSeal1;
import service.assess.pumptur.one.temperature.TemperatureAss;
import service.assess.pumptur.son.MainShaftSealResult;
import service.assess.pumptur.son.Temperatureresult1;

public class PumpAssSum {
	public PumpAssResult getPumpAssSum(long time) {
		// 控制小数点
		DecimalFormat df = new DecimalFormat("#.0");

		// 1号机组 水轮机导叶打分
		//GuideVane1 guideVane = new GuideVane1();
		//double U1 = guideVane.GuideVane(time);
		double U1 = 100.0;
		// 1号机组 历史打分
		History1 history = new History1();
		double U2 = history.History(time);
		// 1号机组 主轴密封
		MainShaftSeal1 mainShaftSeal = new MainShaftSeal1();
		MainShaftSealResult result = mainShaftSeal.MainShaftSeal(time);
		int U31 = result.getWaterFlow(); // 供水流量
		int U32 = result.getWaterTemperature(); // 供水温度
		int U33 = result.getBeforeStress(); // 前压力
		int U34 = result.getAfterStress(); // 后压力

		double U3 = result.getScore();

		// 1号机组 振动打分
		SwingAss swingAss = new SwingAss();
		List<Number> U4 = swingAss.getSwingAssResult(time);// 标记.int转double

		// 1号机组 温度打分
		TemperatureAss temperatureAss = new TemperatureAss();
		Temperatureresult1 result1 = temperatureAss.getTemperatureAss(time);
		int U51 = result1.getGeneratorRotor();
		int U52 = result1.getLabyrinthRing();
		int U53 = result1.getLowerBearing();
		int U54 = result1.getStatorCoil();
		int U55 = result1.getStatorCore();
		int U56 = result1.getThrustBearing();
		int U57 = result1.getUpperBearing();
		int U58 = result1.getWaterBearing();

		double U5 = result1.getScore();

		// 正常来说权重比例应该是由判断矩阵算出来的
		double score = 0.097 * U1 + 0.055 * U2 + 0.110 * U3 + (double)U4.get(U4.size() - 1) * 0.475 + 0.263 * U5;
		score=Double.parseDouble(df.format(score));
		
		PumpAssResult pumpAssResult = new PumpAssResult(U1, U2, U3, U4, U5, score, U31, U32, U33, U34, U51, U52, U53, U54,
				U55, U56, U57, U58);
		return pumpAssResult;
	}

}