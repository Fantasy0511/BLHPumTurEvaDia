package service.assess.pumptur.one.Vibration1;


import bll.BoolAssess;
import bll.FloatAssessment;
//下机架得分
public class LowerBracket1 {

		public int LowerBracket(long time){
			//下机架X轴摆动跳闸 
//			BoolAssess bool987=new BoolAssess();
//			int U1=bool987.BooleanAssess(987,time);
			
			//下机架Y轴摆动跳闸
//			BoolAssess bool988=new BoolAssess();
//			int U2=bool988.BooleanAssess(988,time);
		
			//下机架Z轴摆动跳闸
//			BoolAssess bool989=new BoolAssess();
//			int U3=bool989.BooleanAssess(989,time);
					
					
			//下机架X轴位移
			FloatAssessment float288=new FloatAssessment();
			int U4=float288.FloatAssess(288,time, 20, 0);
			//下机架Y轴位移
//			FloatAssessment float941=new FloatAssessment();
//			int U5=float941.FloatAssess(941,time, 20, 0);
			//下机架Z轴位移
//			FloatAssessment float942=new FloatAssessment();
//			int U6=float942.FloatAssess(942,time, 20, 0);
			
			
			int a=U4;
			return a;
			// System.out.println(a);

		}
}
