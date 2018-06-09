package service.assess.generator.three.output;

import java.text.DecimalFormat;

import service.assess.generator.three.Degauss3;
import service.assess.generator.three.electricity3;
import service.assess.generator.three.malfunction3;
import service.assess.generator.three.monitor3;
import service.assess.generator.three.temperature3;

//励磁故障信号、机组监测电气量、发电电动机故障信号、温度指标和灭磁开关
public class GenerAssSum {
	// 发电电动机总得分
	public GeneratorAssessResult getGenerAssSum(long time) {
		// 励磁故障信号总得分
		electricity3 guideVane = new electricity3();
		double U1 = guideVane.getElectricity3(time);
		// 机组监测电气量总得分
		monitor3 history = new monitor3();
		double U2 = history.getMonitor3(time);
		// 发电机故障信号总得分
		malfunction3 mainShaftSeal = new malfunction3();
		double U3 = mainShaftSeal.getMalfunction3(time);
		// 温度总得分
		temperature3 swingAss = new temperature3();
		double U4 = swingAss.getTemperature3(time);
		// 灭磁开关动作总得分
		Degauss3 temperatureAss = new Degauss3();
		double U5 = temperatureAss.getDegauss3(time);
		// 正常来说权重比例应该是由判断矩阵算出来的
		double U6 = 0.475 * U1 + 0.055 * U2 + 0.110 * U3 + 0.090 * U4 + 0.263 * U5;
		// 控制小数点位数
		DecimalFormat df = new DecimalFormat("#.0");
		U6 = Double.parseDouble(df.format(U6));
		
		GeneratorAssessResult generatorAssessResult = new GeneratorAssessResult(U1, U2, U3, U4, U5, U6);
		return generatorAssessResult;
	}
}
