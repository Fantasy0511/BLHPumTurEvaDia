package service.assess.transformer.two;

import bll.BoolAssess;

public class malfunction2 {

	//2号机组主变故障信号
	public double malfunction2(long time){
			
			//主变重瓦斯跳闸
			BoolAssess bool1449=new BoolAssess();
			int U1=bool1449.BooleanAssess(1449,time);
			
		//主变油位高报警
			BoolAssess bool1454=new BoolAssess();
			int U2=bool1454.BooleanAssess(1454,time);
		//	机组电气停机报警
			BoolAssess bool1534=new BoolAssess();
			int U3=bool1534.BooleanAssess(1534,time);
			double a=(U1+U2+U3)/3;
			return a;
	}
}
