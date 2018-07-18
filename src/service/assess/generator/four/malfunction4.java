package service.assess.generator.four;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import bll.BoolAssess;

public class malfunction4 {

	// 4号发电机故障信号总得分

	public List<Number> getMalfunction4(long time) {
		List<Number> maList = new ArrayList<>();
		DecimalFormat df = new DecimalFormat("#.0"); // 控制小数点位数
		// 转子绝缘报警
		BoolAssess bool1047 = new BoolAssess();
		int U1 = bool1047.BooleanAssess(1047, time);

		// 发电机停止报警
		BoolAssess bool1048 = new BoolAssess();
		int U2 = bool1048.BooleanAssess(1048, time);
		// 频率保护报警
		BoolAssess bool1049 = new BoolAssess();
		int U3 = bool1049.BooleanAssess(1049, time);
		double a = Double.parseDouble(df.format((U1 + U2 + U3) / 3));
		maList.add(U1);
		maList.add(U2);
		maList.add(U3);
		maList.add(a);
		return maList;
	}
}
