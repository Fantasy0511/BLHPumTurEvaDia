package service.assess.pumptur.one.output;

/**
 * 1号机组水泵状态评估结果
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
	
	//主轴密封的底层指标
	private int waterFlow;  // 供水流量
	private int waterTemperature;  // 供水温度
	private int beforeStress ;  // 前压力
	private int afterStress ;  // 后压力
	
	//温度的底层指标
	private int generatorRotor;  //转子温度
	private int labyrinthRing;  //上、下迷宫环温度
	private int lowerBearing ;  //下导轴承温度
	private int statorCoil ;  //定子线圈温度
	private int statorCore;  //定子铁芯温度
	private int thrustBearing;  // 推力轴承发电温度
	private int upperBearing ;  // 上导轴承温度
	private int waterBearing ;  // 水导轴承温度
	
	
	public PumpAssResult(double guideVane, double history, double mainShaftSeal, double swingAss, double temperatureAss,
			double score, int waterFlow, int waterTemperature, int beforeStress, int afterStress, int generatorRotor,
			int labyrinthRing, int lowerBearing, int statorCoil, int statorCore, int thrustBearing, int upperBearing,
			int waterBearing) {
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
		this.generatorRotor = generatorRotor;
		this.labyrinthRing = labyrinthRing;
		this.lowerBearing = lowerBearing;
		this.statorCoil = statorCoil;
		this.statorCore = statorCore;
		this.thrustBearing = thrustBearing;
		this.upperBearing = upperBearing;
		this.waterBearing = waterBearing;
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
	public int getGeneratorRotor() {
		return generatorRotor;
	}
	public void setGeneratorRotor(int generatorRotor) {
		this.generatorRotor = generatorRotor;
	}
	public int getLabyrinthRing() {
		return labyrinthRing;
	}
	public void setLabyrinthRing(int labyrinthRing) {
		this.labyrinthRing = labyrinthRing;
	}
	public int getLowerBearing() {
		return lowerBearing;
	}
	public void setLowerBearing(int lowerBearing) {
		this.lowerBearing = lowerBearing;
	}
	public int getStatorCoil() {
		return statorCoil;
	}
	public void setStatorCoil(int statorCoil) {
		this.statorCoil = statorCoil;
	}
	public int getStatorCore() {
		return statorCore;
	}
	public void setStatorCore(int statorCore) {
		this.statorCore = statorCore;
	}
	public int getThrustBearing() {
		return thrustBearing;
	}
	public void setThrustBearing(int thrustBearing) {
		this.thrustBearing = thrustBearing;
	}
	public int getUpperBearing() {
		return upperBearing;
	}
	public void setUpperBearing(int upperBearing) {
		this.upperBearing = upperBearing;
	}
	public int getWaterBearing() {
		return waterBearing;
	}
	public void setWaterBearing(int waterBearing) {
		this.waterBearing = waterBearing;
	}
	
	

	

}
