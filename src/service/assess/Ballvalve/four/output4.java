package service.assess.Ballvalve.four;



public class output4 {


	// 4号球阀系统总得分
	public double output4(long time) {
		//球阀油系统性能状态
		Oilsystem4 guideVane = new Oilsystem4();
		double U1 = guideVane.Oilsystem4(time);
		//历史和巡检状态
		histroy4 history = new histroy4();
		double U2 = history.histroy4(time);
		//球阀性能状态
		performance4 mainShaftSeal = new performance4();
		double U3 = mainShaftSeal.performance4(time);
		//球阀系统总得分
		
		double U6 = 0.55 * U1 + 0.1* U2 + 0.35 * U3 ;
		
		return U6;
}
}
