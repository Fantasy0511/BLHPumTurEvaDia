package service.assess.generator.one;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import bll.BoolAssess;

//励磁故障信号总得分
public class electricity {
	public static List<Number> electricity1(long time) {

		List<Number> eList = new ArrayList<>();
		DecimalFormat df = new DecimalFormat("#.0"); // 控制小数点位数
		BoolAssess ba = new BoolAssess();
		// 励磁电源故障
		int U1 = ba.BooleanAssess(1285, time);
		// 电压/频率跳闸
		int U2 = ba.BooleanAssess(283, time);
		// 晶闸管桥风扇故障
		int U3 = ba.BooleanAssess(279, time);
		
		double a = Double.parseDouble(df.format((U1 + U2 + U3) / 3));
		
		eList.add(U1);
		eList.add(U2);
		eList.add(U3);
		eList.add(a);
		return eList;
	}
}
