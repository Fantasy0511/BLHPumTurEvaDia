package service.assess.generator.four;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import bll.FloatAssessment;

public class Degauss4 {

	// 4号机组灭磁开关动作总得分

	public List<Number> getDegauss4(long time) {
		List<Number> dList = new ArrayList<>();
		DecimalFormat df = new DecimalFormat("#.0"); // 控制小数点位数
		// 励磁电流
		FloatAssessment fa = new FloatAssessment();
		int U1 = fa.FloatAssess(801, time, 3600, 1200);
		// 励磁电压
		int U2 = fa.FloatAssess(802, time, 600, 1500);

		double a = Double.parseDouble(df.format((U1 + U2) / 2));
		dList.add(U1);
		dList.add(U2);
		dList.add(a);
		return dList;
		// System.out.println(a);

	}
}
