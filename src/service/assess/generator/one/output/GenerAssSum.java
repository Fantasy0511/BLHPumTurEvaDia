package service.assess.generator.one.output;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import service.assess.generator.excAssResult;
import service.assess.generator.one.Degauss;
import service.assess.generator.one.electricity;
import service.assess.generator.one.malfunction;
import service.assess.generator.one.monitor;
import service.assess.generator.one.temperature;

/**
 * 发电励磁一号机评估
 * 
 * @author tiandiwei
 *
 */
// 励磁故障信号、机组监测电气量、发电电动机故障信号、温度指标和灭磁开关
public class GenerAssSum {
	// 发电电动机总得分
	public excAssResult getGenerAssSum(long time) {

		List<Number> firstList = new ArrayList<>();// 一层指标输出；存放“评估主页面”饼图、柱状图、表格数据

		/*List<Number> tempList = new ArrayList<>();// 励磁故障信号底层指标输出，存放“显示子评估页面”，饼图、柱状图数据

		List<Number> faultList = new ArrayList<>();// 主变故障信号底层指标输出，存放“显示子评估页面”，饼图、柱状图数据
*/		
		DecimalFormat df = new DecimalFormat("#.0"); // 控制小数点位数

		// 励磁故障信号总得分
		List<Number> exFault = electricity.electricity1(time);
		double U0 = exFault.get(0).doubleValue();// 励磁电源故障
		double U1 = exFault.get(1).doubleValue();// 电压/频率跳闸
		double U2 = exFault.get(2).doubleValue();// 晶闸管桥风扇故障
		double sum1 = exFault.get(3).doubleValue();// 励磁故障信号总得分

		// 机组监测电气量总得分
		List<Number> monitorFault = monitor.monitor1(time);
		double h0 = monitorFault.get(0).doubleValue();// 有功功率测量值
		double h1 = monitorFault.get(1).doubleValue();// 励磁电压
		double h2 = monitorFault.get(2).doubleValue();// 机组频率
		double sum2 = monitorFault.get(3).doubleValue();// 机组监测电气量总得分
		// 发电机故障信号总得分
		List<Number> genFault = malfunction.malfunction1(time);
		double m0 = genFault.get(0).doubleValue(); // 转子绝缘报警
		double m1 = genFault.get(1).doubleValue();// 发电机停止报警
		double m2 = genFault.get(2).doubleValue();// 频率保护报警
		double sum3 = genFault.get(3).doubleValue();// 发电机故障信号总得分
		// 温度总得分
		List<Number> tempFault = temperature.temperature1(time);
		double t0 = tempFault.get(0).doubleValue();// 发电机热风温度
		double t1 = tempFault.get(1).doubleValue();// 发电机冷风温度
		double t2 = tempFault.get(2).doubleValue();// 空冷器出水温度
		double sum4 = tempFault.get(3).doubleValue();// 发电机故障信号总得分
		// 灭磁开关动作总得分
		List<Number> degaussFault = Degauss.Degauss1(time);
		double d0 = degaussFault.get(0).doubleValue();//励磁电流
		double d1 = degaussFault.get(1).doubleValue();//励磁电压
		double sum5 = degaussFault.get(2).doubleValue(); // 灭磁开关动作总得分

		// 正常来说权重比例应该是由判断矩阵算出来的
		double sum = Double.parseDouble(df.format(0.475 * sum1 + 0.055 * sum2 + 0.110 * sum3 + 0.090 * sum4 + 0.27 * sum5));

		// 评估页面数据
		firstList.add(sum);   
		firstList.add(sum1);
		firstList.add(sum2);
		firstList.add(sum3);
		firstList.add(sum4);
		firstList.add(sum5);
		firstList.add(U0);
		firstList.add(U1);
		firstList.add(U2);
		firstList.add(h0);
		firstList.add(h1);
		firstList.add(h2);
		firstList.add(m0);
		firstList.add(m1);
		firstList.add(m2);
		firstList.add(t0);
		firstList.add(t1);
		firstList.add(t2);
		firstList.add(d0);
		firstList.add(d1);

		excAssResult generatorAssessResult = new excAssResult(firstList);
		return generatorAssessResult;
	}
}
