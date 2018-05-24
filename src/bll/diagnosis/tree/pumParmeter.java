package bll.diagnosis.tree;

public class pumParmeter {
	long  time;
	int  unitType;
	public pumParmeter(long time, int unitType) {
		super();
		this.time = time;
		this.unitType = unitType;
	}
	public long getTime() {
		return time;
	}
	public int getUnitType() {
		return unitType;
	}
	public void setTime(long time) {
		this.time = time;
	}
	public void setUnitType(int unitType) {
		this.unitType = unitType;
	}
	
}
