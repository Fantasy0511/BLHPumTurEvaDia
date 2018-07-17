package service.assess.pumptur.two.output;

/**
 * 2号机组水泵状态评估结果
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
	
	//温度的底层指标
	private int upperWater;  //上导冷却水出水温度
	private int upperBearing;  //上导轴瓦温度
	private int upperOil ;  //上导油槽温度
	private int lowerWater ;  //下导冷却水出水温度
	private int lowerBearing;  //下导轴瓦温度
	private int lowerOil;  //下导油槽温度
	
	public PumpAssResult(double guideVane, double history, double mainShaftSeal, double swingAss, double temperatureAss,
			double score, int waterFlow, int waterTemperature, int beforeStress, int afterStress, int upperWater,
			int upperBearing, int upperOil, int lowerWater, int lowerBearing, int lowerOil) {
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
		this.upperWater = upperWater;
		this.upperBearing = upperBearing;
		this.upperOil = upperOil;
		this.lowerWater = lowerWater;
		this.lowerBearing = lowerBearing;
		this.lowerOil = lowerOil;
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
	public int getUpperWater() {
		return upperWater;
	}
	public void setUpperWater(int upperWater) {
		this.upperWater = upperWater;
	}
	public int getUpperBearing() {
		return upperBearing;
	}
	public void setUpperBearing(int upperBearing) {
		this.upperBearing = upperBearing;
	}
	public int getUpperOil() {
		return upperOil;
	}
	public void setUpperOil(int upperOil) {
		this.upperOil = upperOil;
	}
	public int getLowerWater() {
		return lowerWater;
	}
	public void setLowerWater(int lowerWater) {
		this.lowerWater = lowerWater;
	}
	public int getLowerBearing() {
		return lowerBearing;
	}
	public void setLowerBearing(int lowerBearing) {
		this.lowerBearing = lowerBearing;
	}
	public int getLowerOil() {
		return lowerOil;
	}
	public void setLowerOil(int lowerOil) {
		this.lowerOil = lowerOil;
	}
	
		
	
}
