package service.assess.generator.one.third;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import bll.BoolAssess;

//发电机故障信号总得分
public class malfunction {

	public List<Number> malfunction1(long time) {

		List<Number> maList = new ArrayList<>();
		DecimalFormat df = new DecimalFormat("#.0"); // 控制小数点位数
		// 转子绝缘报警
		BoolAssess bool85 = new BoolAssess();
		int U1 = bool85.BooleanAssess(85, time);

		// 发电机停止报警
		BoolAssess bool86 = new BoolAssess();
		int U2 = bool86.BooleanAssess(86, time);
		// 频率保护报警
		BoolAssess bool87 = new BoolAssess();
		int U3 = bool87.BooleanAssess(87, time);
		double a = Double.parseDouble(df.format((U1 + U2 + U3) / 3));

		maList.add(U1);
		maList.add(U2);
		maList.add(U3);
		maList.add(a);
		return maList;
	}
}
