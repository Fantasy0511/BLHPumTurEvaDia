package Enum;

public enum defectEnum {
	
	DEFECT_DETAIL(0,"缺陷月度情况表"),
	;
	
	private Integer code;
	private String defectEnum;
	
	private defectEnum(Integer code, String defectEnum) {
		this.code = code;
		this.defectEnum = defectEnum;
	}

	public Integer getCode() {
		return code;
	}

	public String getDefectEnum() {
		return defectEnum;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public void setDefectEnum(String defectEnum) {
		this.defectEnum = defectEnum;
	}
		

}
