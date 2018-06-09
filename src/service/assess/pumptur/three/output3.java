package service.assess.pumptur.three;


/*没用到*/
public class output3 {
	//3号机组水泵水轮机总得分
	

	
	public double output3(long time) {
		//3号机组导叶得分
		Vibration3 guideVane = new Vibration3();
		double U1 = guideVane.Vibration3(time);
		//3号机组水泵水轮机温度总得分
		temperature3 history = new temperature3();
		double U2 = history.temperature3(time);
		//3号机组主轴密封得分
		MainShaftSeal3 mainShaftSeal = new MainShaftSeal3();
		double U3 = mainShaftSeal.MainShaftSeal3(time);
		//3号机组振动得分
		GuideVane3 swingAss = new GuideVane3();
		double U4 = swingAss.GuideVane3(time);
		//3号机历史和巡检状态
		histroy3 temperatureAss = new histroy3();
		double U5 = temperatureAss.histroy3(time);
		// 正常来说权重比例应该是由判断矩阵算出来的
		double U6 = 0.263 * U1 + 0.419 * U2 + 0.160 * U3 + 0.097 * U4
				+ 0.062* U5;
		
		return U6;
	}

}
