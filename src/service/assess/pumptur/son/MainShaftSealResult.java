package service.assess.pumptur.son;

public class MainShaftSealResult {
	private int waterFlow;  // 供水流量
	private int waterTemperature;  // 供水温度
	private int beforeStress ;  // 前压力
	private int afterStress ;  // 后压力
	private double score ;  // 主进水阀的总分
	
	public MainShaftSealResult(int waterFlow, int waterTemperature, int beforeStress, int afterStress, double score) {
		super();
		this.waterFlow = waterFlow;
		this.waterTemperature = waterTemperature;
		this.beforeStress = beforeStress;
		this.afterStress = afterStress;
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
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	
	
	
	
	
}
