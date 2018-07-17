package service.assess.Ballvalve.four;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import bll.BoolAssess;
import bll.FloatAssessment;

public class performance4 {

	// 4号球阀性能状态

	public List<Number> getPerformance4(long time) {
		DecimalFormat df = new DecimalFormat("#.0");
		List<Number> list = new ArrayList<>();

		// 球阀突然关闭报警
		BoolAssess bool1198 = new BoolAssess();
		int U1 = bool1198.BooleanAssess(1198, time);
		// 蜗壳压力
		FloatAssessment float1003 = new FloatAssessment();
		int U2 = float1003.FloatAssess(1003, time, 40, 0);
		// 水闸压力
		FloatAssessment float1002 = new FloatAssessment();
		int U3 = float1002.FloatAssess(1002, time, 190, 0);
		
		double score = (U1 + U2 + U3) / 3;
		score = Double.parseDouble(df.format(score));

		list.add(U1);
		list.add(U2);
		list.add(U3);
		list.add(score);
		return list;
	}
}
