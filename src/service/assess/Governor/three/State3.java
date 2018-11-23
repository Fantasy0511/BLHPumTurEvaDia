package service.assess.Governor.three;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import bll.BoolAssess;
import bll.FloatAssessment;

public class State3 {

	//3号机组调速油系统性能状态得分
		public List<Number> getState3(long time){
			List<Number> allScore = new ArrayList<Number>();
			FloatAssessment fa=new FloatAssessment();
			BoolAssess ba = new BoolAssess();
			//调速器油槽油温
			int U1=fa.FloatAssess(781,time, 1, 1);
			//调速器供油管油压
			int U2=fa.FloatAssess(782,time, 1, 1);
			//压力油罐油位
			int U3=fa.FloatAssess(783,time, 3000, 500);
			//调速器油箱油位低
			int U4=ba.BooleanAssess(862,time);
			//调速器油箱油位高
			int U5=ba.BooleanAssess(861,time);
			//调速器补气系统气压罐压力高
			int U6=ba.BooleanAssess(852,time);
			//调速器补气系统气压罐压力低
			int U7=ba.BooleanAssess(853,time);
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
