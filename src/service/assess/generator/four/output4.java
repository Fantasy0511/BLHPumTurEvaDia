package service.assess.generator.four;



public class output4 {

	//4号机组励磁故障信号、机组监测电气量、发电电动机故障信号、温度指标和灭磁开关

			// 发电电动机总得分
			public double output4(long time) {
				//励磁故障信号总得分
				electricity4 guideVane = new electricity4();
				double U1 = guideVane.electricity4(time);
				//机组监测电气量总得分
				monitor4 history = new monitor4();
				double U2 = history.monitor4(time);
				//发电机故障信号总得分
				malfunction4 mainShaftSeal = new malfunction4();
				double U3 = mainShaftSeal.malfunction4(time);
				//温度总得分
				temperature4 swingAss = new temperature4();
				double U4 = swingAss.temperature4(time);
				//灭磁开关动作总得分
				Degauss4 temperatureAss = new Degauss4();
				double U5 = temperatureAss.Degauss4(time);
				// 正常来说权重比例应该是由判断矩阵算出来的
				double U6 = 0.475 * U1 + 0.055 * U2 + 0.110 * U3 + 0.090 * U4
						+ 0.263 * U5;
				
				return U6;
			}
}
