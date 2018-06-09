package service.assess.generator.two.output;

import java.text.DecimalFormat;

import service.assess.generator.two.Degauss2;
import service.assess.generator.two.electricity2;
import service.assess.generator.two.malfunction2;
import service.assess.generator.two.monitor2;
import service.assess.generator.two.temperature2;

//励磁故障信号、机组监测电气量、发电电动机故障信号、温度指标和灭磁开关
public class GenerAssSum {
	// 发电电动机总得分
	public  GeneratorAssessResult  getGenerAssSum(long time) {
		//励磁故障信号总得分
		electricity2 guideVane = new electricity2();
		double U1 = guideVane.getElectricity2(time);
		//机组监测电气量总得分
		monitor2 history = new monitor2();
		double U2 = history.getMonitor2(time);
		//发电机故障信号总得分
		malfunction2 mainShaftSeal = new malfunction2();
		double U3 = mainShaftSeal.getMalfunction2(time);
		//温度总得分
		temperature2 swingAss = new temperature2();
		double U4 = swingAss.getTemperature2(time);
		//灭磁开关动作总得分
		Degauss2 temperatureAss = new Degauss2();
		double U5 = temperatureAss.getDegauss2(time);
		// 正常来说权重比例应该是由判断矩阵算出来的
		double U6 = 0.475 * U1 + 0.055 * U2 + 0.110 * U3 + 0.090 * U4
				+ 0.263 * U5;
		// 控制小数点位数
				DecimalFormat df = new DecimalFormat("#.0");
				U6 = Double.parseDouble(df.format(U6));
		GeneratorAssessResult  generatorAssessResult=new GeneratorAssessResult(U1, U2, U3, U4, U5,U6);
		return generatorAssessResult;
	}
}
