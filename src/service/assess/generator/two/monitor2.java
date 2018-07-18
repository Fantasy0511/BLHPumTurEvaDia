package service.assess.generator.two;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import bll.FloatAssessment;

public class monitor2 {

	// 2号机组机组监测电气量总得分

	public List<Number> getMonitor2(long time) {
		List<Number> mList = new ArrayList<>();
		DecimalFormat df = new DecimalFormat("#.0"); // 控制小数点位数

		// 励磁电压
		FloatAssessment float365 = new FloatAssessment();
		int U2 = float365.FloatAssess(365, time, 600, 150);
		// 机组频率
		FloatAssessment float508 = new FloatAssessment();
		int U3 = float508.FloatAssess(508, time, 0, 60);
		double a = Double.parseDouble(df.format((U2 + U3) / 2));

		mList.add(U2);
		mList.add(U3);
		mList.add(a);

		return mList;
		// System.out.println(a);
	}
}
