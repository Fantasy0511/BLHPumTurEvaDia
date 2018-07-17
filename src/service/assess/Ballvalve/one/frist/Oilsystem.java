package service.assess.Ballvalve.one.frist;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import bll.BoolAssess;

//球阀油系统性能状态
public class Oilsystem {

	public List<Number> getOilsystem(long time) {
		DecimalFormat df = new DecimalFormat("#.0");
		List<Number> oilStateList = new ArrayList<>();
		// 压力油罐油压低报警
		BoolAssess bool223 = new BoolAssess();
		int U1 = bool223.BooleanAssess(223, time);

		// 球阀1号油泵故障
		BoolAssess bool245 = new BoolAssess();
		int U2 = bool245.BooleanAssess(245, time);
		// 球阀2号油泵故障
		BoolAssess bool250 = new BoolAssess();
		int U3 = bool250.BooleanAssess(250, time);

		double score = (U1 + U2 + U3) / 3;
		score =Double.parseDouble(df.format(score));
		
		oilStateList.add(U1);
		oilStateList.add(U2);
		oilStateList.add(U3);
		oilStateList.add(score);
		return oilStateList;
	}
}
