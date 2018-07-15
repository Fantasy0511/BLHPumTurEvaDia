package service.assess.pumptur.two.output;

/**
 * 水泵状态评估结果
 * 
 * @author wuyue
 *
 */
public class PumpAssResult {
	private double guideVane;
	private double history;
	private double mainShaftSeal;
	private double swingAss;
	private double temperatureAss;
	private double score;

	// 主进水阀的底层指标
	private int waterFlow; // 供水流量
	private int waterTemperature; // 供水温度
	private int beforeStress; // 前压力
	private int afterStress; // 后压力

	public PumpAssResult(double guideVane, double history, double mainShaftSeal, double swingAss, double temperatureAss,
			double score, int waterFlow, int waterTemperature, int beforeStress, int afterStress) {
		super();
		this.guideVane = guideVane;
		this.history = history;
		this.mainShaftSeal = mainShaftSeal;
		this.swingAss = swingAss;
		this.temperatureAss = temperatureAss;
		this.score = score;
		this.waterFlow = waterFlow;
		this.waterTemperature = waterTemperature;
		this.beforeStress = beforeStress;
		this.afterStress = afterStress;
	}

	public double getGuideVane() {
		return guideVane;
	}

	public void setGuideVane(double guideVane) {
		this.guideVane = guideVane;
	}

	public double getHistory() {
		return history;
	}

	public void setHistory(double history) {
		this.history = history;
	}

	public double getMainShaftSeal() {
		return mainShaftSeal;
	}

	public void setMainShaftSeal(double mainShaftSeal) {
		this.mainShaftSeal = mainShaftSeal;
	}

	public double getSwingAss() {
		return swingAss;
	}

	public void setSwingAss(double swingAss) {
		this.swingAss = swingAss;
	}

	public double getTemperatureAss() {
		return temperatureAss;
	}

	public void setTemperatureAss(double temperatureAss) {
		this.temperatureAss = temperatureAss;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public int getWaterFlow() {
		return waterFlow;
	}

	public void setWaterFlow(int waterFlow) {
		this.waterFlow = waterFlow;
	}

	public int getWaterTemperature() {
		return waterTemperature;
	}

	public void setWaterTemperature(int waterTemperature) {
		this.waterTemperature = waterTemperature;
	}

	public int getBeforeStress() {
		return beforeStress;
	}

	public void setBeforeStress(int beforeStress) {
		this.beforeStress = beforeStress;
	}

	public int getAfterStress() {
		return afterStress;
	}

	public void setAfterStress(int afterStress) {
		this.afterStress = afterStress;
	}

}
