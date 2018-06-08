package service.assess.transformer.three;



public class output3 {
	// 3号机组主变压器总得分
		public double output3(long time) {
			//主变压器温度
			temperature3 guideVane = new temperature3();
			double U1 = guideVane.temperature3(time);
			//历史和巡检状态
			histroy3 history = new histroy3();
			double U2 = history.histroy3(time);
			//主变故障信号
			malfunction3 mainShaftSeal = new malfunction3();
			double U3 = mainShaftSeal.malfunction3(time);
			//球阀系统总得分
			
			double U6 = 0.5 * U1 + 0.1* U2 + 0.4 * U3 ;
			
			return U6;
	}
}
