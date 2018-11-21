package service.assess.pumptur.one.other1;

import bll.BoolAssess;
import bll.FloatAssessment;
import service.assess.pumptur.son.MainShaftSealResult;

//主轴密封得分
public class MainShaftSeal1 {
	private MainShaftSealResult mainShaftSealResult;


	public MainShaftSealResult MainShaftSeal(long time){
		//供水流量
		FloatAssessment float303 = new FloatAssessment();
		int U1 = float303.FloatAssess(303, time, 452, 0);
		//供水温度
		FloatAssessment float307 = new FloatAssessment();
		int U2 = float307.FloatAssess(307, time, 190, 0);
		//过滤器前压力
		FloatAssessment float304 = new FloatAssessment();
		int U3 = float304.FloatAssess(304, time, 190, 0);
		//过滤器后压力
		FloatAssessment float305 = new FloatAssessment();
		int U4 = float305.FloatAssess(305, time, 190, 0);
		//过滤器451FI故障
		BoolAssess bool118 = new BoolAssess();
		int U5 = bool118.BooleanAssess(118, time);
		//过滤器452FI故障
		BoolAssess bool119 = new BoolAssess();
		int U6 = bool119.BooleanAssess(119, time);
		//压差低(L2)
		BoolAssess bool120 = new BoolAssess();
		int U7 = bool120.BooleanAssess(120, time);
		
		double a=(U1+U2+U3+U4+U5+U6+U7)/7;
		
		System.out.println("**************************");
		System.out.println("1号机组水泵水轮机主轴密封总得分及各项");
		System.out.println("供水流量："+U1);
		System.out.println("供水温度："+U2);
		System.out.println("过滤器前压力："+U3);
		System.out.println("过滤器后压力："+U4);
		System.out.println("过滤器451FI故障："+U5);
		System.out.println("过滤器452FI故障："+U6);
		System.out.println("压差低(L2)："+U7);
		System.out.println("平均分："+a);
		System.out.println("**************************");
		
		MainShaftSealResult mainShaftSealResult = new MainShaftSealResult(U1, U2, U3, U4, a);
		
		return mainShaftSealResult;
	}
	
	public MainShaftSealResult getMainShaftSealResult() {
		return mainShaftSealResult;
	}


	public void setMainShaftSealResult(MainShaftSealResult mainShaftSealResult) {
		this.mainShaftSealResult = mainShaftSealResult;
	}
}
