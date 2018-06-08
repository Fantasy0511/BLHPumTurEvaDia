package service.assess.pumptur.two;

import bll.BoolAssess;
import bll.FloatAssessment;

public class MainShaftSeal2 {

	//2号机组水泵水轮机主轴密封得分

		public double MainShaftSeal2(long time){
			//供水流量
			FloatAssessment float522=new FloatAssessment();
			int U1=float522.FloatAssess(522,time, 452, 0);
			//供水温度
			FloatAssessment float526=new FloatAssessment();
			int U2=float526.FloatAssess(526,time, 190, 20);
			//过滤器前压力
			FloatAssessment float523=new FloatAssessment();
			int U3=float523.FloatAssess(523,time, 190, 0);
			//过滤器后压力
			FloatAssessment float524=new FloatAssessment();
			int U4=float524.FloatAssess(524,time, 190, 0);
			//过滤器故障报警
			BoolAssess bool433=new BoolAssess();
			int U5=bool433.BooleanAssess(433,time);
			//过滤器压差报警
			BoolAssess bool434=new BoolAssess();
			int U6=bool434.BooleanAssess(434,time);
			
			
			
			double a=(U1+U2+U3+U4+U5+U6)/6;
			return a;}
}
