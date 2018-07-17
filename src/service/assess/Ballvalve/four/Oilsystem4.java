package service.assess.Ballvalve.four;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import bll.BoolAssess;

public class Oilsystem4 {

	// 4号球阀油系统性能状态
	public List<Number> getOilsystem4(long time) {
		DecimalFormat df = new DecimalFormat("#.0");
		List<Number> oilStateList = new ArrayList<>();

		// 压力油罐油压低报警
		BoolAssess bool1186 = new BoolAssess();
		int U1 = bool1186.BooleanAssess(1186, time);

		// 球阀1号油泵故障
		BoolAssess bool1211 = new BoolAssess();
		int U2 = bool1211.BooleanAssess(1211, time);
		// 球阀2号油泵故障
		BoolAssess bool1216 = new BoolAssess();
		int U3 = bool1216.BooleanAssess(1216, time);
		
		double score = (U1 + U2 + U3) / 3;
		score =Double.parseDouble(df.format(score));
		
		oilStateList.add(U1);
		oilStateList.add(U2);
		oilStateList.add(U3);
		oilStateList.add(score);
		return oilStateList;
	}
}
