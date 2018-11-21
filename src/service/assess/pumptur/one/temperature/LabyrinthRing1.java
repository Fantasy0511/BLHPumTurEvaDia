package service.assess.pumptur.one.temperature;

import bll.FloatAssessment;

//迷宫环得分
public class LabyrinthRing1 {
	public int LabyrinthRing(long time){
		
		//上迷宫环温度
		FloatAssessment float333=new FloatAssessment();
		int U1=float333.FloatAssess(333,time, 190, 0);
		//下迷宫环温度
		FloatAssessment float338=new FloatAssessment();
		int U2= float338.FloatAssess(338,time, 190, 0);
		
		int a=(U1+U2)/2;
		return a;
		
	}

}

