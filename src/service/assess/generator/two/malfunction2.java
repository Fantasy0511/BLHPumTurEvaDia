package service.assess.generator.two;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import bll.BoolAssess;

public class malfunction2 {

	// 2号发电机故障信号总得分

	public List<Number> getMalfunction2(long time) {

		List<Number> maList = new ArrayList<>();
		DecimalFormat df = new DecimalFormat("#.0"); // 控制小数点位数
		// 转子绝缘报警
		BoolAssess bool402 = new BoolAssess();
		int U1 = bool402.BooleanAssess(402, time);

		// 发电机停止报警
		BoolAssess bool403 = new BoolAssess();
		int U2 = bool403.BooleanAssess(403, time);
		// 频率保护报警
		BoolAssess bool404 = new BoolAssess();
		int U3 = bool404.BooleanAssess(404, time);
		double a = Double.parseDouble(df.format((U1 + U2 + U3) / 3));
		maList.add(U1);
		maList.add(U2);
		maList.add(U3);
		maList.add(a);
		return maList;
	}
}
