package service.assess.generator.one.output;

import java.text.DecimalFormat;

import service.assess.generator.one.fifth.Degauss;
import service.assess.generator.one.fourth.temperature;
import service.assess.generator.one.frist.electricity;
import service.assess.generator.one.second.monitor;
import service.assess.generator.one.third.malfunction;

//励磁故障信号、机组监测电气量、发电电动机故障信号、温度指标和灭磁开关
public class GenerAssSum {
	// 发电电动机总得分
	public GeneratorAssessResult getGenerAssSum(long time) {
		// 励磁故障信号总得分
		electricity guideVane = new electricity();
		double U1 = guideVane.electricity(time);
		// 机组监测电气量总得分
		monitor history = new monitor();
		double U2 = history.monitor(time);
		// 发电机故障信号总得分
		malfunction mainShaftSeal = new malfunction();
		double U3 = mainShaftSeal.malfunction(time);
		// 温度总得分
		temperature swingAss = new temperature();
		double U4 = swingAss.temperature(time);
		// 灭磁开关动作总得分
		Degauss temperatureAss = new Degauss();
		double U5 = temperatureAss.Degauss(time);
		// 正常来说权重比例应该是由判断矩阵算出来的
		double U6 = 0.475 * U1 + 0.055 * U2 + 0.110 * U3 + 0.090 * U4 + 0.263 * U5;
		// 控制小数点位数
		DecimalFormat df = new DecimalFormat("#.0");
		U6 = Double.parseDouble(df.format(U6));
		
		GeneratorAssessResult generatorAssessResult = new GeneratorAssessResult(U1, U2, U3, U4, U5, U6);
		return generatorAssessResult;
	}
}
