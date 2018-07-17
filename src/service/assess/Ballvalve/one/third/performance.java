package service.assess.Ballvalve.one.third;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import bll.BoolAssess;
import bll.FloatAssessment;

//球阀性能状态
public class performance {
	public List<Number> getPerformance(long time) {
		DecimalFormat df = new DecimalFormat("#.0");
		List<Number> list = new ArrayList<>();

		// 球阀突然关闭报警
		BoolAssess bool233 = new BoolAssess();
		int U1 = bool233.BooleanAssess(233, time);
		// 蜗壳压力
		FloatAssessment float348 = new FloatAssessment();
		int U2 = float348.FloatAssess(348, time, 40, 0);
		// 水闸压力
		FloatAssessment float347 = new FloatAssessment();
		int U3 = float347.FloatAssess(347, time, 190, 0);
		
		double score = (U1 + U2 + U3) / 3;
		score = Double.parseDouble(df.format(score));

		list.add(U1);
		list.add(U2);
		list.add(U3);
		list.add(score);
		return list;
	}
}