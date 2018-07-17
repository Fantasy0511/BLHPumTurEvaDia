package service.assess.Ballvalve.three;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import bll.BoolAssess;

public class Oilsystem3 {
	// 3号球阀油系统性能状态
	public List<Number> getOilsystem3(long time) {
		DecimalFormat df = new DecimalFormat("#.0");
		List<Number> oilStateList = new ArrayList<>();

		// 压力油罐油压低报警
		BoolAssess bool867 = new BoolAssess();
		int U1 = bool867.BooleanAssess(867, time);

		// 球阀1号油泵故障
		BoolAssess bool891 = new BoolAssess();
		int U2 = bool891.BooleanAssess(891, time);
		// 球阀2号油泵故障
		BoolAssess bool896 = new BoolAssess();
		int U3 = bool896.BooleanAssess(896, time);
		double score = (U1 + U2 + U3) / 3;
		score =Double.parseDouble(df.format(score));
		
		oilStateList.add(U1);
		oilStateList.add(U2);
		oilStateList.add(U3);
		oilStateList.add(score);
		return oilStateList;
	}
}
