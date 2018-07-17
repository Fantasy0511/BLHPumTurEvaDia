package service.assess.pumptur.three;

import bll.BoolAssess;
import bll.FloatAssessment;
import service.assess.pumptur.son.MainShaftSealResult;

public class MainShaftSeal3 {

	//3号机组水泵水轮机主轴密封得分
	public MainShaftSealResult getMainShaftSeal3(long time){
		//供水流量
		FloatAssessment float752=new FloatAssessment();
		int U1=float752.FloatAssess(752,time, 452, 0);
		//供水温度
		FloatAssessment float756=new FloatAssessment();
		int U2=float756.FloatAssess(756,time, 190, 20);
		//过滤器前压力
		FloatAssessment float753=new FloatAssessment();
		int U3=float753.FloatAssess(753,time, 190, 0);
		//过滤器后压力
		FloatAssessment float754=new FloatAssessment();
		int U4=float754.FloatAssess(754,time, 190, 0);
		//过滤器故障报警
		BoolAssess bool758=new BoolAssess();
		int U5=bool758.BooleanAssess(758,time);
		//过滤器压差报警
		BoolAssess bool759=new BoolAssess();
		int U6=bool759.BooleanAssess(759,time);
		
		
		
		double a=(U1+U2+U3+U4+U5+U6)/6;
		MainShaftSealResult mainShaftSealResult = new MainShaftSealResult(U1, U2, U3, U4, a);
		
		return mainShaftSealResult;
		}
}
