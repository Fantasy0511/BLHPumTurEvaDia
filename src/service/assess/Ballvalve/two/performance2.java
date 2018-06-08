package service.assess.Ballvalve.two;

import bll.BoolAssess;
import bll.FloatAssessment;

public class performance2 {

	//2号球阀性能状态

		public double performance2(long time){
		//球阀突然关闭报警
				BoolAssess bool556=new BoolAssess();
				int U1=bool556.BooleanAssess(556,time);
				//蜗壳压力
				FloatAssessment float567=new FloatAssessment();
				int U2=float567.FloatAssess(567,time, 40, 0);
				//水闸压力
				FloatAssessment float566=new FloatAssessment();
				int U3=float566.FloatAssess(566,time, 190, 0);
				double a=(U1+U2+U3)/3;
				return a;
		
		
		
		}
}
