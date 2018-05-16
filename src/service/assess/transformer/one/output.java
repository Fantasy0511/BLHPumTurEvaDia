package service.assess.transformer.one;



import service.assess.transformer.one.frist.temperature;
import service.assess.transformer.one.second.histroy;
import service.assess.transformer.one.thrid.malfunction;

public class output {

	// 主变压器总得分
	public double output(long time) {
		//主变压器温度
		temperature guideVane = new temperature();
		double U1 = guideVane.temperature(time);
		//历史和巡检状态
		histroy history = new histroy();
		double U2 = history.histroy(time);
		//主变故障信号
		malfunction mainShaftSeal = new malfunction();
		double U3 = mainShaftSeal.malfunction(time);
		//球阀系统总得分
		
		double U6 = 0.5 * U1 + 0.1* U2 + 0.4 * U3 ;
		
		return U6;
}
}
