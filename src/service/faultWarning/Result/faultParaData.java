package service.faultWarning.Result;

import java.util.List;

public class faultParaData {
	private List<String>  faultName;
	private List<String>  number;
	private List<String>  ID;

	public faultParaData(List<String> faultName, List<String> number, List<String> iD) {
		super();
		this.faultName = faultName;
		this.number = number;
		ID = iD;
	}
	public List<String> getFaultName() {
		return faultName;
	}
	public List<String> getNumber() {
		return number;
	}
	public List<String> getID() {
		return ID;
	}
	public void setFaultName(List<String> faultName) {
		this.faultName = faultName;
	}
	public void setNumber(List<String> number) {
		this.number = number;
	}
	public void setID(List<String> iD) {
		ID = iD;
	}
	
	

}
