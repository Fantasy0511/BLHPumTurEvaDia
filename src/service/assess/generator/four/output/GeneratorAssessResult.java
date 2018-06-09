package service.assess.generator.four.output;

/**
 * 发电及励磁系统评估结果
 * @author tiandiwei
 *
 */

public class GeneratorAssessResult {
	private  double excFaultSum;  //励磁故障信号总得分
	private  double excParameter;    //机组监测电气量总得分
	private  double dynamoFault; //发电机故障信号总得分
	private  double temperatureAss;      //温度总得分
	private  double switchAction;  //灭磁开关动作总得分
	private  double score;     //总得分
	
	public GeneratorAssessResult(double excFaultSum, double excParameter, double dynamoFault, double temperatureAss,
			double switchAction, double score) {
		super();
		this.excFaultSum = excFaultSum;
		this.excParameter = excParameter;
		this.dynamoFault = dynamoFault;
		this.temperatureAss = temperatureAss;
		this.switchAction = switchAction;
		this.score = score;
	}
	public double getExcFaultSum() {
		return excFaultSum;
	}
	public double getExcParameter() {
		return excParameter;
	}
	public double getDynamoFault() {
		return dynamoFault;
	}
	public double getTemperatureAss() {
		return temperatureAss;
	}
	public double getSwitchAction() {
		return switchAction;
	}
	public double getScore() {
		return score;
	}
	public void setExcFaultSum(double excFaultSum) {
		this.excFaultSum = excFaultSum;
	}
	public void setExcParameter(double excParameter) {
		this.excParameter = excParameter;
	}
	public void setDynamoFault(double dynamoFault) {
		this.dynamoFault = dynamoFault;
	}
	public void setTemperatureAss(double temperatureAss) {
		this.temperatureAss = temperatureAss;
	}
	public void setSwitchAction(double switchAction) {
		this.switchAction = switchAction;
	}
	public void setScore(double score) {
		this.score = score;
	}
	
	
}
