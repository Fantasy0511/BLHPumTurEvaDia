package service.assess.transformer.four;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import bll.FloatAssessment;

public class temperature4 {

	// 4号机组主变压器温度
	public List<Number> temperature(long time) {
		List<Number> hList = new ArrayList<>();
		DecimalFormat df = new DecimalFormat("#.0"); // 控制小数点位数

		// 主变油温
		FloatAssessment float1115 = new FloatAssessment();
		int U1 = float1115.FloatAssess(1115, time, 150, 20);
		// 高压侧绕组温度
		FloatAssessment float1118 = new FloatAssessment();
		int U2 = float1118.FloatAssess(1118, time, 150, 20);
		// 冷却器出口水温
		FloatAssessment float1120 = new FloatAssessment();
		int U3 = float1120.FloatAssess(1120, time, 80, 20);
		double a = Double.parseDouble(df.format((U1 + U2 + U3) / 3));

		hList.add(U1);
		hList.add(U2);
		hList.add(U3);
		hList.add(a);

		return hList;
		// System.out.println(a);
	}
}
