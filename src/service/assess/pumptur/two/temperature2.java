package service.assess.pumptur.two;

import bll.FloatAssessment;

public class temperature2 {
	//2号机组水泵水轮机温度总得分
	
		public double gettemperature2(long time){
			//上导冷却水出水温度
			FloatAssessment float390=new FloatAssessment();
			int U1=float390.FloatAssess(390,time, 190, 20);
			
			//上导轴瓦温度
			FloatAssessment float395=new FloatAssessment();
			int U2=float395.FloatAssess(395,time, 190, 20);
			//上导油槽温度
			FloatAssessment float401=new FloatAssessment();
			int U3=float401.FloatAssess(401,time, 190, 20);
			//下导冷却水出水温度
			
			FloatAssessment float404=new FloatAssessment();
			int U4=float404.FloatAssess(404,time, 190, 20);
			//下导轴瓦温度
			
			FloatAssessment float408=new FloatAssessment();
			int U5=float408.FloatAssess(408,time, 190, 20);
			//下导油槽温度
			FloatAssessment float415=new FloatAssessment();
			int U6=float415.FloatAssess(415,time, 190, 20);
			
			double score=(U1+U2+U3+U4+U5+U6)/6;
			return score;
			
			
			
			
			
		}
}
