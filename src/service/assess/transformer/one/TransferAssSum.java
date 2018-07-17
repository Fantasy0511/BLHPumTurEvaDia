package service.assess.transformer.one;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import service.assess.transformer.TransferAssResult;
import service.assess.transformer.one.frist.temperature;
import service.assess.transformer.one.second.histroy;
import service.assess.transformer.one.thrid.malfunction;

/**
 * 主变action调用数据封装
 * 
 * @author tiandiwei
 *
 */
public class TransferAssSum {

	// 主变压器总得分
	public TransferAssResult output(long time) {

		List<Number> firstList = new ArrayList<>();// 一层指标输出；存放“评估主页面”饼图、柱状图、表格数据

		List<Number> tempList = new ArrayList<>();// 主变温度底层指标输出，存放“显示子评估页面”，饼图、柱状图数据

		List<Number> faultList = new ArrayList<>();// 主变故障信号底层指标输出，存放“显示子评估页面”，饼图、柱状图数据

		DecimalFormat df=new DecimalFormat("#.0");  //控制小数点位数
		// 主变压器温度
		temperature guideVane = new temperature();
		double U0 = guideVane.temperatureA(time).get(0).doubleValue();// 主变油温
		double U1 = guideVane.temperatureA(time).get(1).doubleValue();// 高压侧绕组温度
		double U2 = guideVane.temperatureA(time).get(2).doubleValue();// 冷却器出口水温
		double sum1 = guideVane.temperatureA(time).get(3).doubleValue();// 主变温度总得分
		// 主变故障信号
		malfunction mainShaftSeal = new malfunction();
		double m1 = mainShaftSeal.Malfunction(time).get(0).doubleValue();// 主变重瓦斯跳闸
		double m2 = mainShaftSeal.Malfunction(time).get(1).doubleValue();// 主变油位高报警
		double m3 = mainShaftSeal.Malfunction(time).get(2).doubleValue();// 机组电气停机报警
		double sum2 = mainShaftSeal.Malfunction(time).get(3).doubleValue();// 主变故障总得分
		// 历史和巡检状态
		histroy history = new histroy();
		double sum3 = history.histroy2(time).get(0).doubleValue();
		// 主变系统总得分
		double sum = Double.parseDouble(df.format(0.5 * sum1 + 0.1 * sum2 + 0.4 * sum3));

		// 评估页面数据
		firstList.add(sum);
		firstList.add(sum1);
		firstList.add(sum2);
		firstList.add(sum3);
		firstList.add(U0);
		firstList.add(U1);
		firstList.add(U2);
		firstList.add(m1);
		firstList.add(m2);
		firstList.add(m3);

		// 主变温度底层指标数据
		tempList.add(U0);
		tempList.add(U1);
		tempList.add(U2);

		// 主变故障底层指标数据
		faultList.add(m1);
		faultList.add(m2);
		faultList.add(m3);

		TransferAssResult transferAssResult = new TransferAssResult(firstList, tempList, faultList);

		return transferAssResult;
	}
}
