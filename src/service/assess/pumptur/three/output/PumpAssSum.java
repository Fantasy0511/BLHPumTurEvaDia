package service.assess.pumptur.three.output;

import service.assess.pumptur.three.GuideVane3;
import service.assess.pumptur.three.MainShaftSeal3;
import service.assess.pumptur.three.Vibration3;
import service.assess.pumptur.three.histroy3;
import service.assess.pumptur.three.temperature3;

public class PumpAssSum {
	public PumpAssResult getPumpAssSum(long time) {
		// 2号机组导叶得分
		GuideVane3 guideVane = new GuideVane3();
		double U1 = guideVane.getGuideVane3(time);
		// 2号机历史和巡检状态
		histroy3 history = new histroy3();
		double U2 = history.gethistroy3(time);
		// 2号机组主轴密封得分
		MainShaftSeal3 mainShaftSeal = new MainShaftSeal3();
		double U3 = mainShaftSeal.getMainShaftSeal3(time);
		// 2号水轮机振动打分
		Vibration3 swingAss = new Vibration3();
		double U4 = swingAss.getVibration3(time);
		// 2号机组水泵水轮机温度总得分
		temperature3 temperatureAss = new temperature3();
		double U5 = temperatureAss.gettemperature3(time);
		// 正常来说权重比例应该是由判断矩阵算出来的
		System.out.println("********"+U1+"*****三号机组的导叶打分有问题，数据库查不到值");
		double U6 = 0.263 * U1 + 0.419 * U2 + 0.160 * U3 + 0.097 * U4 + 0.062 * U5;// 打分比例可能存在问题jtl 6.9
		PumpAssResult pumpAssResult = new PumpAssResult(U1, U2, U3, U4, U5, U6);
		return pumpAssResult;
	}

}