package service.assess.pumptur.son;

/*
 * 二、三号机组的温度结果变量
 * 
 * */
public class Temperatureresult2 {
	private int upperWater;  //上导冷却水出水温度
	private int upperBearing;  //上导轴瓦温度
	private int upperOil ;  //上导油槽温度
	private int lowerWater ;  //下导冷却水出水温度
	private int lowerBearing;  //下导轴瓦温度
	private int lowerOil;  //下导油槽温度
	
	private double score ;  // 温度平均分

	public Temperatureresult2(int upperWater, int upperBearing, int upperOil, int lowerWater, int lowerBearing,
			int lowerOil, double score) {
		super();
		this.upperWater = upperWater;
		this.upperBearing = upperBearing;
		this.upperOil = upperOil;
		this.lowerWater = lowerWater;
		this.lowerBearing = lowerBearing;
		this.lowerOil = lowerOil;
		this.score = score;
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

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	
	
}
