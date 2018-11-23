package service.assess.transformer.two;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import bll.BoolAssess;

public class malfunction2 {

	// 2号机组主变故障信号
	public List<Number> malfunction(long time) {
		
		List<Number> mList=new ArrayList<>();
		DecimalFormat df=new DecimalFormat("#.0");  //控制小数点位数
		BoolAssess malfState = new BoolAssess();
		// 主变重瓦斯跳闸
		int U1 = malfState.BooleanAssess(1449, time);
		// 主变油位高报警
		int U2 = malfState.BooleanAssess(1454, time);
		// 机组电气停机报警
		int U3 = malfState.BooleanAssess(1534, time);
		
		double a = Double.parseDouble(df.format((U1+U2+U3)/3));
		mList.add(U1);
		mList.add(U2);
		mList.add(U3);
		mList.add(a);
		return mList;
	}
}
