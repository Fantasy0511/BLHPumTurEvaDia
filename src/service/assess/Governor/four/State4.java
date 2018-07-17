package service.assess.Governor.four;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import bll.BoolAssess;
import bll.FloatAssessment;

public class State4 {

	//4号机组调速油系统性能状态得分
		public List<Number> getState4(long time){
			DecimalFormat df=new DecimalFormat("#.0");
			List<Number> list = new ArrayList<>();
			//调速器油槽油温
			FloatAssessment float998=new FloatAssessment();
			int U1=float998.FloatAssess(998,time, 100, 20);
			//调速器供油管油压
			FloatAssessment float999=new FloatAssessment();
			int U2=float999.FloatAssess(999,time, 300, 50);
			//压力油罐油位
			FloatAssessment float1000=new FloatAssessment();
			int U3=float1000.FloatAssess(1000,time, 3000, 500);
			//调速器油箱油位高
			BoolAssess bool1180=new BoolAssess();
			int U4=bool1180.BooleanAssess(1180,time);
			
			//补气系统压力罐压力
			BoolAssess bool1181=new BoolAssess();
			int U5=bool1181.BooleanAssess(1181,time);
			
			 
			double score=0.25*U1+0.25*U2+0.2*U3+0.15*U4+0.15*U5;
			score =Double.parseDouble(df.format(score));
			
			list.add(U1);
			list.add(U2);
			list.add(U3);
			list.add(U4);
			list.add(U5);
			list.add(score);
			return list;
		}
}
