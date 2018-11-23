package service.assess.generator.four;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import bll.BoolAssess;

public class temperature4 {

	// 4号机组温度总得分

	public List<Number> getTemperature4(long time) {
		List<Number> tList = new ArrayList<>();
		DecimalFormat df = new DecimalFormat("#.0"); // 控制小数点位数
		// 发电机热风温度
		BoolAssess ba = new BoolAssess();
		int U1 = ba.BooleanAssess(2518, time);

		// 发电机冷风温度
		int U2 = ba.BooleanAssess(2514, time);
		// 空冷器出水温度
		int U3 = ba.BooleanAssess(2513, time);
		double a = Double.parseDouble(df.format((U1 + U2 + U3) / 3));

		tList.add(U1);
		tList.add(U2);
		tList.add(U3);
		tList.add(a);
		return tList;
	}
}
