package service.assess.transformer.one;

import service.assess.transformer.one.frist.Temperature;
import service.assess.transformer.one.second.History;
import service.assess.transformer.one.thrid.Malfunction;

public class TransferAssSum {

	// 主变压器总得分
	public TransferAssResult output(long time) {
		//主变压器温度
		Temperature guideVane = new Temperature();
		double U1 = guideVane.getTemperatures(time);
		//历史和巡检状态
		History history = new History();
		double U2 = history.getHistory(time);
		//主变故障信号
		Malfunction mainShaftSeal = new Malfunction();
		double U3 = mainShaftSeal.getMalfunction(time);
		//主变系统总得分
		double U6 = 0.5 * U1 + 0.1* U2 + 0.4 * U3 ;
		
		TransferAssResult transferAssResult=new TransferAssResult(U1, U2, U3, U6);
		
		return transferAssResult;
}
}
