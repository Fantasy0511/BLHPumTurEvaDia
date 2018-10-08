package service.assess.Ballvalve.two;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import bll.BoolAssess;

public class Oilsystem2 {
	// 2号球阀油系统性能状态
	public List<Number> getOilsystem2(long time) {
		DecimalFormat df = new DecimalFormat("#.0");
		List<Number> oilStateList = new ArrayList<>();
		
		BoolAssess ba = new BoolAssess();
		// 压力油罐油压低报警
		int U1 = ba.BooleanAssess(544, time);
		// 球阀1号油泵故障
		int U2 = ba.BooleanAssess(568, time);
		// 球阀2号油泵故障
		int U3 = ba.BooleanAssess(573, time);
		
		double score = (U1 + U2 + U3) / 3;
		score =Double.parseDouble(df.format(score));
		
		oilStateList.add(U1);
		oilStateList.add(U2);
		oilStateList.add(U3);
		oilStateList.add(score);
		return oilStateList;
	}

}
