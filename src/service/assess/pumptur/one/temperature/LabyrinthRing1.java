package service.assess.pumptur.one.temperature;

import bll.FloatAssessment;

//迷宫环得分
public class LabyrinthRing1 {
	public int LabyrinthRing(long time){
		
		//上迷宫环温度
		FloatAssessment float988=new FloatAssessment();
		int U1=float988.FloatAssess(988,time, 190, 0);
		//下迷宫环温度
		FloatAssessment float994=new FloatAssessment();
		int U2=float994.FloatAssess(994,time, 190, 0);
		
		int a=(U1+U2)/2;
		return a;
		
	}

}

