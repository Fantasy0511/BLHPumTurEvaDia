package service.assess.transformer.four;

import bll.BoolAssess;

public class malfunction4 {

	//4号机组主变故障信号
	public double malfunction4(long time){
			
			//主变重瓦斯跳闸
			BoolAssess bool1489=new BoolAssess();
			int U1=bool1489.BooleanAssess(1489,time);
			
		//主变油位高报警
			BoolAssess bool1494=new BoolAssess();
			int U2=bool1494.BooleanAssess(1494,time);
		//	机组电气停机报警
			BoolAssess bool1491=new BoolAssess();
			int U3=bool1491.BooleanAssess(1491,time);
			double a=(U1+U2+U3)/3;
			return a;
	}
}
