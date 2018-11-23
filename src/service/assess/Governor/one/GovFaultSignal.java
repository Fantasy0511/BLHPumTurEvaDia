package service.assess.Governor.one;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import bll.BoolAssess;
import bll.FloatAssessment;

//调速故障信号得分
public class GovFaultSignal {

	public static List<Number> calAllScore(long time) {
		List<Number> allScore = new ArrayList<Number>();
		FloatAssessment fa=new FloatAssessment();
		BoolAssess ba = new BoolAssess();
		// 调速电气过速报警
		int U1=ba.BooleanAssess(212, time);
		// 调速机械过速报警
		int U2=ba.BooleanAssess(213, time);
		//调速器邮箱阻塞
		int U3=ba.BooleanAssess(213, time);
		allScore.add(U1);
		allScore.add(U2);
		allScore.add(U3);
		DecimalFormat df=new DecimalFormat("#.0");
		allScore.add(Double.parseDouble(df.format(0.2*U3+0.4*U1+0.4*U2)));
		return allScore;
		
	}


}
