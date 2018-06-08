package service.assess.Ballvalve.three;

import bll.BoolAssess;
import bll.FloatAssessment;

public class performance3 {

	//3号球阀性能状态

			public double performance3(long time){
			//球阀突然关闭报警
					BoolAssess bool879=new BoolAssess();
					int U1=bool879.BooleanAssess(879,time);
					//蜗壳压力
					FloatAssessment float786=new FloatAssessment();
					int U2=float786.FloatAssess(786,time, 40, 0);
					//水闸压力
					FloatAssessment float785=new FloatAssessment();
					int U3=float785.FloatAssess(785,time, 190, 0);
					double a=(U1+U2+U3)/3;
					return a;
			
			
			
			}
}
