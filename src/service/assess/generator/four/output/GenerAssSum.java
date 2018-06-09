package service.assess.generator.four.output;

import java.text.DecimalFormat;

import service.assess.generator.four.Degauss4;
import service.assess.generator.four.electricity4;
import service.assess.generator.four.malfunction4;
import service.assess.generator.four.monitor4;
import service.assess.generator.four.temperature4;

//励磁故障信号、机组监测电气量、发电电动机故障信号、温度指标和灭磁开关
public class GenerAssSum {
	// 发电电动机总得分
	public GeneratorAssessResult getGenerAssSum(long time) {
		// 励磁故障信号总得分
		electricity4 guideVane = new electricity4();
		double U1 = guideVane.getElectricity4(time);
		// 机组监测电气量总得分
		monitor4 history = new monitor4();
		double U2 = history.getMonitor4(time);
		// 发电机故障信号总得分
		malfunction4 mainShaftSeal = new malfunction4();
		double U3 = mainShaftSeal.getMalfunction4(time);
		// 温度总得分
		temperature4 swingAss = new temperature4();
		double U4 = swingAss.getTemperature4(time);
		// 灭磁开关动作总得分
		Degauss4 temperatureAss = new Degauss4();
		double U5 = temperatureAss.getDegauss4(time);
		// 正常来说权重比例应该是由判断矩阵算出来的
		double U6 = 0.475 * U1 + 0.055 * U2 + 0.110 * U3 + 0.090 * U4 + 0.263 * U5;
		// 控制小数点位数
		DecimalFormat df = new DecimalFormat("#.0");
		U6 = Double.parseDouble(df.format(U6));
		
		GeneratorAssessResult generatorAssessResult = new GeneratorAssessResult(U1, U2, U3, U4, U5, U6);
		return generatorAssessResult;
	}
}
