package service.assess.transformer.two;



public class output2 {

	// 2号机组主变压器总得分
		public double output2(long time) {
			//主变压器温度
			temperature2 guideVane = new temperature2();
			double U1 = guideVane.temperature2(time);
			//历史和巡检状态
			histroy2 history = new histroy2();
			double U2 = history.histroy2(time);
			//主变故障信号
			malfunction2 mainShaftSeal = new malfunction2();
			double U3 = mainShaftSeal.malfunction2(time);
			//球阀系统总得分
			
			double U6 = 0.5 * U1 + 0.1* U2 + 0.4 * U3 ;
			
			return U6;
	}
}
