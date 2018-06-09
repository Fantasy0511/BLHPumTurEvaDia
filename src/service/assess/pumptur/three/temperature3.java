package service.assess.pumptur.three;

import bll.FloatAssessment;

public class temperature3 {
	//3号机组水泵水轮机温度总得分
	
		public double gettemperature3(long time){
			//上导冷却水出水温度
			FloatAssessment float623=new FloatAssessment();
			int U1=float623.FloatAssess(623,time, 190, 20);
			
			//上导轴瓦温度
			FloatAssessment float628=new FloatAssessment();
			int U2=float628.FloatAssess(628,time, 190, 20);
			//上导油槽温度
			FloatAssessment float634=new FloatAssessment();
			int U3=float634.FloatAssess(634,time, 190, 20);
			//下导冷却水出水温度
			
			FloatAssessment float603=new FloatAssessment();
			int U4=float603.FloatAssess(603,time, 190,20);
			//下导轴瓦温度
			
			FloatAssessment float607=new FloatAssessment();
			int U5=float607.FloatAssess(607,time, 190, 20);
			//下导油槽温度
			FloatAssessment float614=new FloatAssessment();
			int U6=float614.FloatAssess(614,time, 190, 20);
			
			double score=(U1+U2+U3+U4+U5+U6)/6;
			return score;
			
			
			
			
			
		}
}
