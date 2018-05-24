package bll.diagnosis.tree.dao;

/**
 * @author xyh
 * @version 创建时间：2016年6月20日 下午4:36:16 故障树结果类
 */
public class FaultTreeResult {
	//String wcstatus;
	String time;
	String result;
	String symptom;
	int unitNo;
	String recommendation;

	//public String getWcstatus() {
	//	return wcstatus;
	//}

	public String getTime() {
		return time;
	}

	public String getResult() {
		return result;
	}

	public String getSymptom() {
		return symptom;
	}

	public int getUnitNo() {
		return unitNo;
	}

//public void setWcstatus(String wcstatus) {
	//	this.wcstatus = wcstatus;
	//}

	public void setTime(String time) {
		this.time = time;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public void setSymptom(String symptom) {
		this.symptom = symptom;
	}

	public void setUnitNo(int unitNo) {
		this.unitNo = unitNo;
	}

	public String getRecommendation() {
		return recommendation;
	}

	public void setRecommendation(String recommendation) {
		this.recommendation = recommendation;
	}

}
