package service.assess.transformer.one.thrid;

import java.util.ArrayList;
import java.util.List;

import bll.BoolAssess;

public class malfunction {
	// 主变故障信号
	public List<Number> Malfunction(long time) {
		
		List<Number> mList=new ArrayList<>();
		BoolAssess malState = new BoolAssess();
		// 主变重瓦斯跳闸
		int U1 = malState.BooleanAssess(1410, time);
		// 主变油位高报警
		int U2 = malState.BooleanAssess(1415, time);
		// 机组电气停机报警
		int U3 = malState.BooleanAssess(1412, time);
		double a = (U1 + U2 + U3) / 3;
		
		
		mList.add(U1);
		mList.add(U2);
		mList.add(U3);
		mList.add(a);
		
		return mList;
	}
}