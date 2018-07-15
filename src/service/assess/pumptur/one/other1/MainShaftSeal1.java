package service.assess.pumptur.one.other1;

import bll.BoolAssess;
import bll.FloatAssessment;
import service.assess.pumptur.son.MainShaftSealResult;

//主轴密封得分
public class MainShaftSeal1 {
	private MainShaftSealResult mainShaftSealResult;


	public MainShaftSealResult MainShaftSeal(long time){
		//供水流量
		FloatAssessment float958=new FloatAssessment();
		int U1=float958.FloatAssess(958,time, 452, 0);
		//供水温度
		FloatAssessment float962=new FloatAssessment();
		int U2=float962.FloatAssess(962,time, 190, 0);
		//过滤器前压力
		FloatAssessment float959=new FloatAssessment();
		int U3=float959.FloatAssess(959,time, 190, 0);
		//过滤器后压力
		FloatAssessment float960=new FloatAssessment();
		int U4=float960.FloatAssess(960,time, 190, 0);
		//过滤器451FI故障
		BoolAssess bool1086=new BoolAssess();
		int U5=bool1086.BooleanAssess(1086,time);
		//过滤器452FI故障
		BoolAssess bool1087=new BoolAssess();
		int U6=bool1087.BooleanAssess(1087,time);
		//压差低(L2)
		BoolAssess bool1088=new BoolAssess();
		int U7=bool1088.BooleanAssess(1088,time);
		
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
