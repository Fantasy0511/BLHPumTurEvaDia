package service.assess.transformer.one;

import service.assess.transformer.one.frist.temperature;
import service.assess.transformer.one.second.histroy;
import service.assess.transformer.one.thrid.malfunction;

public class TransferAssSum {

	// 主变压器总得分
	public TransferAssResult output(long time) {
		//主变压器温度
		temperature guideVane = new temperature();
		double U1 = guideVane.temperatureA(time);
		//历史和巡检状态
		histroy history = new histroy();
		double U2 = history.histroy(time);
		//主变故障信号
		malfunction mainShaftSeal = new malfunction();
		double U3 = mainShaftSeal.malfunction(time);
		//主变系统总得分
		double U4 = 0.5 * U1 + 0.1* U2 + 0.4 * U3 ;
		
		TransferAssResult transferAssResult=new TransferAssResult(U1, U2, U3, U4);
		
		return transferAssResult;
}
}
