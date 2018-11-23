package service.assess.Governor.two;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import bll.BoolAssess;
import bll.FloatAssessment;


public class State2 {
//2号机组调速油系统性能状态得分
	public List<Number> getState2(long time){
		List<Number> allScore = new ArrayList<Number>();
		FloatAssessment fa=new FloatAssessment();
		BoolAssess ba = new BoolAssess();
		//调速器油槽油温
		int U1=fa.FloatAssess(562,time, 1, 1);
		//调速器供油管油压
		int U2=fa.FloatAssess(563,time, 1, 1);
		//压力油罐油位
		int U3=fa.FloatAssess(564,time, 3000, 500);
		//调速器油箱油位低
		int U4=ba.BooleanAssess(537,time);
		//调速器油箱油位高
		int U5=ba.BooleanAssess(536,time);
		//调速器补气系统气压罐压力高
		int U6=ba.BooleanAssess(526,time);
		//调速器补气系统气压罐压力低
		int U7=ba.BooleanAssess(527,time);
		allScore.add(U1);
		allScore.add(U2);
		allScore.add(U3);
		allScore.add(U4);
		allScore.add(U5);
		allScore.add(U6);
		allScore.add(U7);
		allScore.add((U1+U2+U3+U4+U5+U6+U7)/7);
		return allScore;
		
		
	}

}
