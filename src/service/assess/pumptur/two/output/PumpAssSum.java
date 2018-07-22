package service.assess.pumptur.two.output;

import java.util.List;

import service.assess.pumptur.son.MainShaftSealResult;
import service.assess.pumptur.son.Temperatureresult2;
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
		MainShaftSealResult result = mainShaftSeal.getMainShaftSeal2(time);
		  int U31 = result.getWaterFlow();            // 供水流量
		  int U32 = result.getWaterTemperature();     // 供水温度
		  int U33 = result.getBeforeStress();         // 前压力
		  int U34 = result.getAfterStress();		   // 后压力
		
		double U3 = result.getScore();
		// 2号水轮机振动打分
		Vibration2 swingAss = new Vibration2();
		List<Number> U4 = swingAss.getVibration2(time);		
		
		
		// 2号机组水泵水轮机温度总得分
		temperature2 temperatureAss = new temperature2();
		Temperatureresult2 result1= temperatureAss.gettemperature2(time);
		int U51 = result1.getUpperWater();
		int U52 = result1.getUpperBearing();
		int U53 = result1.getUpperOil();
		int U54 = result1.getLowerWater();
		int U55 = result1.getLowerBearing();
		int U56 = result1.getLowerOil();
	
		double U5 = result1.getScore();
		
		// 正常来说权重比例应该是由判断矩阵算出来的
		double U6 = 0.263 * U1 + 0.419 * U2 + 0.160 * U3 + 0.097 * (double)U4.get(U4.size() - 1) + 0.062 * U5;// 打分比例可能存在问题jtl 6.9
		PumpAssResult pumpAssResult = new PumpAssResult(U1, U2, U3, U4, U5, U6,U31,U32,U33,U34,U51,U52,U53,U54,U55,U56);
		return pumpAssResult;
	}

}