package service.faulttree;

/**
 * 构造故障树返回结果
 * 
 * @author 武越
 * 
 */
public class FaultTreeResult {
	private int[] resultID;

	public FaultTreeResult(int[] resultID) {
		super();
		this.resultID = resultID;
	}

	public int[] getResultID() {
		return resultID;
	}

	public void setResultID(int[] resultID) {
		this.resultID = resultID;
	}
}
