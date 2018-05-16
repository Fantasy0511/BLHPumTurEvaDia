package service.assess.generator.one.second;

import bll.FloatAssessment;

//机组监测电气量总得分
public class monitor {

public double monitor(long time){
		
		//有功功率测量值
		FloatAssessment float134=new FloatAssessment();
		int U1=float134.FloatAssess(134,time, 400, 0);
		//励磁电压
		FloatAssessment float146=new FloatAssessment();
		int U2=float146.FloatAssess(146,time, 600, 0);
		//机组频率
		FloatAssessment float161=new FloatAssessment();
		int U3=float161.FloatAssess(161,time, 190, 0);
		double a=(U1+U2+U3)/3;
		return a;
		// System.out.println(a);
	}
}
