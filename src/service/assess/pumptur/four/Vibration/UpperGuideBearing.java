package service.assess.pumptur.four.Vibration;

import bll.BoolAssess;
import bll.FloatAssessment;
//上导轴承得分
public class UpperGuideBearing {
	
	public int UpperGuideBearing(long time){
	//上导轴承X轴摆动跳闸 
		
	BoolAssess bool977=new BoolAssess();
	int U1=bool977.BooleanAssess(977,time);
	
	//上导轴承Y轴摆动跳闸 
	BoolAssess bool978=new BoolAssess();
	int U2=bool978.BooleanAssess(978,time);
	
	//上导轴承X轴位移
	FloatAssessment float838=new FloatAssessment();
	int U3=float838.FloatAssess(838,time, 800, 0);
	//上导轴承Y轴位移
	FloatAssessment float839=new FloatAssessment();
	int U4=float839.FloatAssess(839,time, 800, 0);
	
	int a=(U1+U2+U3+U4)/4;
	return a;
	// System.out.println(a);

}
	public static void main(String[] args) {
		UpperGuideBearing b=new UpperGuideBearing();
	int c=	b.UpperGuideBearing(1325380000);
	
	
		System.out.println(c);
	}
}