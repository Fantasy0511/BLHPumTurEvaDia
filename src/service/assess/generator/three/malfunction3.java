package service.assess.generator.three;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import bll.BoolAssess;

public class malfunction3 {

	// 3号发电机故障信号总得分

	public List<Number> getMalfunction3(long time) {

		List<Number> maList = new ArrayList<>();
		DecimalFormat df = new DecimalFormat("#.0"); // 控制小数点位数
		// 转子绝缘报警
		BoolAssess bool725 = new BoolAssess();
		int U1 = bool725.BooleanAssess(725, time);

		// 发电机停止报警
		BoolAssess bool726 = new BoolAssess();
		int U2 = bool726.BooleanAssess(726, time);
		// 频率保护报警
		BoolAssess bool727 = new BoolAssess();
		int U3 = bool727.BooleanAssess(727, time);
		double a = Double.parseDouble(df.format((U1 + U2 + U3) / 3));
		maList.add(U1);
		maList.add(U2);
		maList.add(U3);
		maList.add(a);
		return maList;
	}
}
