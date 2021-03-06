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
		BoolAssess ba = new BoolAssess();
		int U1 = ba.BooleanAssess(1047, time);

		// 发电机停止报警
		int U2 = ba.BooleanAssess(1048, time);
		// 频率保护报警
		int U3 = ba.BooleanAssess(1049, time);
		double a = Double.parseDouble(df.format((U1 + U2 + U3) / 3));
		maList.add(U1);
		maList.add(U2);
		maList.add(U3);
		maList.add(a);
		return maList;
	}
}
