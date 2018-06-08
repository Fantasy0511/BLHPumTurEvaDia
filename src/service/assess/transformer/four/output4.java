package service.assess.transformer.four;


public class output4 {
	// 4号机组主变压器总得分
		public double output4(long time) {
			//主变压器温度
			temperature4 guideVane = new temperature4();
			double U1 = guideVane.temperature4(time);
			//历史和巡检状态
			histroy4 history = new histroy4();
			double U2 = history.histroy4(time);
			//主变故障信号
			malfunction4 mainShaftSeal = new malfunction4();
			double U3 = mainShaftSeal.malfunction4(time);
			//球阀系统总得分
			
			double U6 = 0.5 * U1 + 0.1* U2 + 0.4 * U3 ;
			
			return U6;
	}
}
