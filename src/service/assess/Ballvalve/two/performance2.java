package service.assess.Ballvalve.two;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import bll.BoolAssess;
import bll.FloatAssessment;

public class performance2 {

	// 2号球阀性能状态

	public List<Number> getPerformance2(long time) {
		DecimalFormat df = new DecimalFormat("#.0");
		List<Number> list = new ArrayList<>();

		// 球阀突然关闭报警
		BoolAssess bool556 = new BoolAssess();
		int U1 = bool556.BooleanAssess(556, time);
		
		// 蜗壳压力
		FloatAssessment float567 = new FloatAssessment();
		int U2 = float567.FloatAssess(567, time, 40, 0);
		// 水闸压力
		FloatAssessment float566 = new FloatAssessment();
		int U3 = float566.FloatAssess(566, time, 190, 0);
		double score = (U1 + U2 + U3) / 3;
		score = Double.parseDouble(df.format(score));

		list.add(U1);
		list.add(U2);
		list.add(U3);
		list.add(score);
		return list;

	}
}
