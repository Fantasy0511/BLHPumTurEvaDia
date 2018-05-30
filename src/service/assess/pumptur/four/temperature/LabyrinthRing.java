package service.assess.pumptur.four.temperature;

import bll.BoolAssess;
import bll.FloatAssessment;

//迷宫环得分
public class LabyrinthRing {
	public int LabyrinthRing(long time){
		
		//下导轴承X轴位移
		FloatAssessment float988=new FloatAssessment();
		int U1=float988.FloatAssess(988,time, 190, 0);
		//下导轴承Y轴位移
		FloatAssessment float994=new FloatAssessment();
		int U2=float994.FloatAssess(994,time, 190, 0);
		
		int a=(U1+U2)/2;
		return a;
		// System.out.println(a);
	}

}

