package service.assess.generator.one.frist;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import bll.BoolAssess;

//励磁故障信号总得分
public class electricity {
	public List<Number> electricity1(long time) {

		List<Number> eList = new ArrayList<>();
		DecimalFormat df = new DecimalFormat("#.0"); // 控制小数点位数
		// 励磁电源故障
		BoolAssess bool1285 = new BoolAssess();
		int U1 = bool1285.BooleanAssess(1285, time);

		// 电压/频率跳闸
		BoolAssess bool283 = new BoolAssess();
		int U2 = bool283.BooleanAssess(283, time);
		// 晶闸管桥风扇故障
		BoolAssess bool279 = new BoolAssess();
		int U3 = bool279.BooleanAssess(279, time);
		
		double a = Double.parseDouble(df.format((U1 + U2 + U3) / 3));
		
		eList.add(U1);
		eList.add(U2);
		eList.add(U3);
		eList.add(a);
		return eList;
	}
}
