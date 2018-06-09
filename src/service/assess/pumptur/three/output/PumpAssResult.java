package service.assess.pumptur.three.output;

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

	public PumpAssResult(double guideVane, double history, double mainShaftSeal,
			double swingAss, double temperatureAss, double score) {
		super();
		this.guideVane = guideVane;
		this.history = history;
		this.mainShaftSeal = mainShaftSeal;
		this.swingAss = swingAss;
		this.temperatureAss = temperatureAss;
		this.score = score;
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

}
