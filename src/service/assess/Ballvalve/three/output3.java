package service.assess.Ballvalve.three;



public class output3 {


	// 3号球阀系统总得分
	public double output3(long time) {
		//球阀油系统性能状态
		Oilsystem3 guideVane = new Oilsystem3();
		double U1 = guideVane.Oilsystem3(time);
		//历史和巡检状态
		histroy3 history = new histroy3();
		double U2 = history.histroy3(time);
		//球阀性能状态
		performance3 mainShaftSeal = new performance3();
		double U3 = mainShaftSeal.performance3(time);
		//球阀系统总得分
		
		double U6 = 0.55 * U1 + 0.1* U2 + 0.35 * U3 ;
		
		return U6;
}
}