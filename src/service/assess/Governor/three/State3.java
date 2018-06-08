package service.assess.Governor.three;

import bll.BoolAssess;
import bll.FloatAssessment;

public class State3 {

	//3号机组调速油系统性能状态得分
		public double State3(long time){
			//调速器油槽油温
			FloatAssessment float781=new FloatAssessment();
			int U1=float781.FloatAssess(781,time, 100, 20);
			//调速器供油管油压
			FloatAssessment float782=new FloatAssessment();
			int U2=float782.FloatAssess(782,time, 300, 50);
			//压力油罐油位
			FloatAssessment float783=new FloatAssessment();
			int U3=float783.FloatAssess(783,time, 3000, 500);
			//调速器油箱油位高
			BoolAssess bool861=new BoolAssess();
			int U4=bool861.BooleanAssess(861,time);
			
			//调速器油箱油位地
			BoolAssess bool862=new BoolAssess();
			int U5=bool862.BooleanAssess(862,time);
			
			 
			double score=0.25*U1+0.25*U2+0.2*U3+0.15*U4+0.15*U5;
			return score;
		}
}
