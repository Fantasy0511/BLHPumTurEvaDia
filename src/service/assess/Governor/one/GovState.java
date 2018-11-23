package service.assess.Governor.one;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import bll.BoolAssess;
import bll.FloatAssessment;

//调速油系统性能状态得分
public class GovState {
	public static List<Number> calAllScore(long time){
		List<Number> allScore = new ArrayList<Number>();
		FloatAssessment fa=new FloatAssessment();
		BoolAssess ba = new BoolAssess();
		//油槽油温
		int U1=fa.FloatAssess(343, time, 1, 1);
		//供油管油压
		int U2=fa.FloatAssess(344,time,1,1);
		//压力油罐油位
		int U3=fa.FloatAssess(345,time,1,1);
		//调速器邮箱油位低
		int U4=ba.BooleanAssess(216, time);
		//调速器邮箱油位高
		int U5=ba.BooleanAssess(215, time);	
		//调速器补气罐压力高
		int U6=ba.BooleanAssess(207, time);	
		//调速器补气罐压力低
		int U7=ba.BooleanAssess(208, time);
		allScore.add(U1);
		allScore.add(U2);
		allScore.add(U3);
		allScore.add(U4);
		allScore.add(U5);
		allScore.add(U6);
		allScore.add(U7);
		DecimalFormat df=new DecimalFormat("#.0");
		allScore.add(Double.parseDouble(df.format((U1+U2+U3+U4+U5+U6+U7)/7)));
		return allScore;
	}


}
