package service.assess.Governor.two;

import bll.BoolAssess;
import bll.FloatAssessment;


public class State2 {
//2号机组调速油系统性能状态得分
	public double State2(long time){
		//调速器油槽油温
		FloatAssessment float562=new FloatAssessment();
		int U1=float562.FloatAssess(562,time, 100, 20);
		//调速器供油管油压
		FloatAssessment float563=new FloatAssessment();
		int U2=float563.FloatAssess(563,time, 300, 50);
		//压力油罐油位
		FloatAssessment float564=new FloatAssessment();
		int U3=float564.FloatAssess(564,time, 3000, 500);
		//调速器油箱油位高
		BoolAssess bool536=new BoolAssess();
		int U4=bool536.BooleanAssess(536,time);
		
		//调速器油箱油位地
		BoolAssess bool537=new BoolAssess();
		int U5=bool537.BooleanAssess(537,time);
		
		 
		double score=0.25*U1+0.25*U2+0.2*U3+0.15*U4+0.15*U5;
		return score;
	}

}
