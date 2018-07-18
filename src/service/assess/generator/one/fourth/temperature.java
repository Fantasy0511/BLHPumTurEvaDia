package service.assess.generator.one.fourth;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import bll.BoolAssess;
import bll.FloatAssessment;

//温度总得分
public class temperature {

	public List<Number> temperature1(long time) {

		List<Number> tList = new ArrayList<>();
		DecimalFormat df = new DecimalFormat("#.0"); // 控制小数点位数
		// 发电机热风温度
		BoolAssess bool2179 = new BoolAssess();
		int U1 = bool2179.BooleanAssess(2179, time);

		// 发电机冷风温度
		BoolAssess bool2175 = new BoolAssess();
		int U2 = bool2175.BooleanAssess(2175, time);
		// 空冷器出水温度
		BoolAssess bool2174 = new BoolAssess();
		int U3 = bool2174.BooleanAssess(2174, time);
		double a = Double.parseDouble(df.format((U1 + U2 + U3) / 3));
		
		tList.add(U1);
		tList.add(U2);
		tList.add(U3);
		tList.add(a);
		return tList;
	}
}
