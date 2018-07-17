package service.assess.transformer.one.thrid;

import java.util.ArrayList;
import java.util.List;

import bll.BoolAssess;

public class malfunction {
	// 主变故障信号
	public List<Number> Malfunction(long time) {
		
		List<Number> mList=new ArrayList<>();
		
		// 主变重瓦斯跳闸
		BoolAssess bool1410 = new BoolAssess();
		int U1 = bool1410.BooleanAssess(1410, time);

		// 主变油位高报警
		BoolAssess bool1415 = new BoolAssess();
		int U2 = bool1415.BooleanAssess(1415, time);
		// 机组电气停机报警
		BoolAssess bool1412 = new BoolAssess();
		int U3 = bool1412.BooleanAssess(1412, time);
		double a = (U1 + U2 + U3) / 3;
		
		
		mList.add(U1);
		mList.add(U2);
		mList.add(U3);
		mList.add(a);
		
		return mList;
	}
}