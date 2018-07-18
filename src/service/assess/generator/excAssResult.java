package service.assess.generator;

import java.util.List;

/**
 * 发电励磁系统评估结果数据模型
 * @author tiandiwei
 *
 */
public class excAssResult {
	private List<Number> Indicator;  //所有指标获取
	/*private List<Number> eleFaultIndicator; //励磁故障信号底层指标
	private List<Number> monEleIndicator; //机组监测电气量底层指标
	private List<Number> faultIndicator; //发电机故障信号底层指标
	private List<Number> tempIndicator; //温度底层指标底层指标
	private List<Number> degaIndicator; //灭磁开关动作底层指标
*/

	public List<Number> getIndicator() {
		return Indicator;
	}

	public excAssResult(List<Number> indicator) {
		super();
		Indicator = indicator;
	}

	public void setIndicator(List<Number> indicator) {
		Indicator = indicator;
	}	

}
