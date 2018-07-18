package service.assess.generator.two.output;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import service.assess.generator.excAssResult;
import service.assess.generator.two.Degauss2;
import service.assess.generator.two.electricity2;
import service.assess.generator.two.malfunction2;
import service.assess.generator.two.monitor2;
import service.assess.generator.two.temperature2;

//励磁故障信号、机组监测电气量、发电电动机故障信号、温度指标和灭磁开关
public class GenerAssSum {
	// 发电电动机总得分
	public excAssResult getGenerAssSum(long time) {

		List<Number> firstList = new ArrayList<>();// 所有指标输出；存放“评估主页面”“显示子评估页面”饼图、柱状图、表格数据
		DecimalFormat df = new DecimalFormat("#.0"); // 控制小数点位数
		// 励磁故障信号总得分
		electricity2 guideVane = new electricity2();
		double U0 = guideVane.getElectricity2(time).get(0).doubleValue();// 励磁电源故障
		double U1 = guideVane.getElectricity2(time).get(1).doubleValue();// 电压/频率跳闸
		double U2 = guideVane.getElectricity2(time).get(2).doubleValue();// 晶闸管桥风扇故障
		double sum1 = guideVane.getElectricity2(time).get(3).doubleValue();// 励磁故障信号总得分
		// 机组监测电气量总得分
		monitor2 history = new monitor2();
		double h0 = history.getMonitor2(time).get(0).doubleValue();// 励磁电压
		double h1 = history.getMonitor2(time).get(1).doubleValue();// 机组频率
		double sum2 = history.getMonitor2(time).get(2).doubleValue();// 机组监测电气量总得分
		// 发电机故障信号总得分
		malfunction2 mainShaftSeal = new malfunction2();
		double m0 = mainShaftSeal.getMalfunction2(time).get(0).doubleValue(); // 转子绝缘报警
		double m1 = mainShaftSeal.getMalfunction2(time).get(1).doubleValue();// 发电机停止报警
		double m2 = mainShaftSeal.getMalfunction2(time).get(2).doubleValue();// 频率保护报警
		double sum3 = mainShaftSeal.getMalfunction2(time).get(3).doubleValue();// 发电机故障信号总得分
		// 温度总得分
		temperature2 swingAss = new temperature2();
		double t0 = swingAss.getTemperature2(time).get(0).doubleValue();// 发电机热风温度
		double t1 = swingAss.getTemperature2(time).get(1).doubleValue();// 发电机冷风温度
		double t2 = swingAss.getTemperature2(time).get(2).doubleValue();// 空冷器出水温度
		double sum4 = swingAss.getTemperature2(time).get(3).doubleValue();// 发电机故障信号总得分
		// 灭磁开关动作总得分
		Degauss2 temperatureAss = new Degauss2();
		double d0 = temperatureAss.getDegauss2(time).get(0).doubleValue();// 励磁电流
		double d1 = temperatureAss.getDegauss2(time).get(1).doubleValue();// 励磁电压
		double sum5 = temperatureAss.getDegauss2(time).get(2).doubleValue(); // 灭磁开关动作总得分
		// 正常来说权重比例应该是由判断矩阵算出来的
		double sum = Double
				.parseDouble(df.format(0.475 * sum1 + 0.055 * sum2 + 0.110 * sum3 + 0.090 * sum4 + 0.263 * sum5));

		// 评估页面数据
		firstList.add(sum);  //总得分00
		firstList.add(sum1); // 励磁故障信号总得分1
		firstList.add(sum2); // 机组监测电气量总得分2
		firstList.add(sum3); // 发电机故障信号总得分3
		firstList.add(sum4); // 发电机故障信号总得分4
		firstList.add(sum5); // 灭磁开关动作总得分5
		//励磁故障信号
		firstList.add(U0); // 励磁电源故障6
		firstList.add(U1); // 电压/频率跳闸7
		firstList.add(U2); // 晶闸管桥风扇故障8
		// 机组监测电气量
		firstList.add(h0); // 励磁电压9
		firstList.add(h1); // 机组频率10
		// 发电机故障信号
		firstList.add(m0); // 转子绝缘报警11
		firstList.add(m1); // 发电机停止报警12
		firstList.add(m2); // 频率保护报警13
		// 温度
		firstList.add(t0); // 发电机热风温度14
		firstList.add(t1); // 发电机冷风温度15
		firstList.add(t2); // 空冷器出水温度16
		// 灭磁开关动作
		firstList.add(d0); //励磁电流17
		firstList.add(d1); ;//励磁电压18

		excAssResult generatorAssessResult = new excAssResult(firstList);
		return generatorAssessResult;
	}
}
