package service.assess.pumptur.son;

/*
 * 一、四号机组的温度结果变量
 * */

public class Temperatureresult1 {
	private int generatorRotor;  //转子温度
	private int labyrinthRing;  //上、下迷宫环温度
	private int lowerBearing ;  //下导轴承温度
	private int statorCoil ;  //定子线圈温度
	private int statorCore;  //定子铁芯温度
	private int thrustBearing;  // 推力轴承发电温度
	private int upperBearing ;  // 上导轴承温度
	private int waterBearing ;  // 水导轴承温度
	
	private int score ;  // 温度平均分

	public Temperatureresult1(int generatorRotor, int labyrinthRing, int lowerBearing, int statorCoil, int statorCore,
			int thrustBearing, int upperBearing, int waterBearing, int score) {
		super();
		this.generatorRotor = generatorRotor;
		this.labyrinthRing = labyrinthRing;
		this.lowerBearing = lowerBearing;
		this.statorCoil = statorCoil;
		this.statorCore = statorCore;
		this.thrustBearing = thrustBearing;
		this.upperBearing = upperBearing;
		this.waterBearing = waterBearing;
		this.score = score;
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

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
}
