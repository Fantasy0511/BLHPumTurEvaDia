package service.assess.pumptur.two;


/*没用*/
public class output2 {
	//2号机组水泵水轮机总得分

	public double output3(long time) {
		//3号机组水泵水轮机导叶得分
		Vibration2 guideVane = new Vibration2();
		double U1 = guideVane.Vibration2(time);
		//3号机组水泵水轮机温度总得分
		temperature2 history = new temperature2();
		double U2 = history.temperature2(time);
		//3号机组主轴密封得分
		MainShaftSeal2 mainShaftSeal = new MainShaftSeal2();
		double U3 = mainShaftSeal.MainShaftSeal2(time);
		//3号机组水泵水轮机振动得分
		GuideVane2 swingAss = new GuideVane2();
		double U4 = swingAss.GuideVane2(time);
		//3号机历史和巡检状态
		histroy2 temperatureAss = new histroy2();
		double U5 = temperatureAss.histroy2(time);
		// 正常来说权重比例应该是由判断矩阵算出来的
		double U6 = 0.263 * U1 + 0.419 * U2 + 0.160 * U3 + 0.097 * U4
				+ 0.062* U5;
		
		return U6;
	}
}
