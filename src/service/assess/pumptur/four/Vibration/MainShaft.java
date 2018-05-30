package service.assess.pumptur.four.Vibration;

import bll.BoolAssess;
import bll.FloatAssessment;
//主轴得分
public class MainShaft {
	public int MainShaft(long time){
		//主轴X轴摆动跳闸 
			
		BoolAssess bool1094=new BoolAssess();
		int U1=bool1094.BooleanAssess(1094,time);
		
		//主轴Y轴摆动跳闸 
		BoolAssess bool1095=new BoolAssess();
		int U2=bool1095.BooleanAssess(1095,time);
		
		//主轴X轴位移
		FloatAssessment float981=new FloatAssessment();
		int U3=float981.FloatAssess(981,time, 800, 0);
		//主轴Y轴位移
		FloatAssessment float982=new FloatAssessment();
		int U4=float982.FloatAssess(982,time, 800, 0);
		
		int a=(U1+U2+U3+U4)/4;
		return a;
		// System.out.println(a);
	}
}
