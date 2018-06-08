package service.assess.transformer.three;

import bll.BoolAssess;

public class malfunction3 {
	//3号机组主变故障信号
	public double malfunction3(long time){
			
			//主变重瓦斯跳闸
			BoolAssess bool1529=new BoolAssess();
			int U1=bool1529.BooleanAssess(1529,time);
			
		//主变油位高报警
			BoolAssess bool1534=new BoolAssess();
			int U2=bool1534.BooleanAssess(1534,time);
		//	机组电气停机报警
			BoolAssess bool1536=new BoolAssess();
			int U3=bool1536.BooleanAssess(1536,time);
			double a=(U1+U2+U3)/3;
			return a;
	}
}
