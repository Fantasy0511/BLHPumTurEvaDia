package service.faultWarning.Result;

import java.util.List;

public class faultParaData {
	private List<String>  faultName;
	private List<String>  number;
	private List<String>  ID;
	private List<String>  Llimite;
	private List<String>  Hlimite;


	public faultParaData(List<String> faultName, List<String> number, List<String> iD) {
		super();
		this.faultName = faultName;
		this.number = number;
		ID = iD;
	}
	
	
	public faultParaData(List<String> faultName, List<String> number, List<String> llimite,
			List<String> hlimite,List<String> iD) {
		super();
		this.faultName = faultName;
		this.number = number;
		ID = iD;
		Llimite = llimite;
		Hlimite = hlimite;
	}


	public List<String> getLlimite() {
		return Llimite;
	}

	public List<String> getHlimite() {
		return Hlimite;
	}

	public void setLlimite(List<String> llimite) {
		Llimite = llimite;
	}

	public void setHlimite(List<String> hlimite) {
		Hlimite = hlimite;
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
