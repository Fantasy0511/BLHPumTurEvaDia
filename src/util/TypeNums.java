package util;

/**
 * 每个类型的测点数量枚举类
 * @author lh
 * */
public enum TypeNums {
	BOOL(2568),DOUBLE(29),FLOAT(1452);
	
	private int nums;
	private TypeNums(int nums) {
		this.nums = nums;
	}
	public int getNums() {
		return nums;
	}
	public void setNums(int nums) {
		this.nums = nums;
	}
	
}
